package com.lauren;

import com.lauren.dto.UserDTO;
import com.lauren.model.User;

public class Utils {

	
	public static User convertUserDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId());
		dto.setUsername(user.getPersonId());
		dto.setPayment(user.getPayment());
		dto.setAddress(user.getAddress());
		return user;
	}
	


	
}
