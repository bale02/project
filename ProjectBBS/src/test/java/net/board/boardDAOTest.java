package net.board;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.board.domain.boardVO;
import net.board.persistence.boardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class boardDAOTest {
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(boardDAOTest.class);
	
	@Inject
	private boardDAO boardDAO;
	
	@Test
	public void testCreate() throws Exception{
		boardVO board = new boardVO();
		board.setTitle("새로운 글 작성 테스트 제목");
		board.setContent("새로운 글 작성 테스트 내용");
		board.setWriter("새로운 글 작성자");
		boardDAO.create(board);
	}
	
	@Test
	public void testRead() throws Exception{
		LOGGER.info(boardDAO.read(1).toString());
	}
	
	
}
