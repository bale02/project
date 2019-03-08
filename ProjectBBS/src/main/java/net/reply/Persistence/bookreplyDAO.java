package net.reply.Persistence;

import java.util.List;

import net.reply.domain.bookreplyVO;

public interface bookreplyDAO {
	List<bookreplyVO> list(Integer book_No) throws Exception;
	
	void create(bookreplyVO bookreplyVO) throws Exception;
	
	void update(bookreplyVO bookreplyVO) throws Exception;
	
	void delete(Integer reply_No) throws Exception;
	
	int count(Integer book_No) throws Exception;
	
	int getbook_No(Integer book_No) throws Exception;
}
