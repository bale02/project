package net.commons.util;


import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import org.imgscalr.Scalr;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadFileUtils {
	public static String uploadFile(MultipartFile file, HttpServletRequest request) throws Exception{
		
		String originalFileName = file.getOriginalFilename(); // 파일명
		byte[] fileData = file.getBytes();
		
		// 파일명 중복 방지 처리 
		String uuidFileName = getUuidFileName(originalFileName);
		
		// 파일 업로드 경로 설정 
		
		String rootPath = getRootPath(originalFileName,request); // 기본경로 추출 
		String datePath = getDatePath(rootPath);
		
		// 서버에 파일 저장
		
		File target = new File(rootPath + datePath, uuidFileName); //파일 객체 생성
		FileCopyUtils.copy(fileData, target);
		
		// 이미지 파일인 경우 썸네일 이미지 생성 
		
		if(MediaUtils.getMediaType(originalFileName) != null) {
			uuidFileName = makeThumbnail(rootPath,datePath,uuidFileName);
		}
		
		// 파일 경로 치환 
		return replaceSavedFilePath(datePath,uuidFileName);
		
	}
	
	// 파일 삭제 처리 
	public static void deleteFile(String fileName, HttpServletRequest request) {
		
		String rootPath = getRootPath(fileName, request); //기본경로 추출
		
		// 원본 이미지파일삭제 
		
		MediaType mediaType = MediaUtils.getMediaType(fileName);
		if(mediaType != null) {
			String originalImg = fileName.substring(0,12) + fileName.substring(14);
			new File(rootPath + originalImg.replace('/', File.separatorChar)).delete();
		}
		
		// 파일 삭제 
		new File(rootPath + fileName.replace('/', File.separatorChar)).delete();
	}
	
	//파일 출력을 위한 HttpHeader 설정 
	public static HttpHeaders getHttpHeaders(String fileName) throws Exception{
		
		MediaType mediaType = MediaUtils.getMediaType(fileName); // 파일 타입 체크
		HttpHeaders httpHeaders = new HttpHeaders();
		
		// 이미지파일이면 
		if(mediaType != null) {
			httpHeaders.setContentType(mediaType);
			return httpHeaders;
		}
		
		fileName = fileName.substring(fileName.indexOf("_")+1); // UUID 제거 
		httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM); // 다운로드 Mime 타임 설정 
		// 파일명 한글 인코딩 처리 
		httpHeaders.add("Content-Disposition",
				"attachment; filename=\""+new String(fileName.getBytes("UTF-8"),
						"ISO-8859-1")+"\"");
		return httpHeaders;
	}
	// 기본 경로 추출 
	public static String getRootPath(String originalFileName, HttpServletRequest request) {
		// TODO Auto-generated method stub
		String rootPath = "/resources/upload";
		MediaType mediaType = MediaUtils.getMediaType(originalFileName);
		if(mediaType != null) {
			return request.getSession().getServletContext().getRealPath(rootPath+"/images"); //이미지파일 경로 
		}
		return request.getSession().getServletContext().getRealPath(rootPath +"/files");
	}
	
	//날짜 폴더명 추출 
	public static String getDatePath(String rootPath) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		String yearPath = File.separator + calendar.get(Calendar.YEAR);
		String monthPath = yearPath + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.MONTH) + 1);
		String datePath = monthPath + File.separator + new DecimalFormat("00").format(calendar.get(Calendar.DATE));
		
		makeDateDir(rootPath,yearPath,monthPath,datePath);
		
		return datePath;
	}
	//날짜별 폴더 생성 
	public static void makeDateDir(String rootPath, String ... Paths) {
		// TODO Auto-generated method stub
		if(new File(rootPath+Paths[Paths.length -1]).exists()){
			return;	
		}
		
		for(String path : Paths) {
			File dirPath = new File(rootPath + path);
			if(!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
		
	}
	//파일 저장 경로 치환 
	public static String replaceSavedFilePath(String datePath, String uuidFileName) {
		// TODO Auto-generated method stub
		String savedFilePath = datePath + File.separator + uuidFileName;
		return savedFilePath.replace(File.separatorChar, '/');
	}


	//파일명 중복처리 방지 
	public static String getUuidFileName(String originalFileName) {
		// TODO Auto-generated method stub
		return UUID.randomUUID().toString() + "_" + originalFileName;
	}
	
	public static String makeThumbnail(String rootPath, String datePath, String uuidFileName) throws Exception {
		// TODO Auto-generated method stub
		//원본 이미지를 메모리상에 로딩
		BufferedImage originalImg = ImageIO.read(new File(rootPath+datePath, uuidFileName));
		//원본 이미지를 축소 
		BufferedImage thumbnailImg = Scalr.resize(originalImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);
		//썸네일 파일명
		String thumnailImgName = "s_" + uuidFileName;
		//썸네일 업로드 경로 
		String fullPath = rootPath + datePath + File.separator + thumnailImgName;
		//썸네일 파일 객체 생성 
		File newFile = new File(fullPath);
		//썸네일 파일 확장자 추출
		String formatName = MediaUtils.getFormatName(uuidFileName);
		//썸네일 파일 저장
		ImageIO.write(thumbnailImg, formatName, newFile);
		
		return thumnailImgName;
		
		
		
	}
}
