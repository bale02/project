package net.user.persistence;

import java.util.Date;

import net.user.domain.loginDTO;
import net.user.domain.userVO;

public interface userDAO {
	void register(userVO userVO) throws Exception;
	
	userVO login(loginDTO loginDTO) throws Exception;
	
	void keepLogin(String user_Id,String sessionId, Date sessionLimit) throws Exception;
	
	userVO checkUserWithSessionKey(String value) throws Exception;
}
