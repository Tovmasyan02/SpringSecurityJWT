package com.JWTSecurity.demo.Security.Entity;

import javax.persistence.*;



@Entity
@Table(name="USERS")
public class User {

	@Id
	@Column(name="ID")
	private long id;
	
	@Column(name="LOGIN")
	private String login;
	
	@Column(name="PASSWORD")
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROLEID", nullable = false)
    private Role role;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
