package net.reply.Persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.reply.domain.replyVO;

@Repository
public class replyDAOImpl implements replyDAO{
	private static final String NAMESPACE = "net.mappers.reply.replyMapper";
	
	@Autowired
	private final SqlSession sqlSession;
	
	@Inject
	public replyDAOImpl(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public List<replyVO> list(Integer board_No) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".list",board_No);
	}

	@Override
	public void create(replyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".create",replyVO);
	}

	@Override
	public void update(replyVO replyVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".update",replyVO);
	}

	@Override
	public void delete(Integer reply_No) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".delete",reply_No);
	}
}
