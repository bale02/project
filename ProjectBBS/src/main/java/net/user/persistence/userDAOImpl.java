package net.user.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.user.domain.loginDTO;
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

	@Override
	public userVO login(loginDTO loginDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE+".login",loginDTO);
	}
	
	
	//로그인 유지 처리 
	@Override
	public void keepLogin(String user_Id, String session_Id, Date session_Limit) throws Exception {
		// TODO Auto-generated method stub
		Map<String,Object> paramMap = new HashMap<String, Object>();
		paramMap.put("user_Id",user_Id);
		paramMap.put("session_Id",session_Id);
		paramMap.put("sessionLimit", session_Limit);
		
		sqlSession.update(NAMESPACE + ".keepLogin",paramMap);
	}
	
	
	//세션 키 검증
	@Override
	public userVO checkUserWithSessionKey(String value) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + ".checkUserWithSessionKey",value);
	}

    @Override
    public String getUserPw(String userId) throws Exception {

        return sqlSession.selectOne(NAMESPACE + ".getUserPw", user_Id);
    }

    @Override
    public void userInfoUpdate(userVO userVO) throws Exception {
        sqlSession.update(NAMESPACE + ".userInfoUpdate", userVO);
    }

    @Override
    public void userPwUpdate(String userId, String newUserPw) throws Exception {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("user_Id", userId);
        paramMap.put("newUser_Pw", newUserPw);
        sqlSession.update(NAMESPACE + ".userPwUpdate", paramMap);
    }
	
}
