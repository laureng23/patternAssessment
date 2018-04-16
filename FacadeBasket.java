package com.lauren.facadePattern;


import com.lauren.dto.BasketDTO;

public interface FacadeBasket {
	
	BasketDTO addToNewBasket(String username,int bookId,int quantity);
	
	BasketDTO addToBasket(int basketId,int bookId, int quantity);

}
