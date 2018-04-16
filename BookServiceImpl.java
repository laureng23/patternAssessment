package com.lauren.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.StringUtils;
import com.lauren.dao.BookDAO;
import com.lauren.model.Book;
import com.lauren.model.Review;
import com.lauren.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDao;
	
	@Override
	public List<Book> getAllBooks() {	
		return bookDao.getAllBooks();
	}
	
	@Override
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

	@Override
	public void addNewReview(Book book, int rating, String review, String username) {
		Review newReview = bookDao.addNewReview(book, rating, username, review);
		bookDao.addReview(book, newReview);
	}
	@Override
	public void updateReview(Review r, int rating, String review) {
		bookDao.updateReview(r, rating, review);
	}

	@Override
	public void updateAmount(Book book, int newAmount) {
		bookDao.updatedAmount(book,newAmount);
	}
	
	@Override
	public void addNewBook(MultipartFile file, String title, String author, String genre, int amount, String price) {
		try {
				byte[] imageByte = file!=null?file.getBytes():null;
				double bookPrice = StringUtils.isNullOrEmpty(price)?0.0:Double.parseDouble(price);
				Book book = new Book.BookBuilder().setAuthor(author)
						.setTitle(title)
						.setGenre(genre)
						.setPrice(bookPrice)
						.setAmount(amount)
						.setBookImage(imageByte)
						.build();
				bookDao.addBook(book);
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}

	public BookDAO getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}




}
