package com.chapter2.chapter2;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.chapter2.chapter2.service.UserDetailServiceImpl;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/* add WebSecurityConfigurerAdapter to configure how Spring Security behaves */

@EnableWebSecurity //those two switch off the default web security configuration and we can define our own configuration in this class
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{  //WebSecurityConfigurerAdapter to configure how spring security behaves

//	@Override
//	protected void configure(HttpSecurity http) throws Exception { // this method defines which endpoint in the application are secured and which are not. So far it does nothing yet becoz we can use the default settings where all endpoints are secured
//		
//	}
	
	/*When use user information from DB, we don't need UserDetailsService method => commented out to disable in-memory users => but we have to add a new configureGlobal method */
//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() { //add in-memory to our application by adding UserDetailsService() method. In real case, we usually save the user info into DB and password should be saved in BCript.
//		UserDetails user = User.withUsername("user").password("password").roles("USER").build();
//		return new InMemoryUserDetailsManager(user);
//	}
	
	/*configureGlobal method is to enable users from DB*/
	/*note: use hashing algorithm to save user password to DB => BCrypt algorithm*/
	
	@Autowired
	private UserDetailServiceImpl userDetailsService;
	
	public void configureGlobal(AuthenticationManagerBuilder auth ) throws Exception { //Class AuthenticationManagerBuilder => method: userDetailsService(T userDetailsService) => Add authentication based the custom UserDetailsService that is passed in.
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	} 
}
