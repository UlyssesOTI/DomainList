package com.orilinc.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.orilinc.dao.UserDao;
import com.orilinc.entity.User;

@Component
public class UserValidator implements Validator{

	@Autowired
	private UserDao userDao;
	
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	public void validate(Object obj, Errors errors) {
		User user = (User) obj;
		List<User> users = userDao.findByEmail(user.getEmail());
		if(users!=null && users.size()>0){
			errors.rejectValue("email", "user.emailAlreadyRegistered");
		}
	}

}
