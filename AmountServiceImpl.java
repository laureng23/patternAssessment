package com.lauren.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lauren.dao.BookDAO;
import com.lauren.model.Book;
import com.lauren.model.Basket;
import com.lauren.model.Info;
import com.lauren.service.AmountService;

@Service
public class AmountServiceImpl implements AmountService {

	@Autowired
	private BookDAO bookDao;
	
	@Override
	public boolean updateAmount(Basket basket) {
		if(haveAmount(basket)) {
			for(Info info:basket.getInfo()) {
				int addAmount= info.getQuantity();
				Book book = info.getBook();
				bookDao.updateAmount(book, addAmount);
			}
			return true;
		}else {
			return false;
		}
	}
	
	private boolean haveAmount(Basket basket) {
		for(Info info:basket.getInfo()) {
			int addAmount = info.getQuantity();
			Book book = info.getBook();
			int stockAmount = book.getAmount();
			if(stockAmount<addAmount) {
				return false;
			}
		}
		return true;
	}

	public BookDAO getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	
}
