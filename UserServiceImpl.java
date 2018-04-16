package com.lauren.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lauren.dao.UserDAO;
import com.lauren.model.Order;
import com.lauren.model.User;
import com.lauren.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;
	
	@Override
	public boolean registerUser(User user) {
		try {
			userDao.addUser(user);
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
	public void addUserToOrder(User user, Order order) {
		userDao.addUserOrder(user, order);
	}
	

	@Override
	public List<User> getAllUsers() {
		List<User> allUsers = new ArrayList<>(userDao.getAllUsers());
		List<User> result = allUsers.stream().filter(user->!"admin".equals(user.getId())).collect(Collectors.toList());
		return result;
	}

	public UserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}


}
