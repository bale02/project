package net.user.service;

import java.util.Date;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.user.domain.loginDTO;
import net.user.domain.userVO;
import net.user.persistence.userDAO;

@Service
public class userServiceImpl implements userService{
	
	@Autowired
	private final userDAO userDAO;
	
	@Inject
	public userServiceImpl(userDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void register(userVO userVO) throws Exception {
		// TODO Auto-generated method stub
		userDAO.register(userVO);
	}

	@Override
	public userVO login(loginDTO loginDTO) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.login(loginDTO);
	}

	@Override
	public void keepLogin(String user_Id, String session_Id, Date session_Limit) throws Exception {
		// TODO Auto-generated method stub
		userDAO.keepLogin(user_Id, session_Id, session_Limit);
		
	}

	@Override
	public userVO checkLoginBefore(String value) throws Exception {
		// TODO Auto-generated method stub
		return userDAO.checkUserWithSessionKey(value);
	}
	
	@Override
    public boolean isValidUserPw(String userId, String userPw) throws Exception {
        String hashedUserPw = userDAO.getUserPw(userId);

        return BCrypt.checkpw(userPw, hashedUserPw);
    }

    @Override
    public void userInfoModify(userVO userVO) throws Exception {
        userDAO.userInfoUpdate(userVO);
    }

    @Override
    public void userPwModify(String userId, String newUserPw) throws Exception {
        userDAO.userPwUpdate(userId, newUserPw);
    }

	@Override
	public void userLoginDate(String user_Id) throws Exception {
		// TODO Auto-generated method stub
		userDAO.userLoginDate(user_Id);
	}

	
	
}
