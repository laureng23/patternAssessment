package com.lauren.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lauren.model.Book;
import com.lauren.model.Review;

public interface BookService {
	
	List<Book> getAllBooks();
	
	Book getBookById(int id);
	
	void addNewReview(Book book,int rating, String review, String username);
	
	void updateReview(Review r, int rating, String review);
	
	void updateAmount(Book book, int newAmount);
	
	void addNewBook(MultipartFile file, String title, String author, String genre, int amount, String price);

}