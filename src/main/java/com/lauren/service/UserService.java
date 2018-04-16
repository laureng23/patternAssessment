package com.lauren.service;

import java.util.List;
import com.lauren.model.User;

public interface UserService {

	User getUser(String id);
	
	User login(String username, String password);
	
	boolean registerUser(String username, String password);
	
	User updateUserDetail(String username, String shippingAddress, String paymentMethod);
	
	List<User> getAllUsers();

	
	
}
