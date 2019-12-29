package com.JWTSecurity.demo.Security.Repositorys;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.JWTSecurity.demo.Security.Entity.User;


@Repository

public interface UserRepository extends JpaRepository<User,Long> {
 
	User findByLogin(String login);
	Optional<User> findById(Long i);
}
