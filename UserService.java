package com.lauren.service;

import java.util.List;

import com.lauren.model.Order;
import com.lauren.model.User;

public interface UserService {

	boolean registerUser(User user);
	
	User getUser(String id);
	
	User updateUserDetail(String username, String shippingAddress, String paymentMethod);
	
	void addUserToOrder(User user, Order orders);
	
	List<User> getAllUsers();
	
}
