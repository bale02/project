package net.user.persistence;

import java.util.Date;

import net.user.domain.loginDTO;
import net.user.domain.userVO;

public interface userDAO {
	void register(userVO userVO) throws Exception;
	
	userVO login(loginDTO loginDTO) throws Exception;
	
	void keepLogin(String user_Id,String sessionId, Date sessionLimit) throws Exception;
	
	userVO checkUserWithSessionKey(String value) throws Exception;
	
    // 회원비밀번호
    String getUserPw(String userId) throws Exception;

    // 회원정보 수정처리
    void userInfoUpdate(userVO userVO) throws Exception;

    // 회원 비밀번호 수정
    void userPwUpdate(String userId, String newUserPw) throws Exception;
    
    void userLoginDate(String user_Id) throws Exception;
    
    void userBookRental(int book_cnt) throws Exception;
    
    Integer userCheck(String user_Id) throws Exception;
}
