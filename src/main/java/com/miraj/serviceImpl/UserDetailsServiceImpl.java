package com.miraj.serviceImpl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.miraj.connector.UserConnector;
import com.miraj.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserConnector userConnector;
	
	@Override
	public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException {
		if (mobileNumber != null) {
			User user = userConnector.findDonorByUserPhoneNumber(mobileNumber);
			if (user != null) {
				GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());

				org.springframework.security.core.userdetails.User userCred = new org.springframework.security.core.userdetails.User(
						mobileNumber, user.getPassword(), Arrays.asList(authority));
				
				UserDetails userDetails = (UserDetails) userCred;
				return userDetails;
			}
		}
		return null;
	}

	
}
