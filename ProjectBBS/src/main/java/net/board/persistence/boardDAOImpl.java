package net.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import net.board.domain.boardVO;

@Repository
public class boardDAOImpl implements boardDAO {
	private static final String NAMESPACE = "net.project.board.boardMapper";
	
	private final SqlSession sqlSession;
	
	@Inject
	public boardDAOImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void create(boardVO boardVO) throws Exception{
		sqlSession.insert(NAMESPACE+".create",boardVO);
	}
	
	@Override
	public boardVO read(Integer boardNo) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".read",boardNo);
	}
	
	@Override
	public void update(boardVO boardVO) throws Exception{
		sqlSession.update(NAMESPACE+".update",boardVO);
	}
	
	@Override
	public void delete(Integer boardNo) throws Exception{
		sqlSession.delete(NAMESPACE+".delete",boardNo);
	}
	
	@Override
	public List<boardVO> listAll() throws Exception{
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}
	
}
