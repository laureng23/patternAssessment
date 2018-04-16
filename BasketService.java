package com.lauren.service;

import com.lauren.model.Basket;
import com.lauren.model.Info;
import com.lauren.model.User;

public interface BasketService {

	Basket createNewBasket(User user);
	
	Basket addToBasket(Basket basket,Info info);
	
	void calculateBasket(Basket basket);
	
	Basket getBasketById(int id);
}
