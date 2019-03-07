package net.library.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.commons.paging.Criteria;
import net.library.domain.libraryVO;

@Repository
public class libraryDAOImpl implements libraryDAO {
	private static final String NAMESPACE = "net.mappers.library.libraryMapper";

	@Autowired
	private final SqlSession sqlsession;
	
	@Inject
	public libraryDAOImpl(SqlSession sqlSession) {
		// TODO Auto-generated constructor stub
		this.sqlsession = sqlSession;
	}
	
	@Override
	public void bookInsert(libraryVO libraryVO) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.insert(NAMESPACE+".insert",libraryVO);
	}

	@Override
	public List<libraryVO> listCriteria(Criteria criteria) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NAMESPACE+".listAll",criteria);
		
	}

	@Override
	public void bookDelete(Integer book_No) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.delete(NAMESPACE+".delete",book_No);
	}

	@Override
	public void bookRental(Integer book_No,String user_Id) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("book_No",book_No);
		paramMap.put("user_Id",user_Id);
		sqlsession.update(NAMESPACE+".rental",paramMap);
	}

	@Override
	public void bookReturn(Integer book_No) throws Exception {
		// TODO Auto-generated method stub
		sqlsession.update(NAMESPACE+".return",book_No);
	}
	
	@Override
	public int Countbooks(String user_Id) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NAMESPACE+".countbooks",user_Id);
	}

	@Override
	public int count() throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NAMESPACE+".count");
	}

	@Override
	public int count(String skey, String sval) throws Exception {
		// TODO Auto-generated method stub
		Criteria criteria = new Criteria();
		criteria.setSkey(skey);
		criteria.setSval(sval);
		return sqlsession.selectOne(NAMESPACE+".countone",criteria);
	}

	@Override
	public List<libraryVO> listSearch(Criteria criteria) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectList(NAMESPACE+".select",criteria);
	}

	@Override
	public void updateReplyCnt(Integer book_No, int amount) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("book_No",book_No);
		paramMap.put("amount",amount);
		sqlsession.update(NAMESPACE+".updateReplyCnt",paramMap);
	}

	@Override
	public libraryVO read(Integer book_No) throws Exception {
		// TODO Auto-generated method stub
		return sqlsession.selectOne(NAMESPACE+".read",book_No);
	}

}
