package com.miraj.connector;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.miraj.entity.User;
import com.miraj.repository.UserRepository;

@Component
public class UserConnector {

	@Autowired
	UserRepository userRepository;

	public Iterable<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int userId) {
		return userRepository.findOne(userId);
	}

	public User save(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAllUser(){
		return userRepository.findAllUser();
	}
	
	public List<User> findDonarsByRange(double latitude, double longitude){
		return userRepository.findDonarsAtFixedRange(latitude,longitude);
	}
	
	public List<User> findDonarsByBloodGroup(int bloodGroup){
		return userRepository.findDonarsAtFixedRangeByBloodGroup(bloodGroup);
	}

}
