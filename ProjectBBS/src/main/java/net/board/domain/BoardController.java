package net.board.domain;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.board.service.boardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private final boardService boardService;
	
	@Inject
	public BoardController(boardService boardService) {
		this.boardService = boardService;
	}
	// 등록화면조회
	@RequestMapping(value="/write.do",method=RequestMethod.GET)
	public String writeGET() {
		logger.info("write GET..");
		
		return "/board/write";
	}
	
	// 게시물 등록
	@RequestMapping(value="/write.do", method=RequestMethod.POST)
	public String writePOST(boardVO boardVO,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.info("write POST...");
		logger.info(boardVO.toString());
		boardService.create(boardVO);
		redirectAttributes.addFlashAttribute("msg", "regSuccess");
		return "redirect:/board/list.do";
	}
	
	// 리스트 조회
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		logger.info("list..");
		
		return "/board/list";
	}
	
	//게시글 확인
	@RequestMapping(value="/read.do",method=RequestMethod.GET)
	public String read(@RequestParam("boradNo") int boardNo,Model model) throws Exception{
		logger.info("read..");
		
		return "/borad/read";
	}
	
	// 게시글 수정 페이지 이동
	@RequestMapping(value="/modify.do",method=RequestMethod.GET)
	public String modifyGET(@RequestParam("boardNo") int boardNo ,Model model) throws Exception{
		logger.info("modify Get..");
		
		return "/board/modify";
	}
	
	//게시글 수정
	@RequestMapping(value="/modify.do",method=RequestMethod.POST)
	public String modifyPOST(boardVO boardVO,RedirectAttributes redirectAttributes) throws Exception{
		logger.info("modify POST..");
		
		boardService.update(boardVO);
		
		redirectAttributes.addFlashAttribute("msg", "mod Succes");
		return "redirect:/board/read.do?boradNo="+boardVO.getboardNo();
		
	}
	
	//게시글 삭제
	@RequestMapping(value="/delete.do",method=RequestMethod.GET)
	public String delete(@RequestParam("boardNo") int boardNo,RedirectAttributes redirectAttributes) throws Exception {
		logger.info("remove..");
		
		boardService.delete(boardNo);
		
		redirectAttributes.addFlashAttribute("msg","remove Succes");
		return "redirect:/board/list.do";
	}
	
}
