package com.miraj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/view")
public class ContactUsController {

	@RequestMapping(value="/contact")
	public String index(Model model){
		return "contact";
	}
}
