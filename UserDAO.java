package com.lauren.dao;

import java.util.List;

import com.lauren.model.User;
import com.lauren.model.Order;

public interface UserDAO {
	
	User getUserById(String id);
	
	void addUser(User user);
	
	User updateUser(String username, String shippingAddress, String paymentMethod);
	
    void addUserOrder(User user,Order order) ;
    
    List<User> getAllUsers();
}
