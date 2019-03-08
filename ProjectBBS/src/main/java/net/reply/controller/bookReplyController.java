package net.reply.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.reply.domain.bookreplyVO;
import net.reply.domain.replyVO;
import net.reply.service.bookreplyService;

@RestController
public class bookReplyController {
	@Autowired
	private final bookreplyService bookreplyService;
	
	@Inject
	public bookReplyController(bookreplyService bookreplyService) {
		this.bookreplyService = bookreplyService;
	}
	
	@RequestMapping(value="/book_replies", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody bookreplyVO bookreplyVO){
		ResponseEntity<String> entity =null;
		try {
			bookreplyService.create(bookreplyVO);
			entity = new ResponseEntity<String>("regSuccess",HttpStatus.OK);
		}catch(Exception e){
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/book_list/{book_No}", method = RequestMethod.GET)
	public ResponseEntity<List<bookreplyVO>> list(@PathVariable("book_No") Integer book_No){
		ResponseEntity<List<bookreplyVO>> entity =null;
		try {
			entity = new ResponseEntity<List<bookreplyVO>>(bookreplyService.list(book_No),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity= new ResponseEntity<List<bookreplyVO>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/book_update/{reply_No}",method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("reply_No") Integer reply_No,@RequestBody bookreplyVO bookreplyVO){
		ResponseEntity<String> entity =null;
		try {
			bookreplyVO.setReply_No(reply_No);
			bookreplyService.update(bookreplyVO);
			entity = new ResponseEntity<String>("modSuccess",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/book_delete/{reply_No}",method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable("reply_No") Integer reply_No){
		ResponseEntity<String> entity =null;
		try {
			bookreplyService.delete(reply_No);
			entity = new ResponseEntity<String>("delSuccess",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value = "/book_count/{book_No}",method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> count(@PathVariable("book_No") Integer book_No){
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			List<bookreplyVO> replies = bookreplyService.list(book_No);
			int repliesCount = bookreplyService.count(book_No);
			
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
