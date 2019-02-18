package net.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.board.domain.boardVO;
import net.board.persistence.boardDAO;

@Service
public class boardServiceImpl implements boardService {
	
	@Autowired
	private final boardDAO boardDAO;

	@Inject
	public boardServiceImpl(boardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	
	@Override
	public void create(boardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.create(boardVO);
	}

	@Override
	public boardVO read(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.read(boardNo);
	}

	@Override
	public void update(boardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.update(boardVO);
	}

	@Override
	public void delete(Integer boardNo) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.delete(boardNo);
	}

	@Override
	public List<boardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.listAll();
	}
}