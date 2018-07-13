package com.miraj.model;

import io.swagger.annotations.ApiModelProperty;

public class ApiResponse {

	@ApiModelProperty("Response status")
	private String status;
	
	@ApiModelProperty("Response result")
	private String result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
