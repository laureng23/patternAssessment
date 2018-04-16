package com.lauren.facadePattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.lauren.Utils;
import com.lauren.dto.BasketDTO;
import com.lauren.model.Book;
import com.lauren.model.Basket;
import com.lauren.model.Info;
import com.lauren.model.User;
import com.lauren.facadePattern.FacadeBasket;
import com.lauren.service.BookService;
import com.lauren.service.BasketService;
import com.lauren.service.InfoService;
import com.lauren.service.UserService;

@Component
public class FacadeBasketImpl implements FacadeBasket{

	@Autowired
	private InfoService infoService;
	
	@Autowired
	private BasketService basketService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	public InfoService getInfoService() {
		return infoService;
	}

	public void setInfoService(InfoService infoService) {
		this.infoService = infoService;
	}

	public BasketService getBasketService() {
		return basketService;
	}

	public void setBasketService(BasketService basketService) {
		this.basketService = basketService;
	}
	
	
	@Override
	public BasketDTO addToNewBasket(String username,int bookId, int quantity) {
		User user = userService.getUser(username);
		Book book = bookService.getBookById(bookId);
		Basket basket = basketService.createNewBasket(user);
		Info info = infoService.createInfo(book, quantity);
		Basket newBasket = basketService.addToBasket(basket, info);
		return Utils.convertBasket(newBasket);
	}

	@Override
	public BasketDTO addToBasket(int basketId, int bookId, int quantity) {
		Basket basket = basketService.getBasketById(basketId);
		add(basket,bookId,quantity);
		return Utils.convertBasket(basketService.getBasketById(basketId));
	}
	
	private void add(Basket basket, int bookId, int quantity) {
		if(CollectionUtils.isEmpty(basket.getInfo())) {
			Book book = bookService.getBookById(bookId);
			Info info = infoService.createInfo(book, quantity);
			basketService.addToBasket(basket, info);
		}else {
			boolean contain = false;
			for(Info info:basket.getInfo()) {
				if(info.getBook().getId() == bookId) {
					contain = true;
					int q = info.getQuantity();
					info.setQuantity(q+quantity);
					infoService.updateInfo(info);
					basketService.calculateBasket(basket);
				}
			}
			if(!contain) {
				Book book = bookService.getBookById(bookId);
				Info info = infoService.createInfo(book, quantity);
				basketService.addToBasket(basket, info);
			}
		}
	}
	

}
