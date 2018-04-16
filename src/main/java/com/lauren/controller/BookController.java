package com.lauren.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.lauren.dto.BookDTO;
import com.lauren.dto.UserDTO;
import com.lauren.facadePattern.FacadeBook;

@Controller
public class BookController {

	@Autowired
	private FacadeBook facadeBook;
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
	public String getAllBooks(Model model) {
		List<BookDTO> books = facadeBook.getAllBooks();
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
				facadeBook.addNewBook(image, title, author, genre, amount, price);
				return "redirect:/admin/books";
			}else {
				return "redirect:/admin";
			}
		}
	}
	
	@RequestMapping(value = "/book/imageDisplay", method = RequestMethod.GET)
	 public void showImage(@RequestParam("id") Integer id, HttpServletResponse response,HttpServletRequest request) throws IOException {
		BookDTO book = facadeBook.getBookById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
	    response.getOutputStream().write(book.getImage());
	    response.getOutputStream().close();
	}
	
	@RequestMapping(value="/add-review", method = RequestMethod.POST)
	public String addReview(HttpServletRequest request,Model model,
			@RequestParam(value="bookId", required=false) int bookId,
			@RequestParam(value="rating", required=false) int rating, 
			@RequestParam(value="review", required=false) String review) {
		UserDTO currentUser = (UserDTO) request.getSession().getAttribute("currentUser");
		if(currentUser!=null) {
			String username = currentUser.getUsername();
			facadeBook.addReview(bookId, rating, username, review);
			return "redirect:/books";
		}else {
			return "redirect:/home";
		}
		
	}
	
	@RequestMapping(value="/showReviews/{bookId}", method = RequestMethod.GET)
	public String showReview(HttpServletRequest request,Model model,@PathVariable("bookId") int bookId) {
		BookDTO book = facadeBook.getBookById(bookId);
		if(book!=null) {
			model.addAttribute("book",book);
			model.addAttribute("reviews",book.getReviews());
			return "reviews";
		}else {
			return "redirect:/books";
		}
		
	}
	
	public FacadeBook getFacadeBook() {
		return facadeBook;
	}

	public void setFacadeBook(FacadeBook bookFacade) {
		this.facadeBook = facadeBook;
	}
	
	
}
