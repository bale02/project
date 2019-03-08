package net.library.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import net.commons.paging.Criteria;
import net.library.domain.libraryVO;
import net.library.service.libraryService;
import net.user.domain.userVO;


@Controller
public class libraryController {
	private static final Logger logger = LoggerFactory.getLogger(libraryController.class);
	
	@Autowired
	private final libraryService libraryService;
	
	@Inject
	public libraryController(libraryService libraryService) {
		// TODO Auto-generated constructor stub
		this.libraryService = libraryService;
	}
	
	@Autowired
	HttpSession Session;
	
	@RequestMapping(value="/book")
	public String book() {
		logger.info("book..");
		
		return "/library/bookwrite";
	}
	
	// 책 입력 
	@RequestMapping(value="/book_insert",method=RequestMethod.POST)
	public String bookInsert(libraryVO libraryVO,
			RedirectAttributes redirectAttributes) throws Exception{
		logger.info("book Insert..");
		libraryService.bookInsert(libraryVO);
		redirectAttributes.addFlashAttribute("msg","ADD");
		return "redirect:/library";
	}
	
	// 책 조회 
	@RequestMapping(value="/book_read",method=RequestMethod.GET)
	public String read(@RequestParam("book_No") int book_No,Model model) throws Exception{
		logger.info("book read..");
		model.addAttribute("library",libraryService.read(book_No));
		return "/library/bookread";
	}
	
	// 책 삭제
	@RequestMapping(value="/book_delete",method=RequestMethod.GET)
	public String delete(libraryVO libraryVO,RedirectAttributes redirectAttributes) throws Exception{
		logger.info("book_delete");
		
		libraryService.bookDelete(libraryVO.getBook_No());
		redirectAttributes.addFlashAttribute("msg","DEL");
		return "redirect:/library";
	}
	
	// 대출
	@RequestMapping(value="/book_rental",method=RequestMethod.GET)
	public String bookRental(libraryVO libraryVO,RedirectAttributes redirectAttributes) throws Exception{
		logger.info("book Rental..");
		userVO userVO =(userVO)Session.getAttribute("login");
		
		int check = libraryService.Countbooks(userVO.getUser_Id());
		if(check >= 3) {
			redirectAttributes.addFlashAttribute("msg","Overcnt");
			return "redirect:/library";
		}
		libraryService.bookRental(libraryVO.getBook_No(), userVO.getUser_Id());
		redirectAttributes.addFlashAttribute("msg","Rental");
		return "redirect:/library";
	}
	//반납
	@RequestMapping(value="/book_return",method=RequestMethod.GET)
	public String bookReturn(libraryVO libraryVO,RedirectAttributes redirectAttributes) throws Exception {
		logger.info("book return..");
		libraryService.bookReturn(libraryVO.getBook_No());
		redirectAttributes.addFlashAttribute("msg","Return");
		
		return "redirect:/library";
	}
	// 책리스트 조회 
	@RequestMapping(value="/library",method=RequestMethod.GET)
	public ModelAndView viewLibrary(HttpServletRequest request) throws Exception {
		logger.info("bookList..");
		
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
		
		Stotal=libraryService.count(skey, sval);
		
		total=libraryService.count();
		
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
		
		List<libraryVO> list = libraryService.listCriteria(criteria);
		mav.addObject("library",list);
		mav.addObject("total",total);
		mav.addObject("Stotal",Stotal);
		mav.addObject("startpage",startpage);
		mav.addObject("endpage",endpage);
		mav.addObject("pagecount",pagecount);
		mav.addObject("pageNUM",pageNUM);
		mav.addObject("sval",sval);
		mav.addObject("returnpage",returnpage);
		mav.setViewName("/library/bookList");
		
		return mav;
	}
	
	
}
