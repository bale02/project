package net.board.service;

import java.util.List;

import net.board.domain.boardVO;
import net.commons.paging.Criteria;

public interface boardService {
	void create(boardVO boardVO) throws Exception;
	
	boardVO read(Integer board_no) throws Exception;
	
	void update(boardVO boardVO) throws Exception;
	
	void delete(Integer board_no) throws Exception;
	
	List<boardVO> listAll() throws Exception;
	
	List<boardVO> listCriteria(Criteria criteria) throws Exception;
	
	int count(String skey,String sval) throws Exception;
	
	int count() throws Exception;
	
	List<boardVO> listSearch(Criteria criteria) throws Exception;
}
