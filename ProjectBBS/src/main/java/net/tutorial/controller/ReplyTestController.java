package net.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReplyTestController {
	
	@RequestMapping("/reply_test.do")
	public String replyAjaxtest() {
		return "/tutorial/reply_test";
	}
}
