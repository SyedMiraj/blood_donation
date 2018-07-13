package com.miraj.connector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.miraj.entity.ContactUsFeedback;
import com.miraj.repository.ContactUsRepo;

@Component
public class FeedbackConnector {

	@Autowired
	ContactUsRepo contactUsRepo;
	
	public ContactUsFeedback findOne(int contactId){
		return contactUsRepo.findOne(contactId);
	}
	
	public Iterable<ContactUsFeedback> findAll(){
		return contactUsRepo.findAll();
	}
	
	public ContactUsFeedback save(ContactUsFeedback contactUs){
		return contactUsRepo.save(contactUs);
	}
	
	public void delete(int contactUsId){
		contactUsRepo.delete(contactUsId);
	}
}
