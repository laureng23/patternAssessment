package com.lauren.facadePattern;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import com.lauren.dto.BookDTO;

public interface FacadeBook {

	List<BookDTO> getAllBooks();
		
	BookDTO getBookById(int id);
	
	void addReview(int bookId,int rate, String username,String review);
	
	void updateAmount(int bookId,int newAmount);
	
	void addNewBook(MultipartFile file,String title,String author,String genre,int amount,String price);
}
