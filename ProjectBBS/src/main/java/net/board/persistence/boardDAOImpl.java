package net.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.board.domain.boardVO;

@Repository
public class boardDAOImpl implements boardDAO {
	private static final String NAMESPACE = "net.mappers.board.boardMapper";
	
	@Autowired
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
	public boardVO read(Integer board_no) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".read",board_no);
	}
	
	@Override
	public void update(boardVO boardVO) throws Exception{
		sqlSession.update(NAMESPACE+".update",boardVO);
	}
	
	@Override
	public void delete(Integer board_no) throws Exception{
		sqlSession.delete(NAMESPACE+".delete",board_no);
	}
	
	@Override
	public List<boardVO> listAll() throws Exception{
		return sqlSession.selectList(NAMESPACE + ".listAll");
	}
	
}
