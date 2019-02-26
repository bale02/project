package net.board.domain;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import net.board.service.boardFileService;
import net.commons.util.UploadFileUtils;

@RestController
public class BoardFileController {
	private final boardFileService boardFileService;
	
	@Inject
	public BoardFileController(boardFileService boardFileService) {
		this.boardFileService = boardFileService;
	}
	
	@RequestMapping(value = "/file_Upload",method = RequestMethod.POST,produces="text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadFile(MultipartFile file,HttpServletRequest request){
		ResponseEntity<String> entity = null;
		try {
			String savedFilePath = UploadFileUtils.uploadFile(file,request);
			entity = new ResponseEntity<String>(savedFilePath,HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/display",method = RequestMethod.GET)
	public ResponseEntity<byte[]> displayFile(String fileName,HttpServletRequest request) throws Exception{
		
		HttpHeaders httpHeaders = UploadFileUtils.getHttpHeaders(fileName); // http헤더 설정 가져오기
		String rootPath = UploadFileUtils.getRootPath(fileName, request);
		
		ResponseEntity<byte[]> entity = null;
		
		//파일 데이터, HttpHeader 전송 
		
		try(InputStream inputStream = new FileInputStream(rootPath + fileName)) {
			entity = new ResponseEntity<byte[]>(IOUtils.toByteArray(inputStream),httpHeaders,HttpStatus.CREATED);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<byte[]>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/file_Delete",method= RequestMethod.POST)
	public ResponseEntity<String> deleteFile(String fileName,HttpServletRequest request){
		ResponseEntity<String> entity = null;
		
		try {
			UploadFileUtils.deleteFIle(fileName, request);
			entity = new ResponseEntity<String>("DELETED",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity= new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/file_List/{board_No}", method=RequestMethod.GET)
	public ResponseEntity<List<String>> getFiles(@PathVariable("board_No") Integer board_No){
		ResponseEntity<List<String>> entity = null;
		try {
			List<String> fileList = boardFileService.getboardFiles(board_No);
			entity = new ResponseEntity<List<String>>(fileList,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<List<String>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/file_DeleteAll",method=RequestMethod.POST)
	public ResponseEntity<String> deleteAllFiles(@RequestParam("files[]") String[] files,HttpServletRequest request){
		if(files == null || files.length ==0) {
			return new ResponseEntity<String>("DELETED",HttpStatus.OK);
		}
		ResponseEntity<String> entity =null;
		try {
			for(String fileName : files) {
				UploadFileUtils.deleteFIle(fileName, request);
			}
			entity = new ResponseEntity<String>("DELETED",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
}
