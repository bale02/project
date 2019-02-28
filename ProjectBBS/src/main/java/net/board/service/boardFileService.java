package net.board.service;

import java.util.List;

public interface boardFileService {
	List<String> getboardFiles(Integer board_No) throws Exception;
	
	void deleteFile(String fileName,Integer board_No) throws Exception;
}
