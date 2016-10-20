package com.orilinc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orilinc.entity.User;
import com.orilinc.service.UserService;
import com.orilinc.validator.UserValidator;

@Controller
@RequestMapping(value="user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@InitBinder("user")
	private void initBinderuser(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}
		
	@RequestMapping(value="add", method = RequestMethod.POST)
	private String inset(@ModelAttribute("user") @Valid User user,BindingResult result, Model model) throws Exception{	
		if (result.hasErrors()) {			
			return "user-new";
		}		
		userService.inset(user);		
		return "redirect:/user/all/1";
	}
	
	@RequestMapping(value="edit/{id}", method = RequestMethod.GET)
	private String edit(@PathVariable("id") Integer id, Model model){
		model.addAttribute("user", userService.getById(id));
		return "user-edit";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	private String update(@ModelAttribute("user") @Valid User user,BindingResult result){
		if (result.hasErrors()) {			
			return "userjsp/edit";
		}		
		userService.update(user);
		return "redirect:/user/all/1";
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	private String delete(@PathVariable("id") Integer id){
		userService.delete(id);
		return "redirect:/user/all/1";		
	}
	
	@RequestMapping(value="all/{pageNumber}", method = RequestMethod.GET)
	private String viewAllusers(@PathVariable Integer pageNumber, Model model){
		Page<User> page = userService.getAll(pageNumber);		
		int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    model.addAttribute("users", page.getContent());
	    model.addAttribute("userLog", page);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		return "user-all";
	}

}
