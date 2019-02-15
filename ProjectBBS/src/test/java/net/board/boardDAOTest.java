package net.board;

import javax.inject.Inject;

import org.apache.log4j.*;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class boardDAOTest {
	private static final Logger logger = LoggerFactory(boardDAOTest.class);
	
	@Inject
			
}
