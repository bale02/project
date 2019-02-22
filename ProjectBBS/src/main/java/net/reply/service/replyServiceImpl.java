package net.reply.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.reply.Persistence.replyDAO;
import net.reply.domain.replyVO;

@Service
public class replyServiceImpl implements replyService {
	private final replyDAO replyDAO;
	
	@Inject
	public replyServiceImpl(replyDAO replyDAO) {
		this.replyDAO=replyDAO;
	}

	@Override
	public List<replyVO> list(Integer board_No) throws Exception {
		// TODO Auto-generated method stub
		return replyDAO.list(board_No);
	}

	@Override
	public void create(replyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		replyDAO.create(replyVO);
	}

	@Override
	public void update(replyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		replyDAO.update(replyVO);
	}

	@Override
	public void delete(Integer reply_No) throws Exception {
		// TODO Auto-generated method stub
		replyDAO.delete(reply_No);
	}

	@Override
	public int count(Integer board_No) throws Exception {
		return replyDAO.count(board_No);
	}
	
	
}
