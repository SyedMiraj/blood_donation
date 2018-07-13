package com.miraj.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.miraj.connector.UserConnector;
import com.miraj.entity.BloodInformation;
import com.miraj.entity.User;
import com.miraj.model.CollectionRequest;
import com.miraj.model.UserModel;
import com.miraj.model.UserModelList;
import com.miraj.support.Utility;

@Component
public class CollectionServiceImpl implements CollectionServiceInterface {

    @Autowired
    UserConnector userConnector;

    @Autowired
    Utility utility;

    @Override
    public UserModelList getFilteredData(CollectionRequest collectionRequest) {
        List<User> userList = new ArrayList<>();

        List<User> unfilteredUser = userConnector.findAllUser();
        if (unfilteredUser != null && !unfilteredUser.isEmpty()) {
            userList.addAll(unfilteredUser);
        } else {
            userList.retainAll(unfilteredUser);
        }

        if (collectionRequest.getLatitude() != null && collectionRequest.getLongitude() != null) {
            if (collectionRequest.getRange() != null) {
                List<User> usersInRange = new ArrayList<>();
                for (User user : unfilteredUser) {
                    double distance = utility.distance(user.getLatitude(), user.getLongitude(),
                            Double.valueOf(collectionRequest.getLatitude()),
                            Double.valueOf(collectionRequest.getLongitude()), "K");
                    if (distance <= Double.valueOf(collectionRequest.getRange())) {
                        usersInRange.add(user);
                    }
                }
                if (usersInRange != null && !usersInRange.isEmpty()) {
                    userList.retainAll(usersInRange);
                } else {
                    userList.addAll(usersInRange);
                }
            }
        }

        if (collectionRequest.getBloodGroup() != null) {
            List<User> usersHavingSpecifiedBlood = new ArrayList<>();
            usersHavingSpecifiedBlood = userConnector.findDonarsByBloodGroup(Integer.valueOf((collectionRequest.getBloodGroup())));
            if (usersHavingSpecifiedBlood != null && !usersHavingSpecifiedBlood.isEmpty()) {
                userList.retainAll(usersHavingSpecifiedBlood);
            } else {
                userList.addAll(usersHavingSpecifiedBlood);
            }
        }

        return convertUserToUserModelList(userList);
    }

    public UserModelList convertUserToUserModelList(List<User> users) {
        UserModelList userModelList = new UserModelList();
        List<UserModel> userModels = new ArrayList<>();
        if (users != null && !users.isEmpty()) {
            for (User user : users) {
                UserModel userModel = new UserModel();
                userModel.setId(String.valueOf(user.getUserId()));
                userModel.setName(user.getName());
                userModel.setMobileNumber(user.getMobileNumber());
                userModel.setEmailAddress(user.getEmail());

                if (user.getLastBloodDonateDate() != null) {
                    userModel.setLastBloodDonate(utility.convertTimestampToString(user.getLastBloodDonateDate()));
                }
                if (user.getLatitude() > 0) {
                    userModel.setLatitude(String.valueOf(user.getLatitude()));
                }
                if (user.getLongitude() > 0) {
                    userModel.setLongitude(String.valueOf(user.getLongitude()));
                }
                BloodInformation bloodInformation = user.getBloodInformation();
                if (bloodInformation != null) {
                    userModel.setBloodGroup(bloodInformation.getBloodGroup());
                }
                userModels.add(userModel);
            }
            userModelList.setUserModelList(userModels);
        }
        return userModelList;
    }
}
