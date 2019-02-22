package net.reply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.reply.domain.replyVO;
import net.reply.service.replyService;

@RestController
public class ReplyController {
	private static final Logger logger = LoggerFactory.getLogger(ReplyController.class);
	
	
	@Autowired
	private final replyService replyService;
	
	@Inject
	public ReplyController(replyService replyService) {
		this.replyService = replyService;
	}
	
	@RequestMapping(value="/replies", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody replyVO replyVO){
		ResponseEntity<String> entity =null;
		try {
			replyService.create(replyVO);
			entity = new ResponseEntity<String>("regSuccess",HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/list/{board_No}", method = RequestMethod.GET)
	public ResponseEntity<List<replyVO>> list(@PathVariable("board_No") Integer board_No){
		ResponseEntity<List<replyVO>> entity =null;
		try {
			entity = new ResponseEntity<List<replyVO>>(replyService.list(board_No),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity= new ResponseEntity<List<replyVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/update/{reply_No}",method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("reply_No") Integer reply_No,@RequestBody replyVO replyVO){
		ResponseEntity<String> entity =null;
		try {
			replyVO.setReply_No(reply_No);
			replyService.update(replyVO);
			entity = new ResponseEntity<String>("modSuccess",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/delete/{reply_No}",method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("reply_No") Integer reply_No){
		ResponseEntity<String> entity =null;
		try {
			replyService.delete(reply_No);
			entity = new ResponseEntity<String>("delSuccess",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/count/{board_No}",method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> count(@PathVariable("board_No") Integer board_No){
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			List<replyVO> replies = replyService.list(board_No);
			int repliesCount = replyService.count(board_No);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("replies", replies);
			map.put("repliesCount", repliesCount);
			
			entity = new ResponseEntity<Map<String,Object>>(map,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.OK);
		}
		
		return entity;
	}
	
	
}
