package net.board;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import net.board.domain.boardVO;
import net.board.persistence.boardDAO;
import net.commons.paging.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class boardDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(boardDAOTest.class);
	
	@Inject
	private boardDAO boardDAO;
	
	@Test
	public void testListCriteria() throws Exception{
		Criteria criteria = new Criteria();
		criteria.setStart(3);
		criteria.setEnd(10);
		
		List<boardVO> list = boardDAO.listCriteria(criteria);
		
		for(boardVO boardVO : list) {
			logger.info(boardVO.getboard_no() + ":" + boardVO.getTitle());
		}
		
	}
	
}
