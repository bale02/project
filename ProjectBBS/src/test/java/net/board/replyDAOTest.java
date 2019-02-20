package net.board;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.reply.Persistence.replyDAO;
import net.reply.domain.replyVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class replyDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(replyDAOTest.class);
	
	@Inject
	private replyDAO replyDAO;
	
	@Test
	public void testReplyCreate() throws Exception{
		
		for(int i=1;i<=10;i++) {
			replyVO replyVO = new replyVO();
			replyVO.setBoard_No(1000);
			replyVO.setReply_Text(i+"번째 댓글입니다.");
			replyVO.setReply_Writer("user0"+(i%10));
			replyDAO.create(replyVO);
		}
	}
	@Test
	public void testReplyList() throws Exception{
		logger.info(replyDAO.list(1000).toString());
	}
	
	@Test
	public void testReplyUpdate() throws Exception{
		replyVO replyVO = new replyVO();
		replyVO.setReply_No(2);
		replyVO.setReply_Text(2+"번쨰 댓글 수정.");
		replyDAO.update(replyVO);
	}
	
	@Test
	public void testReplyDelete() throws Exception{
		replyDAO.delete(3);
	}
}
