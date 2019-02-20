package net.board.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.board.domain.boardVO;
import net.commons.paging.Criteria;

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

	@Override
	public List<boardVO> listPaging(int page) throws Exception {
		if(page<=0) {
			page =1;
		}
		page = (page-1) * 10;
		
		return sqlSession.selectList(NAMESPACE+".listPaging",page);
	}

	@Override
	public List<boardVO> listCriteria(Criteria criteria) throws Exception {
		return sqlSession.selectList(NAMESPACE+".listCriteria",criteria);				
	}

	@Override
	public int count(String skey,String sval) throws Exception {
		Criteria criteria = new Criteria();
		
		criteria.setSkey(skey);
		criteria.setSval(sval);	
		
		return sqlSession.selectOne(NAMESPACE+".countOne",criteria);
	}

	@Override
	public int count() throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+".count");
	}

	@Override
	public List<boardVO> listSearch(Criteria criteria) throws Exception {
		return sqlSession.selectList(NAMESPACE+".select",criteria);			
	}
	
	
}
