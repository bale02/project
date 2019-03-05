package net.user.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.user.domain.userVO;
import net.user.service.userService;

@Controller
public class userInfoContoroller {
	private final userService userService;
	
	@Inject
	public userInfoContoroller(userService userService) {
		this.userService=userService;
	}
	
	// 회원정보 페이지 
	
	@RequestMapping(value="/info",method=RequestMethod.GET)
	public String userInfo() throws Exception{
		return "/user/info";
	}
	

    // 회원 정보 수정
    @RequestMapping(value = "/modify", method = RequestMethod.POST)
    public String userInfoModify(userVO userVO, HttpSession httpSession, RedirectAttributes redirectAttributes) throws Exception {
        boolean userPwValid = userService.isValidUserPw(userVO.getUser_Id(), userVO.getUser_Pw());
        if (!userPwValid) {
            redirectAttributes.addFlashAttribute("msg", "INVALID userPw");
            return "redirect:/user/info";
        }
        userService.userInfoModify(userVO);
        httpSession.setAttribute("login", userVO);
        redirectAttributes.addFlashAttribute("msg", "MODIFIED userInfo");
        return "redirect:/user/info";
    }

    // 회원 비밀번호 변경
    @RequestMapping(value = "/password/modify", method = RequestMethod.POST)
    public String userPwModify(String userId, String oldUserPw, String newUserPw, RedirectAttributes redirectAttributes) throws Exception {

        // 비밀번호 일치 확인
        if (!userService.isValidUserPw(userId, oldUserPw)) {
            redirectAttributes.addFlashAttribute("msg", "INVALID userPw");
            return "redirect:/user/info";
        }

        // 새로운 비밀번호 == 현재 비밀번호
        if (userService.isValidUserPw(userId, newUserPw)) {
            redirectAttributes.addFlashAttribute("msg", "SAME userPw");
            return "redirect:/user/info";
        }

        // 새로운 비밀번호 암호화 처리, 변경
        String hashedPw = BCrypt.hashpw(newUserPw, BCrypt.gensalt());
        userService.userPwModify(userId, hashedPw);
        redirectAttributes.addFlashAttribute("msg", "MODIFIED userPw");

        return "redirect:/user/info";
    }

}

