package com.lauren.service;

import java.util.List;
import com.lauren.model.User;

public interface UserService {

	User getUser(String id);
	
	boolean registerUser(User user);
	
	User updateUserDetail(String username, String shippingAddress, String paymentMethod);
	
	List<User> getAllUsers();

	
	
}
