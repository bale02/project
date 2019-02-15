package net.board.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/main.do")
	public String dashBaord(){
		return "main/main";
	}
	
	@RequestMapping("/register.do")
	public String register() {
		return "main/register";
	}
}
