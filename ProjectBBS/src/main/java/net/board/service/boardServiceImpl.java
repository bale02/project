package net.board.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.board.domain.boardVO;
import net.board.persistence.boardDAO;
import net.commons.paging.Criteria;

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
	public boardVO read(Integer board_no) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.read(board_no);
	}

	@Override
	public void update(boardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.update(boardVO);
	}

	@Override
	public void delete(Integer board_no) throws Exception {
		// TODO Auto-generated method stub
		boardDAO.delete(board_no);
	}

	@Override
	public List<boardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.listAll();
	}

	@Override
	public List<boardVO> listCriteria(Criteria criteria) throws Exception {
		
		return boardDAO.listCriteria(criteria);
	}

	@Override
	public int count(String skey,String sval) throws Exception {
		
		return boardDAO.count(skey,sval);
	}

	@Override
	public int count() throws Exception {
		
		return boardDAO.count();
	}

	@Override
	public List<boardVO> listSearch(Criteria criteria) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.listSearch(criteria);
	}
}
