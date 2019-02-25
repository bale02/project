package net.reply.service;

import java.util.List;

import net.reply.domain.replyVO;

public interface replyService {
	List<replyVO> list(Integer board_No)throws Exception;
	
	void create(replyVO replyVO) throws Exception;
	
	void update(replyVO replyVO) throws Exception;
	
	void delete(Integer reply_No) throws Exception;
	
	int count(Integer board_No)throws Exception;

}