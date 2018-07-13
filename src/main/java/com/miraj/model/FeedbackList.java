package com.miraj.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class FeedbackList {

	@ApiModelProperty("List of feedbacks")
	private List<Feedback> contacts;

	public List<Feedback> getContacts() {
		return contacts;
	}

	public void setContacts(List<Feedback> contacts) {
		this.contacts = contacts;
	}
	
}
