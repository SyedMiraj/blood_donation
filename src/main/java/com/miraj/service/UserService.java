package com.miraj.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.miraj.model.ApiResponse;
import com.miraj.model.UserModel;
import com.miraj.model.UserModelList;
import com.miraj.serviceImpl.UserServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api")
@Api(value="Api list for user/s", description="User service realed api")
public class UserService {

	@Autowired
	UserServiceImpl userServiceImpl;

	 @Autowired
	 FreeMarkerConfigurer freemarkerConfigure;
	
	@ApiOperation(value = "Fetching all the users information.")
	@RequestMapping(method = { RequestMethod.GET }, value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody UserModelList getUsersDataList() {
		return userServiceImpl.findAllUser();
	}

//	@ApiOperation(value = "Fetching individual user information.")
//	@RequestMapping(method = {RequestMethod.GET }, value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody UserModel getUsersData(@PathVariable("userId") String userId) {
//		return userServiceImpl.findSingleUser(userId);
//	}

	@ApiOperation(value = "Update or add user information.")
	@RequestMapping(method = { RequestMethod.POST }, value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ApiResponse addUserModel(@RequestBody UserModel userModel) {
		return userServiceImpl.saveOrUpdateUser(userModel);
	}
	
	

	@RequestMapping(method = {RequestMethod.GET }, value = "/users/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ApiResponse getUser(@PathVariable("userId") String userId) {
        if (userId != null) {
            UserModel userModel = userServiceImpl.findSingleUser(userId);

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("user", userModel);
            ApiResponse apiResponse = new ApiResponse();
            String template = null;

            try {
                template = FreeMarkerTemplateUtils
                        .processTemplateIntoString(freemarkerConfigure.getConfiguration().getTemplate("show_user.ftl"), map);
                apiResponse.setResult(template);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return apiResponse;
        }
        return null;
    }


}
