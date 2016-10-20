package com.orilinc.service;

import org.springframework.data.domain.Page;

import com.orilinc.entity.User;

public interface UserService {

	public User inset(User user);
	
	public Page<User> getAll(Integer pageNumber);
	
	public User getById(int id);
	
	public void update(User user);
	
	public void delete(int id);
	
	public User findByEmail(String email);
			
}
