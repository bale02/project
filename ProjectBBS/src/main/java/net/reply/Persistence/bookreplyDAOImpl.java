package net.reply.Persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.reply.domain.bookreplyVO;

@Repository
public class bookreplyDAOImpl implements bookreplyDAO{
	private static final String NAMESPACE = "net.mappers.reply.bookReplyMapper";
	
	@Autowired
	private final SqlSession sqlSession;
	
	@Inject
	public bookreplyDAOImpl(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	@Override
	public List<bookreplyVO> list(Integer book_No) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE+".list",book_No);
	}

	@Override
	public void create(bookreplyVO bookreplyVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE+".create",bookreplyVO);
	}

	@Override
	public void update(bookreplyVO bookreplyVO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".update",bookreplyVO);
	}

	@Override
	public void delete(Integer book_No) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".delete",book_No);
	}

	@Override
	public int count(Integer book_No) throws Exception {
		return sqlSession.selectOne(NAMESPACE+".countReplies", book_No);
	}

	@Override
	public int getbook_No(Integer book_No) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".getBookNo",book_No);
	}
	
	
	
	
}
