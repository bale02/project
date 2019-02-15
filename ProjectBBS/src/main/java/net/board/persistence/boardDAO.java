package net.board.persistence;

import java.util.List;

import net.board.domain.boardVO;

public interface boardDAO {
	void create(boardVO boardVO) throws Exception;
	
	boardVO read(Integer boardNo) throws Exception;
	
	void update(boardVO boardVO) throws Exception;
	
	void delete(Integer boardNo) throws Exception;
	
	List<boardVO> listAll() throws Exception;
}
