package com.lauren;

import com.lauren.dto.UserDTO;
import com.lauren.model.User;

public class Utils {

	
	public static UserDTO convertUserDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setUsername(user.getId());
		dto.setPayment(user.getPayment());
		dto.setAddress(user.getAddress());
		return dto;
	}
	


	
}
