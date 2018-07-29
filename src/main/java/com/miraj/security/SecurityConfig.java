package com.miraj.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled  = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	ApplicationUserDetailsService userDetails;
	
	@Autowired
	LoginAuthenticationSuccessHandler successHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
	    .authorizeRequests()
	  	.antMatchers("/home").authenticated()
		.and().formLogin()
		.loginPage("/login")
		.loginProcessingUrl("/signin")
		.usernameParameter("user_mobile")
		.passwordParameter("user_password")
		.successHandler(successHandler);
	}
	
	   @Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder);
		}

	
}
