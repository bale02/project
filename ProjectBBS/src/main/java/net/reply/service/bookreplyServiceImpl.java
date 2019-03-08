package net.reply.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.library.persistence.libraryDAO;
import net.reply.Persistence.bookreplyDAO;
import net.reply.domain.bookreplyVO;
import net.reply.domain.replyVO;

@Service
public class bookreplyServiceImpl implements bookreplyService {
	private final bookreplyDAO bookreplyDAO;
	
	private final libraryDAO libraryDAO;
	
	@Inject
	public bookreplyServiceImpl(bookreplyDAO bookreplyDAO,libraryDAO libraryDAO) {
		this.bookreplyDAO=bookreplyDAO;
		this.libraryDAO = libraryDAO;
	}

	@Override
	public List<bookreplyVO> list(Integer book_No) throws Exception {
		// TODO Auto-generated method stub
		return bookreplyDAO.list(book_No);
	}

	@Override
	public void create(bookreplyVO bookreplyVO) throws Exception {
		// TODO Auto-generated method stub
		bookreplyDAO.create(bookreplyVO);
		libraryDAO.updateReplyCnt(bookreplyVO.getBook_No(),1);
	}

	@Override
	public void update(bookreplyVO bookreplyVO) throws Exception {
		// TODO Auto-generated method stub
		bookreplyDAO.update(bookreplyVO);
	}

	@Override
	public void delete(Integer reply_No) throws Exception {
		// TODO Auto-generated method stub
		int board_No = bookreplyDAO.getbook_No(reply_No);
		bookreplyDAO.delete(reply_No);
		libraryDAO.updateReplyCnt(board_No, -1);
	}

	@Override
	public int count(Integer book_No) throws Exception {
		return bookreplyDAO.count(book_No);
	}
	

	
	
}
