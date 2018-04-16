package com.lauren.dao;


import java.util.List;
import com.lauren.model.User;

public interface UserDAO {
	
	User getUserById(String id);
	
	void newUser(User user);
	
	User updateUser(String username, String shippingAddress, String paymentMethod);
	
    List<User> getAllUser();
}
