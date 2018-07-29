package com.miraj.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.miraj.serviceImpl.UserServiceImpl;

@Service
public class ApplicationUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserServiceImpl serviceImpl;

	@Override
	public UserDetails loadUserByUsername(String mobileNumber) throws UsernameNotFoundException {
		if(mobileNumber != null) {
			com.miraj.entity.User user = serviceImpl.findUserByMobile(mobileNumber);
			GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
			UserDetails userDetails = (UserDetails)new User(user.getMobileNumber(),
					user.getPassword(), Arrays.asList(authority));
			return userDetails;
		}
		return null;
	}

}
