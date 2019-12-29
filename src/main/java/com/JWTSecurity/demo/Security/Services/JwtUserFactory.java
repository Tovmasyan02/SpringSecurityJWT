package com.JWTSecurity.demo.Security.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.JWTSecurity.demo.Security.Entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import Security.JwtUser;

public class JwtUserFactory {
	
	public JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                mapToGrantedAuthorities(user.getRole().getRoleName())

        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(String userRoles) {
       List<GrantedAuthority> roles=new ArrayList<GrantedAuthority>();
       roles.add(new SimpleGrantedAuthority(userRoles));
       return roles;
    }
}
