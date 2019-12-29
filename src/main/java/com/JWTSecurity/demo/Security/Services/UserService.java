package com.JWTSecurity.demo.Security.Services;

import com.JWTSecurity.demo.Security.Entity.User;

public interface UserService {
	
	User findByUsername(String username);

    User findById(Long id);


}
