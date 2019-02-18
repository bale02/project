package net.board;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.board.domain.boardVO;
import net.board.persistence.boardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class boardDAOTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(boardDAOTest.class);
	
	@Inject
	private boardDAO boardDAO;
	
	@Test
	public void testCreate() throws Exception{
		boardVO board = new boardVO();
		board.setTitle("���ο� �� �ۼ� �׽�Ʈ ����");
		board.setContent("���ο� �� �ۼ� �׽�Ʈ ����");
		board.setWriter("���ο� �� �ۼ���");
		boardDAO.create(board);
	}
	
	@Test
	public void testRead() throws Exception{
		LOGGER.info(boardDAO.read(1).toString());
	}
	
	@Test
	public void testUpdate() throws Exception{
		boardVO board = new boardVO();
		board.setboardNo(1);
		board.setTitle("�� ���� �׽�Ʈ ����");
		board.setContent("�� ���� �׽�Ʈ ����");
		boardDAO.update(board);
	}
	
	@Test
	public void testDelete() throws Exception{
		boardDAO.delete(1);
	}
}
