package net.board.persistence;

import java.util.List;

import net.board.domain.boardVO;
import net.commons.paging.Criteria;

public interface boardDAO {
	void create(boardVO boardVO) throws Exception;
	
	boardVO read(Integer board_No) throws Exception;
	
	void update(boardVO boardVO) throws Exception;
	
	void delete(Integer board_No) throws Exception;
	
	List<boardVO> listAll() throws Exception;
	
	List<boardVO> listPaging(int page) throws Exception;
	
	List<boardVO> listCriteria(Criteria criteria) throws Exception;
	
	int count(String skey,String sval) throws Exception;
	
	int count() throws Exception;
	
	List<boardVO> listSearch(Criteria criteria) throws Exception;
	
	void updateReplyCnt(Integer board_No,int amount) throws Exception;
	
	void updateViewCnt(Integer board_No) throws Exception;
}
