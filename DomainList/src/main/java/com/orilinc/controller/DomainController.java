package com.orilinc.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orilinc.entity.Domain;
import com.orilinc.entity.User;
import com.orilinc.service.DomainService;
import com.orilinc.service.UserService;
import com.orilinc.validator.DomainValidator;

@Controller
@RequestMapping(value="domain/")
public class DomainController {

	@Autowired
	private DomainService domainService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DomainValidator domainValidator;
	
	@InitBinder("domain")
	private void initBinderDomain(WebDataBinder binder) {
		binder.setValidator(domainValidator);
	}
	
	@RequestMapping(value="create", method = RequestMethod.GET)
	private String create(Model model){
		model.addAttribute("domain", new Domain());
		return "domain-new";
	}
	
	@RequestMapping(value="add", method = RequestMethod.POST)
	private String inset(@ModelAttribute("domain") @Valid Domain domain,
			BindingResult result, 
			Model model,
			Principal principal) throws Exception{	
		if (result.hasErrors()) {			
			return "domain-new";
		}		
		domain = domainService.checkDomain(domain);
		User user = userService.findByEmail(principal.getName());
		domain.setUser(user);
		domainService.inset(domain);		
		return "redirect:/domain/all/1";
	}
	
	@Transactional
	@RequestMapping(value="edit/{id}", method = RequestMethod.GET)
	private String edit(@PathVariable("id") Integer id, Model model){
		model.addAttribute("domain", domainService.getById(id));
		return "domain-edit";
	}
	
	@RequestMapping(value="update", method = RequestMethod.POST)
	private String update(@ModelAttribute("domain") @Valid Domain domain,BindingResult result){
		if (result.hasErrors()) {			
			return "domain-edit";
		}		
		domainService.update(domain);
		return "redirect:/domain/all/1";
	}
	
	@RequestMapping(value="delete/{id}", method = RequestMethod.GET)
	private String delete(@PathVariable("id") Integer id){
		domainService.delete(id);
		return "redirect:/domain/all/1";		
	}
	
	@RequestMapping(value="all/{pageNumber}", method = RequestMethod.GET)
	private String viewAllDomains(@PathVariable Integer pageNumber, Model model){
		Page<Domain> page = domainService.getAll(pageNumber);
		
		int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    
	    model.addAttribute("domains", page.getContent());
	    model.addAttribute("domainLog", page);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
		return "domain-all";
	}
	
	
	
	
		
}
