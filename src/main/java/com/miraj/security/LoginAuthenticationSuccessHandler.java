package com.miraj.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.miraj.entity.User;
import com.miraj.serviceImpl.UserServiceImpl;

@Component
public class LoginAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	
	@Autowired
	UserServiceImpl serviceImpl;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		if (authentication != null && authentication.isAuthenticated()) {
			HttpSession session = request.getSession();
			User user = null;
			Collection<? extends GrantedAuthority> authourities = authentication.getAuthorities();
			for (GrantedAuthority grandAuthority : authourities) {
				if (!grandAuthority.getAuthority().equalsIgnoreCase("ROLE_USER")
						&& !grandAuthority.getAuthority().equalsIgnoreCase("ROLE_ADMIN")) {
					break;

				}
			}
			
			String mobileNumber = authentication.getName();
			if(mobileNumber != null) 
			{
				user = serviceImpl.findUserByMobile(mobileNumber);
			}
			if(user != null && user.getUserId() > 0) {
				session.setAttribute("userId", user.getUserId());
				response.sendRedirect("/home");
			}else {
				response.sendRedirect("/login");
			}
		}
	}
	
}
