package com.lauren.facadePattern;

import java.util.List;
import com.lauren.dto.UserDTO;

public interface FacadeUser {
	
	boolean registerUser(String username, String firstname, String lastname, String email,String password);
	
	UserDTO login(String username,String password);
	
	UserDTO updateUserDetail(String username, String address, String payment);
	
	List<UserDTO> getAllUsers();
	
	UserDTO getUserById(String username);
}
