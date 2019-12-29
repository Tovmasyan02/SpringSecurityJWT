package com.JWTSecurity.demo.Security.Repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.JWTSecurity.demo.Security.Entity.Role;

@Repository
public  interface RoleRepository extends JpaRepository<Role,Long> {

	Role findByRoleName(String rolename);
}
