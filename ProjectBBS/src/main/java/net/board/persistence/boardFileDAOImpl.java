package net.board.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class boardFileDAOImpl implements boardFileDAO {
	
	private static final String NAMESPACE = "net.mappers.upload.boardFileMapper";
	
	@Autowired
	private final SqlSession sqlSession;
	
	@Inject
	public boardFileDAOImpl(SqlSession sqlSession) {
		// TODO Auto-generated constructor stub
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void addFile(String fullName) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert(NAMESPACE +".addFile",fullName);
	}

	@Override
	public List<String> getBoardFiles(Integer board_No) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + ".getBoardFiles",board_No);
	}

	@Override
	public void deleteFiles(Integer board_No) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".deleteFiles",board_No);
	}

	@Override
	public void replaceFile(String fileName, Integer board_No) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("fileName",fileName);
		paramMap.put("board_No",board_No);
		sqlSession.insert(NAMESPACE+".replaceFile",paramMap);
	}

	@Override
	public void updateFileCnt(Integer board_No) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update(NAMESPACE+".updateFileCnt",board_No);
	}

	@Override
	public void deleteFile(String fileName) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete(NAMESPACE+".deleteFile",fileName);
	}

}
