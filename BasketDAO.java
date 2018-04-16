package com.lauren.dao;

import com.lauren.model.User;
import com.lauren.model.Basket;

public interface BasketDAO {

	Basket addNewBasket(User user);
	
	Basket getBasketById(int id);
}