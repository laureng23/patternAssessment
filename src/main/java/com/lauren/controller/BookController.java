package com.lauren.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.lauren.dto.UserDTO;
import com.lauren.model.Book;
import com.lauren.service.BookService;


@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public String getAllBooks(Model model) {
		List<Book> books = bookService.getAllBook();
		model.addAttribute("books", books);
		return "books";	
	}
	
	
	@RequestMapping(value="/books/add", method = RequestMethod.POST)
	public String addBook(Model model,HttpServletRequest request,
			@RequestParam(value="image", required=false) MultipartFile image, 
			@RequestParam(value="title", required=false) String title,
			@RequestParam(value="author", required=false) String author,
			@RequestParam(value="genre", required=false) String genre,
			@RequestParam(value="amount", required=false) int amount,
			@RequestParam(value="price", required=false) String price) {
		if(request.getSession().getAttribute("currentUser") ==null) {
			return "redirect:/admin";
		}else {
			UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
			if(currentUser.getUsername().equals("admin")) {
				bookService.addNewBook(image, title, author, genre, amount, price);
				return "redirect:/admin/books";
			}else {
				return "redirect:/admin";
			}
		}
	}
	

	
}
