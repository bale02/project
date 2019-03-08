package net.reply.service;

import java.util.List;

import net.reply.domain.bookreplyVO;

public interface bookreplyService {
	List<bookreplyVO> list(Integer book_No)throws Exception;
	
	void create(bookreplyVO bookreplyVO) throws Exception;
	
	void update(bookreplyVO bookreplyVO) throws Exception;
	
	void delete(Integer reply_No) throws Exception;
	
	int count(Integer book_No)throws Exception;

}