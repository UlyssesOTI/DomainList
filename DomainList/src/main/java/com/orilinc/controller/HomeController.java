package com.orilinc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.orilinc.entity.User;


@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "redirect:/domain/all/1";
	}
	
	@RequestMapping(value="/loginpage", method=RequestMethod.GET)
	public String login(HttpServletRequest request) {
		String referrer = request.getHeader("Referer");
	    if(referrer!=null){
	        request.getSession().setAttribute("url_prior_login", referrer);
	    }
		return "loginpage";
	}
		
	@RequestMapping(value="/signIn")
	public String signIn(Model model){
		User user = new User();
		model.addAttribute("user", user);
		return "user-new";
	}
	
	@RequestMapping(value="/loginpageFail", method = RequestMethod.GET)
	public String loginFail (RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("message", "Wrong login or password");
		return "redirect:/loginpage";
	}
}
