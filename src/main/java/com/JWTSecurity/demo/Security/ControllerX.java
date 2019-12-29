package com.JWTSecurity.demo.Security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.JWTSecurity.demo.Security.Entity.Role;
import com.JWTSecurity.demo.Security.Entity.User;
import com.JWTSecurity.demo.Security.Repositorys.RoleRepository;
import com.JWTSecurity.demo.Security.Repositorys.UserRepository;
import com.JWTSecurity.demo.Security.Services.JwtTokenProvider;
import com.JWTSecurity.demo.Security.Services.UserService;

@RestController
public class ControllerX 
{
	 private final AuthenticationManager authenticationManager;

	    private final JwtTokenProvider jwtTokenProvider;

	    private final UserService userService;
	    
	  
	    private final RoleRepository x;

	    @Autowired
	    public ControllerX(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService,RoleRepository x) {
	        this.x = x;
			this.authenticationManager = authenticationManager;
	        this.jwtTokenProvider = jwtTokenProvider;
	        this.userService = userService;
	    }
	    
	 //   @GetMapping("login/{l}/{p}")
	   // public String fgf(@PathVariable String l, @PathVariable String p )
	   // { 
	   // 	return l+"  "+p;
	   // 	
	   // }
	    
	    @SuppressWarnings("deprecation")
		@GetMapping("/rest/d")
	    public String xxx()
	    {
	    	//return x.findById(new Long(1)).get().getRoleName();
	    	return "fff";
	    }

	    @SuppressWarnings("rawtypes")
	    @GetMapping("login/{l}/{p}")
	    public ResponseEntity login(@PathVariable String l, @PathVariable String p) {
	        try {
	            String username =l;
	           // authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, p));
	            User user = userService.findByUsername(username);

	            if (user == null) {
	                throw new UsernameNotFoundException("User with username: " + username + " not found");
	            }
	            List<Role> roles=new ArrayList<Role>();
	            roles.add(user.getRole());
	            String token = jwtTokenProvider.createToken(username, roles);

	            Map<Object, Object> response = new HashMap<>();
	            response.put("username", username);
	            response.put("token", token);

	            return ResponseEntity.ok(response);
	        } catch (AuthenticationException e) {
	            throw new BadCredentialsException("Invalid username or password");
	        }
	    }

}
