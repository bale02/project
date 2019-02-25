package net.board.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public boardVO read(Integer board_No) throws Exception{
		return sqlSession.selectOne(NAMESPACE+".read",board_No);
	}
	
	@Override
	public void update(boardVO boardVO) throws Exception{
		sqlSession.update(NAMESPACE+".update",boardVO);
	}
	
	@Override
	public void delete(Integer board_No) throws Exception{
		sqlSession.delete(NAMESPACE+".delete",board_No);
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

	@Override
	public void updateReplyCnt(Integer board_No, int amount) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("board_No", board_No);
		paramMap.put("amount",amount);
		
		sqlSession.update(NAMESPACE + ".updateReplyCnt",paramMap);
	}

	@Override
	public void updateViewCnt(Integer board_No) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".updateViewCnt",board_No);
	}
	
	
}
