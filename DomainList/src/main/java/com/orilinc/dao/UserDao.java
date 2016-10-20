package com.orilinc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.orilinc.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.email like :login ")
	public List<User> findByEmail(@Param("login") String email);

}
