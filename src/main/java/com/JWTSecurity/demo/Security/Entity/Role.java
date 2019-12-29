package com.JWTSecurity.demo.Security.Entity;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.transaction.Transactional;


@Entity
@Table(name="ROLES")
public class Role {
	
	@Id
	@Column(name="ROLEID")
	private long roleId;
	
	@Column(name="ROLENAME")
	private String roleName;

	@OneToMany(cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,
		    mappedBy = "role")
				List<User> allusers=new ArrayList<>();

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return "ROLE_"+roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getAllusers() {
		if(this.allusers!=null)
			return allusers;
		return new ArrayList<User>();
	}

	public void setAllusers(List<User> allusers) {
		this.allusers = allusers;
	}
	
	
}
