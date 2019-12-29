package com.JWTSecurity.demo.Security.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.JWTSecurity.demo.Security.Entity.User;

import Security.JwtUser;

@Service
public class JwtDetailsUserService implements UserDetailsService {


	private final UserService userService;
	
	@Autowired
	public JwtDetailsUserService(UserService userService) {
	    this.userService = userService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    User user = userService.findByUsername(username);
	
	    if (user == null) {
	        throw new UsernameNotFoundException("User with username: " + username + " not found");
	    }
	
	    JwtUser jwtUser = JwtUserFactory.create(user);
	   
	    return jwtUser;
	}
}