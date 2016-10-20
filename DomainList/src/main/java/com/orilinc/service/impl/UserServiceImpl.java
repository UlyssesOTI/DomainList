package com.orilinc.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;





import com.orilinc.dao.UserDao;
import com.orilinc.entity.User;
import com.orilinc.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	private static final int PAGE_SIZE = 5;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public User inset(User user) {	
		user.setPassword(encoder.encode(user.getPassword()));
		return userDao.save(user);		
	}

	public Page<User> getAll(Integer pageNumber) {		
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "name");
	    return userDao.findAll(request);
		
	}

	public User getById(int id) {
		return userDao.findOne(id);
	}

	public void update(User user) {
		userDao.save(user);
	}

	public void delete(int id) {
		userDao.delete(id);
	}

	public User findByEmail(String email) {
		List<User> users = userDao.findByEmail(email);
		if(users!=null && users.size()>0){
			return users.get(0);
		}
		return null;
	}
	
	
}
