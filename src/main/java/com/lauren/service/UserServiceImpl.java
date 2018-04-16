package com.lauren.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lauren.model.User;
import com.lauren.dao.UserDAO;
import com.lauren.dto.UserDTO;
import com.lauren.service.UserService;
import com.lauren.Utils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	@Override 
	public User login(String username, String password) {
		User user = userDao.getUserById(username);
		if(user!=null) {
			if(password.equals(user.getPassword())) {
				return Utils.convertUserDTO(user);
			}
		}
		return null;
	}
	
	@Override
	public boolean registerUser(String username, String password) {
		try {
			userDao.newUser(username, password);
			return true;
		}catch(Exception e) {
			return false;
		}	
	}
	
	@Override
	public User updateUserDetail(String username, String shippingAddress, String paymentMethod) {
		return userDao.updateUser(username, shippingAddress, paymentMethod);
	}
	
	@Override
	public User getUser(String id) {
		return userDao.getUserById(id);
	}
	
	
	

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<>(userDao.getAllUser());
		List<User> result = allUsers.stream().filter(user->!"admin".equals(user.getId())).collect(Collectors.toList());
		return result;
	}

	


}
