package com.lauren.dao;

import java.util.List;
import com.lauren.model.Book;
import com.lauren.model.Review;

public interface BookDAO {

	Book getBookById(int id);
	void addBook(Book book);
	List<Book> getAllBooks();
	
	
	//stock methods
	void updateAmount(Book book,int stock);
	void updatedAmount(Book book, int newStock);
	
	//review methods
	Review addNewReview(Book book,int rating, String username, String review);
	void addReview(Book book,Review review);	
	void updateReview(Review r,int rating,String review);
	
	
	
}