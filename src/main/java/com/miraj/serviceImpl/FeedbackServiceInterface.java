package com.miraj.serviceImpl;

import com.miraj.model.ApiResponse;
import com.miraj.model.Feedback;
import com.miraj.model.FeedbackList;

public interface FeedbackServiceInterface {

	public Feedback getSingleFeedback(String feedbackId);
	
	public FeedbackList getAllFeedbacks();
	
	public ApiResponse addContactUsFeeddback(Feedback feedback);
	
}
