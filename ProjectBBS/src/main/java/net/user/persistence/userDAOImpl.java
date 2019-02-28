package net.user.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.user.domain.userVO;

@Repository
public class userDAOImpl implements userDAO{

	private static final String NAMESPACE = "net.mappers.user.userMapper";
	
	@Autowired
	private final SqlSession sqlSession;
	
	@Inject
	public userDAOImpl(SqlSession sqlSession) {
		// TODO Auto-generated constructor stub
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void register(userVO userVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE +".register",userVO);
	}
	
}
