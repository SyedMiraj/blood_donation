package com.miraj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miraj.model.UserModel;
import com.miraj.serviceImpl.UserServiceImpl;;

@Controller
public class HomeController {
	
	@Autowired
	UserServiceImpl userService;
	
	@RequestMapping(value="/home")
	public String openHomePage(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("userId");
		if(id > 0){
			UserModel user = userService.findSingleUser(String.valueOf(id));
			model.addAttribute("user", user);	
			model.addAttribute("authenticated", true);
		}else{
			model.addAttribute("authenticated", false);
		}
		return "home";
	}
	
	@RequestMapping(value="/exchange/donors")
	public String openDonorsPage(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("userId");
		if(id > 0){
			UserModel user = userService.findSingleUser(String.valueOf(id));
			model.addAttribute("user", user);	
			model.addAttribute("authenticated", true);
		}else{
			model.addAttribute("authenticated", false);
		}
		return "donate";
	}
	
	@RequestMapping(value="/exchange/search")
	public String openCollectorPage(Model model){
		model.addAttribute("authenticated", false);
		return "registration";
	}

	@RequestMapping(value="/joinus")
	public String openRegistrationPage(Model model){
		model.addAttribute("authenticated", false);
		return "registration";
	}
	
	@RequestMapping(value="/userupdate")
	public String openUserUpdatePage(HttpServletRequest request, Model model){
		HttpSession session = request.getSession();
		int id = (int)session.getAttribute("userId");
		if(id > 0){
			UserModel user = userService.findSingleUser(String.valueOf(id));
			model.addAttribute("user", user);	
			model.addAttribute("authenticated", true);
		}else{
			model.addAttribute("authenticated", false);
		}
		
		return "user_update";
	}
	
	@RequestMapping(value="/login")
	public String openLoginPage(HttpServletRequest request, Model model){		
		model.addAttribute("authenticated", false);
		return "login";
	}
}
