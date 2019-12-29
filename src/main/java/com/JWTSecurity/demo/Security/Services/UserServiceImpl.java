package com.JWTSecurity.demo.Security.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JWTSecurity.demo.Security.Entity.User;
import com.JWTSecurity.demo.Security.Repositorys.UserRepository;

@Service
public class UserServiceImpl  implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	public User findByUsername(String username) {
        User result = userRepository.findByLogin(username);
       
        return result;
    }
	
	@Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            
            return null;
        }
        return result;
    }
}
