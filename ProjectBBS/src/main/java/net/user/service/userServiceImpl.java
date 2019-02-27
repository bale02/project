package net.user.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	
	
	
}
