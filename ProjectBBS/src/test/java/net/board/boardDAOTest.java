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
		for(int i=0;i<1000;i++) {
			boardVO board = new boardVO();
			board.setTitle(i + "번째 글 입니다.");
			board.setContent(i + "번째 글 내용입니다.");
			board.setWriter("user0"+(i%10));
			boardDAO.create(board);
		}
	}
	
}
