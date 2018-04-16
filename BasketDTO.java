package com.lauren.dto;

import java.util.List;
import com.lauren.dto.InfoDTO;
import com.lauren.dto.UserDTO;

public class BasketDTO {

	private int id;
	private double totalPrice;
	private UserDTO user;
	private List<InfoDTO> info;
	
	public BasketDTO() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public List<InfoDTO> getInfo() {
		return info;
	}

	public void setInfo(List<InfoDTO> info) {
		this.info = info;
	}
	
	
}
