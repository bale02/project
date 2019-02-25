package net.reply.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.board.persistence.boardDAO;
import net.reply.Persistence.replyDAO;
import net.reply.domain.replyVO;

@Service
public class replyServiceImpl implements replyService {
	private final replyDAO replyDAO;
	
	private final boardDAO boardDAO;
	
	@Inject
	public replyServiceImpl(replyDAO replyDAO,boardDAO boardDAO) {
		this.replyDAO=replyDAO;
		this.boardDAO = boardDAO;
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
		boardDAO.updateReplyCnt(replyVO.getBoard_No(),1);
	}

	@Override
	public void update(replyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		replyDAO.update(replyVO);
	}

	@Override
	public void delete(Integer reply_No) throws Exception {
		// TODO Auto-generated method stub
		int board_No = replyDAO.getboard_No(reply_No);
		replyDAO.delete(reply_No);
		boardDAO.updateReplyCnt(board_No, -1);
	}

	@Override
	public int count(Integer board_No) throws Exception {
		return replyDAO.count(board_No);
	}
	

	
	
}
