package Security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.JWTSecurity.demo.Security.Entity.User;

public class JwtUser implements UserDetails {
	
	private final Long id;
    private final String login;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    
	public JwtUser (
			Long id,
            String login,
            String password, 
            Collection<? extends GrantedAuthority> authorities
            )
	{
	  this.id=id;
	  this.login=login;
	  this.password=password;
	  this.authorities=authorities;
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("Size --"+this.authorities.size());
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		
		return this.login;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
