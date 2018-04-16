package com.lauren.service;

import com.lauren.model.Basket;
import com.lauren.model.Order;

public interface OrderService {

	Order placeOrder(Basket basket);
	
}
