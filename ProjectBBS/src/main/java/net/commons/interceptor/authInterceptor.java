package net.commons.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class authInterceptor extends HandlerInterceptorAdapter {
	
	private static final Logger logger = LoggerFactory.getLogger(authInterceptor.class);
	
	//페이지 요청정보 저장
	private void saveDestination(HttpServletRequest request) {
		String uri = request.getRequestURI();
		String query = request.getQueryString();
		if(query == null || query.equals("null")) {
			query="";
		}else {
			query = "?"+query;
		}
		
		if(request.getMethod().equals("GET")) {
			logger.info("destination : " + (uri+query));
			request.getSession().setAttribute("destination", uri+query);
		}
	}
	
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception{
		HttpSession httpSession = request.getSession();
		// 기존의 로그인 정보 제거 
		if(httpSession.getAttribute("login") == null) {
			logger.info("current user is not logged");
			saveDestination(request);
			response.sendRedirect("login.do");
			return false;
		}
		
		return true;
	}
	
}
