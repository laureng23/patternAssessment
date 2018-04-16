package com.lauren.facadePattern;

import java.util.List;

import com.lauren.dto.BasketDTO;
import com.lauren.dto.OrderDTO;

public interface FacadeOrder {

	OrderDTO placeOrder(BasketDTO basket);
	
	List<OrderDTO> getUserOrders(String username);
	
}
