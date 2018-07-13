package com.miraj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.miraj.model.ApiResponse;
import com.miraj.model.Feedback;
import com.miraj.serviceImpl.ContactUsServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/contact")
@Api(value="Api list for contact us mail", description="Contact us realed api")
public class ContactUsService {
	
	@Autowired
	ContactUsServiceImpl contactImpl;

	@ApiOperation(value = "Savings fedbacks from User")
	@RequestMapping(method = { RequestMethod.POST }, value = "/feedbacks", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ApiResponse submitContactFeedback(@RequestBody Feedback feedback){
		if(feedback != null){
			return contactImpl.addContactUsFeeddback(feedback);
		}
		return null;
	}
}

