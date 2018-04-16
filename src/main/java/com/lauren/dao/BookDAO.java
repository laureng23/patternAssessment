package com.lauren.dao;

import java.util.List;
import com.lauren.model.Book;


public interface BookDAO {

	Book getBookById(int id);
	
	void createBook(Book book);
	
	void updateStock(Book book,int stock);
	
	List<Book> getAllBook();
	
}
