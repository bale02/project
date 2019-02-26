package net.board.persistence;

import java.util.List;

public interface boardFileDAO {
	void addFile(String fullName) throws Exception;
	
	List<String> getBoardFiles(Integer board_No) throws Exception;
	
	void deleteFiles(Integer board_No) throws Exception;
	
	void deleteFile(String fileName) throws Exception;
	
	void replaceFile(String fileName,Integer board_No) throws Exception;
	
	void updateFileCnt(Integer board_No) throws Exception;
}
