package com.miraj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home")
	public String openHomePage(Model model){
		model.addAttribute("welcome","Blood donation group");
		return "home";
	}
	
	@RequestMapping(value="/exchange/donors")
	public String openDonorsPage(Model model){
		return "donate";
	}
	
	@RequestMapping(value="/exchange/search")
	public String openCollectorPage(Model model){
		return "registration";
	}

	@RequestMapping(value="/joinus")
	public String openRegistrationPage(Model model){
		return "registration";
	}
	
	@RequestMapping(value="/userupdate")
	public String openUserUpdatePage(Model model){
		return "user_update";
	}
	
	@RequestMapping(value="/login")
	public String openLoginPage(Model model){
		return "login";
	}
}
