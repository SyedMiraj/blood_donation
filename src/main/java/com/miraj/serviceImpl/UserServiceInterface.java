package com.miraj.serviceImpl;

import com.miraj.entity.User;
import com.miraj.model.ApiResponse;
import com.miraj.model.UserModel;
import com.miraj.model.UserModelList;

public interface UserServiceInterface {

	public UserModelList findAllUser();
	
	public UserModel findSingleUser(String userId);
	
	public User findUserByMobile(String mobileNumber);
	
	public ApiResponse saveOrUpdateUser(UserModel userModel);
	
	public void deleteUser(String userId);
}
