package net.user.controller;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.user.domain.userVO;
import net.user.service.userService;

@Controller
public class userRegisterController {
	
	@Autowired
	private final userService userService;
	
	@Inject
	public userRegisterController(userService userService) {
		this.userService = userService;
	}
	
	// 회원가입 페이지 
	@RequestMapping(value="/register.do",method = RequestMethod.GET)
	public String registerGET() throws Exception{
		return "/user/register";
	}
	
	@RequestMapping(value="/register.do", method=RequestMethod.POST)
	public String registerPOST(userVO userVO,RedirectAttributes redirectAttributes) throws Exception{
		String hashedPw = BCrypt.hashpw(userVO.getUser_Pw(),BCrypt.gensalt());
		userVO.setUser_Pw(hashedPw);
		userService.register(userVO);
		redirectAttributes.addAttribute("msg","REGISTERED");
		
		return "redirect:/login.do";
	}
	
}
