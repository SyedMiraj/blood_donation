package com.miraj.model;

import io.swagger.annotations.ApiModelProperty;

public class Feedback {

	@ApiModelProperty("Feedback ID")
	private String id;
	
	@ApiModelProperty("Feedback person name")
	private String name;
	
	@ApiModelProperty("Feedback person email")
	private String email;
	
	@ApiModelProperty("Feedback title")
	private String title;
	
	@ApiModelProperty("Feedback message")
	private String body;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
