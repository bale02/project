package net.reply.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.reply.domain.replyVO;
import net.reply.service.replyService;

@Controller
public class ReplyController {
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	
	@Autowired
	private final replyService replyService;
	
	@Inject
	public ReplyController(replyService replyService) {
		this.replyService = replyService;
	}
	
	@RequestMapping(value="/reply_list.do",method=RequestMethod.GET)
	public String replyList(@RequestParam("board_no") int board_No,Model model) throws Exception{
		logger.info("replyList..");
		model.addAttribute("replies",replyService.list(board_No));
		return "reply/list";
	}
	
	@RequestMapping(value="/reply_write.do",method=RequestMethod.POST)
	public String replyWrite(replyVO replyVO) throws Exception{
		logger.info("replyWrite..");
		replyService.create(replyVO);
		return "redirect:/reply_list.do";
	}
	
	@RequestMapping(value="/reply_update.do",method=RequestMethod.POST)
	public String replyUpdate(replyVO replyVO,Model model) {
		logger.info("replyUpdate..");
		try {
			replyService.update(replyVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/reply_list.do";
	}
	
	@RequestMapping(value="/reply_delete.do",method=RequestMethod.GET)
	public String replyDelete(@RequestParam("reply_no") int reply_No) {
		logger.info("replyDelete..");
		
		try {
			replyService.delete(reply_No);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/reply_list.do";
	}
}
