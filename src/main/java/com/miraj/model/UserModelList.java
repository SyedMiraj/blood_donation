package com.miraj.model;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

public class UserModelList {

	@ApiModelProperty("List of users")
	private List<UserModel> userModelList;

	public List<UserModel> getUserModelList() {
		return userModelList;
	}

	public void setUserModelList(List<UserModel> userModelList) {
		this.userModelList = userModelList;
	}
	
}
