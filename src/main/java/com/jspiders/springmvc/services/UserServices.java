package com.jspiders.springmvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jspiders.springmvc.dao.UserDao;
import com.jspiders.springmvc.dto.UserDto;
@Component
public class UserServices {
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserDto userDto;
	
	public boolean addUser(String email,String password) {
		userDto.setEmail(email);
		userDto.setPassword(password);
		
		try {
			userDao.adduser(userDto);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public UserDto findUserByEmailAndPassword(String email,String password) {
		try {
			UserDto res = userDao.findUserByEmailAndPassword(email, password);
			System.out.println(res);
			return res;
		} catch (Exception e) {
			return null;
		}
		
	}

	public static void deleteUser(UserDto user) {
		UserDao.deleteUser(user.getId());
		
	}
}
