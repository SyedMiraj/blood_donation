package com.miraj.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.miraj.connector.FeedbackConnector;
import com.miraj.entity.ContactUsFeedback;
import com.miraj.model.ApiResponse;
import com.miraj.model.Feedback;
import com.miraj.model.FeedbackList;

@Component
public class ContactUsServiceImpl implements FeedbackServiceInterface{
	
	@Autowired
	FeedbackConnector feedbackConnector;

	@Override
	public Feedback getSingleFeedback(String feedbackId) {
		if(feedbackId != null){
			ContactUsFeedback contactUsFeedback = feedbackConnector.findOne(Integer.valueOf(feedbackId));
			if(contactUsFeedback != null){
				Feedback feedback = new Feedback();
				feedback.setId( String.valueOf(contactUsFeedback.getContactId()));
				feedback.setName(contactUsFeedback.getContactPerson());
				feedback.setEmail(contactUsFeedback.getContactEmail());
				feedback.setTitle(contactUsFeedback.getMessageTitle());
				feedback.setBody(contactUsFeedback.getMessage());
				return feedback;
			}
		}
		return null;
	}

	@Override
	public FeedbackList getAllFeedbacks() {
		FeedbackList feedbackList = new FeedbackList();
		List<Feedback> feedbacks = new ArrayList<>();
		Iterable<ContactUsFeedback> contactfeedbacks = feedbackConnector.findAll();
		if(contactfeedbacks != null){
			for(ContactUsFeedback contactUsFeedback : contactfeedbacks){
				Feedback feedback = new Feedback();
				feedback.setId( String.valueOf(contactUsFeedback.getContactId()));
				feedback.setName(contactUsFeedback.getContactPerson());
				feedback.setEmail(contactUsFeedback.getContactEmail());
				feedback.setTitle(contactUsFeedback.getMessageTitle());
				feedback.setBody(contactUsFeedback.getMessage());
				feedbacks.add(feedback);
			}
			feedbackList.setContacts(feedbacks);
		}
		return feedbackList;
	}

	@Override
	public ApiResponse addContactUsFeeddback(Feedback feedback) {
		if(feedback != null){
			ContactUsFeedback contactUsFeedback = new ContactUsFeedback();
			contactUsFeedback.setContactPerson(feedback.getName());
			contactUsFeedback.setContactEmail(feedback.getEmail());
			contactUsFeedback.setMessageTitle(feedback.getTitle());
			contactUsFeedback.setMessage(feedback.getBody());
			
			ContactUsFeedback newContactUsFeedback = feedbackConnector.save(contactUsFeedback);
			if(newContactUsFeedback != null){
				ApiResponse apiResponse = new ApiResponse();
				apiResponse.setStatus("STATUS");
				apiResponse.setResult("SUCCESS");
				return apiResponse;
			}
		}
		return null;
	}

	

	
}
