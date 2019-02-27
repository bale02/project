package net.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.board.persistence.boardFileDAO;

@Service
public class boardFileServiceImpl implements boardFileService{
	
	@Autowired
	private final boardFileDAO boardFileDAO;
	
	@Inject
	public boardFileServiceImpl(boardFileDAO boardFileDAO) {
		// TODO Auto-generated constructor stub
		this.boardFileDAO = boardFileDAO;
	}
	
	@Override
	public List<String> getboardFiles(Integer board_No) throws Exception {
		// TODO Auto-generated method stub
		return boardFileDAO.getBoardFiles(board_No);
	}

	@Override
	public void deleteFile(String fileName, Integer board_No) throws Exception {
		// TODO Auto-generated method stub
		boardFileDAO.deleteFile(fileName);
		boardFileDAO.updateFileCnt(board_No);
		
	}

}
