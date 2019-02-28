package net.commons.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import net.user.domain.userVO;
import net.user.service.userService;

public class cookieInterceptor extends HandlerInterceptorAdapter {
	
	@Inject
	private userService userService;
	
	@Override 
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
		
		HttpSession httpSession = request.getSession();
		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) {
			userVO userVO = userService.checkLoginBefore(loginCookie.getValue());
			if(userVO != null) {
				httpSession.setAttribute("login", userVO);
			}
		}
	
		return true;
	}
	
}
