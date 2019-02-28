package net.user.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import net.user.domain.loginDTO;
import net.user.domain.userVO;
import net.user.service.userService;

@Controller
public class userLoginController {
	
	@Autowired
	private final userService userService;
	
	@Inject
	public userLoginController(userService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value = "/login.do", method=RequestMethod.GET)
	public String loginGET(@ModelAttribute("loginDTO") loginDTO loginDTO) {
		return "/user/login";
	}
	
	@RequestMapping(value = "/loginPost.do",method=RequestMethod.POST)
	public String loginPOST(loginDTO loginDTO,HttpSession httpSession, Model model) throws Exception{
		userVO userVO = userService.login(loginDTO);
		if(userVO == null || !BCrypt.checkpw(loginDTO.getUser_Pw(), userVO.getUser_Pw())) {
			return "/user/loginPost";
		}
        model.addAttribute("user", userVO);
        
        if(loginDTO.getUseCookie()) {
        	int amount = 60*60*24*7; // 7일
        	Date session_Limit =new Date(System.currentTimeMillis()+(1000+amount)); // 로그인 유지시간
        	
        	userService.keepLogin(userVO.getUser_Id(), httpSession.getId(), session_Limit);
        }
        
        
        return "/main/main";
        
	}
	
	@RequestMapping(value="/logout" , method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession httpSession) throws Exception{
		Object object = httpSession.getAttribute("login");
		if(object != null) {
			userVO userVO = (userVO) object;
			httpSession.removeAttribute("login");
			httpSession.invalidate();
			Cookie loginCookie = WebUtils.getCookie(request,"loginCookie");
			if(loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				userService.keepLogin(userVO.getUser_Id(),"none",new Date());
			}
		}
		
		return "/user/logout";
	}
	
}
