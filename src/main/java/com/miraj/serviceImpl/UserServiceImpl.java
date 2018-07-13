package com.miraj.serviceImpl;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.miraj.connector.BloodInformationConnector;
import com.miraj.connector.UserConnector;
import com.miraj.entity.BloodInformation;
import com.miraj.entity.User;
import com.miraj.model.ApiResponse;
import com.miraj.model.UserModel;
import com.miraj.model.UserModelList;
import com.miraj.support.Utility;

@Component
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    UserConnector userConnector;

    @Autowired
    Utility utility;

    @Autowired
    BloodInformationConnector bloodInformationConnector;

    @Override
    public UserModelList findAllUser() {
        UserModelList userModelList = new UserModelList();
        List<UserModel> userModels = new ArrayList<>();
        Iterable<User> userList = userConnector.findAll();
        if (userList != null) {
            for (User user : userList) {
                UserModel userModel = new UserModel();
                userModel.setId(String.valueOf(user.getUserId()));

                userModel.setName(user.getName());
                userModel.setEmailAddress(user.getEmail());
                userModel.setMobileNumber(user.getMobileNumber());

                BloodInformation bloodInformation = user.getBloodInformation();
                if (bloodInformation != null) {
                    userModel.setBloodGroup(bloodInformation.getBloodGroup());
                }
//				userModel.setAddress(user.getAddress());
                userModels.add(userModel);
            }
            userModelList.setUserModelList(userModels);
        }
        return userModelList;
    }

    @Override
    public UserModel findSingleUser(String userId) {
        if (userId != null) {
            User user = userConnector.findOne(Integer.valueOf(userId));
            if (user != null) {
            	SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
                UserModel userModel = new UserModel();
                userModel.setId(String.valueOf(user.getUserId()));
                userModel.setName(user.getName());
                userModel.setEmailAddress(user.getEmail());
                userModel.setMobileNumber(user.getMobileNumber());
				String ld = dateformat.format(user.getLastBloodDonateDate());
                userModel.setLastBloodDonate(ld);
                String dob = dateformat.format(user.getDateOfBirth());
                userModel.setDateOfBith(dob);
                userModel.setLatitude(String.valueOf(user.getLatitude()));
                userModel.setLongitude(String.valueOf(user.getLongitude()));

                BloodInformation bloodInformation = user.getBloodInformation();
                if (bloodInformation != null) {
                    userModel.setBloodGroup(bloodInformation.getBloodGroup());
                }
//				userModel.setAddress(user.getAddress());
                return userModel;
            }
        }
        return null;
    }

    @Override
    public ApiResponse saveOrUpdateUser(UserModel userModel) {
        User user;
        if (userModel.getId() != null) {
            user = userConnector.findOne(Integer.valueOf(userModel.getId()));
        } else {
            user = new User();
        }
        if (userModel.getName() != null) {
            user.setName(userModel.getName());
        }
        if (userModel.getDateOfBith() != null) {
            Timestamp timestamp = utility.getTimestamp(userModel.getDateOfBith());
            user.setDateOfBirth(timestamp);
        }
        if (userModel.getEmailAddress() != null) {
            user.setEmail(userModel.getEmailAddress());
        }
        if (userModel.getLatitude() != null) {
            user.setLatitude(Double.valueOf(userModel.getLatitude()));
        }
        if (userModel.getLongitude() != null) {
            user.setLongitude(Double.valueOf(userModel.getLongitude()));
        }
        if (userModel.getMobileNumber() != null) {
            user.setMobileNumber(userModel.getMobileNumber());
        }

        if (userModel.getLastBloodDonate() != null) {
            user.setLastBloodDonateDate(utility.getTimestamp(userModel.getLastBloodDonate()));
        }
        BloodInformation bloodInformation;
        if (userModel.getBloodGroupId() != null) {
            bloodInformation = bloodInformationConnector.finOne(Integer.valueOf(userModel.getBloodGroupId()));
        } else {
            bloodInformation = new BloodInformation();
            bloodInformation.setBloodGroup(userModel.getBloodGroup());
            bloodInformation = bloodInformationConnector.addOrUpdateBlood(bloodInformation);
        }
        if (bloodInformation != null) {
            user.setBloodInformation(bloodInformation);
        }
        User newOrUpdatedUser = userConnector.save(user);
        if (newOrUpdatedUser != null) {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setStatus("Status");
            apiResponse.setResult("Success");
            return apiResponse;
        }
        return null;
    }

    @Override
    public void deleteUser(String userId) {
        // TODO Auto-generated method stub

    }

}
