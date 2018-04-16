package com.lauren.service;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import com.lauren.model.Book;


public interface BookService {
	
	List<Book> getAllBook();
	
	Book getBookById(int id);
	
	void updateStock(Book book, int updatedStock);
	
	void addNewBook(MultipartFile file, String title, String author, String genre, int stock, String price);

}
