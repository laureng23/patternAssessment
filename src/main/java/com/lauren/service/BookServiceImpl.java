package com.lauren.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.StringUtils;
import com.lauren.dao.BookDAO;
import com.lauren.model.Book;
import com.lauren.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDao;
	
	public BookDAO getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDAO bookDao) {
		this.bookDao = bookDao;
	}

	
	@Override
	public List<Book> getAllBook() {	
		return bookDao.getAllBook();
	}
	
	@Override
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}
	
	@Override
	public void updateStock(Book book, int updatedStock) {
		bookDao.updateStock(book,updatedStock);
	}
	
	@Override
	public void addNewBook(MultipartFile file, String title, String author, String genre, int stock, String price) {
		try {
				byte[] imageByte = file!=null?file.getBytes():null;
				double bookPrice = StringUtils.isNullOrEmpty(price)?0.0:Double.parseDouble(price);
				Book book = new Book();
				bookDao.createBook(book);
			} catch (IOException e) {
				e.printStackTrace();
			}	
	}

	



}
