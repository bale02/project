package net.user.service;

import java.util.Date;

import net.user.domain.loginDTO;
import net.user.domain.userVO;

public interface userService {
	void register(userVO userVO) throws Exception;
	
	userVO login(loginDTO loginDTO) throws Exception;
	
	void keepLogin(String user_Id,String session_Id,Date Next) throws Exception;
	
	userVO checkLoginBefore(String value) throws Exception;
	
    boolean isValidUserPw(String userId, String userPw) throws Exception;

    void userInfoModify(userVO userVO) throws Exception;

    void userPwModify(String userId, String newUserPw) throws Exception;
    
    void userLoginDate(String user_Id) throws Exception;
    
    void userBookRental(int book_cnt) throws Exception;
}
