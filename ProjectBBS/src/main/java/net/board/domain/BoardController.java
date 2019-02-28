package net.board.domain;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.board.service.boardService;
import net.commons.paging.Criteria;

@Controller
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
		return "redirect:/listCriteria.do";
	}
	
	// 리스트 조회
	
	@RequestMapping(value="/list.do", method=RequestMethod.GET)
	public String list(Model model) throws Exception {
		logger.info("list..");
		model.addAttribute("boards",boardService.listAll());
		return "/board/list";
	}
	
	//게시글 확인
	@RequestMapping(value="/read.do",method=RequestMethod.GET)
	public String read(@RequestParam("board_No") int board_No,Model model) throws Exception{
		logger.info("read..");
		model.addAttribute("board",boardService.read(board_No));
		return "/board/read";
	}
	
	// 게시글 수정 페이지 이동
	@RequestMapping(value="/modify.do",method=RequestMethod.GET)
	public String modifyGET(@RequestParam("board_No") int board_No ,Model model) throws Exception{
		logger.info("modify Get..");
		model.addAttribute("board",boardService.read(board_No));
		return "/board/modify";
	}
	
	//게시글 수정
	@RequestMapping(value="/modify.do",method=RequestMethod.POST)
	public String modifyPOST(boardVO boardVO,RedirectAttributes redirectAttributes) throws Exception{
		logger.info("modify POST..");
		
		boardService.update(boardVO);
		
		redirectAttributes.addFlashAttribute("msg", "modSucces");
		return "redirect:/read.do?board_No="+boardVO.getBoard_No();
		
	}
	
	//게시글 삭제
	@RequestMapping(value="/delete.do",method=RequestMethod.GET)
	public String delete(@RequestParam("board_No") int board_No,RedirectAttributes redirectAttributes) throws Exception {
		logger.info("remove..");
		
		boardService.delete(board_No);
		
		redirectAttributes.addFlashAttribute("msg","delSuccess");
		return "redirect:/list.do";
	}
	
	@RequestMapping(value="/listCriteria.do",method=RequestMethod.GET)
	public ModelAndView listCriteria(HttpServletRequest request)throws Exception{
		logger.info("listCriteria..");
		
		ModelAndView mav = new ModelAndView();
		
		int total;
		String pnum="";
		int startpage=1,endpage=10;
		int pageNUM=1,start=1,end=10;
		int pagecount=1,temp=0;
		int Stotal;
		String skey ="", sval="", returnpage="";
		
		pnum = request.getParameter("page");
		skey = request.getParameter("keyfield");
		sval = request.getParameter("keyword");
		
		if(sval == null || sval =="") {
			skey =""; sval ="";
		}
		
		returnpage ="&keyfield="+skey+"&keyword="+sval;
		
		if(pnum==null||pnum=="") {
			pageNUM=1;
		}else {
			pageNUM=Integer.parseInt(pnum);
		}
		
		start = (pageNUM-1)*10+1;
		end = (pageNUM) * 10;
		
		Stotal=boardService.count(skey, sval);
		
		total=boardService.count();
		
		if(total%10==0) {
			pagecount = Stotal/10;
		}else {
			pagecount = (Stotal/10)+1;
		}
		
		temp=(pageNUM-1)%10;
		startpage = pageNUM-temp;
		endpage = startpage +9;
		
		if(endpage>pagecount) {
			endpage = pagecount;
		}
		
		Criteria criteria = new Criteria();
		
		criteria.setSval(sval);
		criteria.setSkey(skey);
		criteria.setEnd(end);
		criteria.setStart(start);
		
		List<boardVO> list = boardService.listCriteria(criteria);
		mav.addObject("boards",list);
		mav.addObject("naver",list);
		mav.addObject("total",total);
		mav.addObject("Stotal",Stotal);
		mav.addObject("startpage",startpage);
		mav.addObject("endpage",endpage);
		mav.addObject("pagecount",pagecount);
		mav.addObject("pageNUM",pageNUM);
		mav.addObject("sval",sval);
		mav.addObject("returnpage",returnpage);
		mav.setViewName("/board/list_criteria");
		
		return mav;
	}
	
}
