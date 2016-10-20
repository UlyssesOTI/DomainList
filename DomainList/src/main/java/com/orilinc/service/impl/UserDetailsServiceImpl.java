package com.orilinc.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.orilinc.dao.UserDao;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	
	
	public UserDetails loadUserByUsername(String login)	throws UsernameNotFoundException {
		com.orilinc.entity.User user = null;		
		List<com.orilinc.entity.User> users = userDao.findByEmail(login);
		if(users!=null && users.size()>0){
			user = users.get(0);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new User(String.valueOf(user.getEmail()), user.getPassword(), authorities);
	}

}