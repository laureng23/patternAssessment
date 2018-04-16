package com.lauren.facadePattern;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lauren.Utils;
import com.lauren.dto.UserDTO;
import com.lauren.model.User;
import com.lauren.facadePattern.FacadeUser;
import com.lauren.service.UserService;

@Component
public class FacadeUserImpl implements FacadeUser {

	@Autowired
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public UserDTO getUserById(String username) {
		User user = userService.getUser(username);
		if(user!=null) {
			return Utils.convertUserDTO(user);
		}else {
			return null;
		}
	}
	
	@Override
	public boolean registerUser(String username,String firstname, String lastname, String email, String password) {
		User user = new User();
		user.setId(username);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);	
		return userService.registerUser(user);
	}
	
	@Override
	public UserDTO login(String username, String password) {
		User user = userService.getUser(username);
		if(user!=null) {
			if(password.equals(user.getPassword())) {
				return Utils.convertUserDTO(user);
			}
		}
		return null;
	}
	
	@Override
	public UserDTO updateUserDetail(String username, String address, String payment) {
		User user = userService.updateUserDetail(username, address, payment);
		return Utils.convertUserDTO(user);
	}
	
	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = userService.getAllUsers();
		List<UserDTO> result = new ArrayList<UserDTO>();
		for(User user:users) {
			result.add(Utils.convertUserDTO(user));
		}
		return result;
	}


}
