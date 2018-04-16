package com.lauren.facadePattern;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lauren.Utils;
import com.lauren.dto.BookDTO;
import com.lauren.model.Book;
import com.lauren.model.Review;
import com.lauren.facadePattern.FacadeBook;
import com.lauren.service.BookService;

@Component
public class FacadeBookImpl implements FacadeBook {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private  BeanFactory beanFactory;
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}
	
	@Override
	public BookDTO getBookById(int id) {
		Book book = bookService.getBookById(id);
		return Utils.convertBookDTO(book);
	}
	
	@Override
	public List<BookDTO> getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		List<BookDTO> result = new ArrayList<BookDTO>();
		if(!CollectionUtils.isEmpty(books)) {
			for(Book book: books) {
				result.add(Utils.convertBookDTO(book));
			}
		}
		return result;
	}
	
	
	@Override
	public void addReview(int bookId, int rating, String username, String review) {
		Book book = bookService.getBookById(bookId);
		if(CollectionUtils.isEmpty(book.getReview())) {
			bookService.addNewReview(book, rating, review, username);
		}else {
			boolean reviewPresent = false;
			for(Review r:book.getReview()) {
				if(r.getUsername().equals(username)) {
					reviewPresent = true;
					bookService.updateReview(r, rating, review);
				}
			}
			if(!reviewPresent) {
				bookService.addNewReview(book, rating, review, username);
			}
		}
	}
	

	@Override
	public void updateAmount(int bookId, int newAmount) {
		Book book = bookService.getBookById(bookId);
		bookService.updateAmount(book, newAmount);		
	}
	
	@Override
	public void addNewBook(MultipartFile file, String title, String author, String genre, int amount, String price) {
		bookService.addNewBook(file, title, author, genre, amount, price);
	}



}
