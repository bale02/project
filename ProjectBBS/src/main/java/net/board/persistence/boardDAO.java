package net.board.persistence;

import java.util.List;

import net.board.domain.boardVO;
import net.commons.paging.Criteria;

public interface boardDAO {
	void create(boardVO boardVO) throws Exception;
	
	boardVO read(Integer board_no) throws Exception;
	
	void update(boardVO boardVO) throws Exception;
	
	void delete(Integer board_no) throws Exception;
	
	List<boardVO> listAll() throws Exception;
	
	List<boardVO> listPaging(int page) throws Exception;
	
	List<boardVO> listCriteria(Criteria criteria) throws Exception;
}
