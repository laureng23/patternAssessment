package com.lauren.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.lauren.dto.BookDTO;
import com.lauren.dto.UserDTO;
import com.lauren.facadePattern.FacadeBook;
import com.lauren.facadePattern.FacadeUser;

@Controller
public class adminController {

	@Autowired
	private FacadeUser facadeUser;
	
	@Autowired
	private FacadeBook facadeBook;
	
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}
	
	
	@RequestMapping(value="/admin/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			@RequestParam(value="username", required=false) String username, 
			@RequestParam(value="password", required=false) String password) {
		if(username.equals("admin")) {
			UserDTO dto = facadeUser.login(username, password);
			if(dto!=null) {	
				request.getSession().setAttribute("currentUser",dto);
				return "redirect:books";
			}
		}
		return "redirect:/admin";
	}
	
	
	@RequestMapping(value="/admin/books", method = RequestMethod.GET)
	public String backofficeBooks(HttpServletRequest request,Model model) {
		List<BookDTO> books = facadeBook.getAllBooks();
		model.addAttribute("books", books);
		return "adminBookFunction";
	}
	
	@RequestMapping(value="/admin/users", method = RequestMethod.GET)
	public String backofficeUsers(HttpServletRequest request,Model model) {
		if(request.getSession().getAttribute("currentUser") ==null) {
			return "redirect:/admin";
		}else {
			UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
		
			if(currentUser.getUsername().equals("admin")) {
				List<UserDTO> users = facadeUser.getAllUsers();
				model.addAttribute("users", users);
				return "viewUsers";
			}else {
				return "redirect:/admin";
			}
		}
	}
	
	@RequestMapping(value="/admin/updateStock", method = RequestMethod.POST)
	public String searchBooks(Model model,HttpServletRequest request,
			@RequestParam(value="bookId", required=false) int bookId, 
			@RequestParam(value="newAmount", required=false) int newAmount) {
		if(request.getSession().getAttribute("currentUser") ==null) {
			return "redirect:/admin";
		}else {
			UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
			if(currentUser.getUsername().equals("admin")) {
				facadeBook.updateAmount(bookId, newAmount);
				return "redirect:/admin/books";
			}else {
				return "redirect:/admin";
			}
		}
		
	}
	

	
	@RequestMapping(value="/admin/addbook", method = RequestMethod.GET)
	public String addBookView(Model model,HttpServletRequest request) {
		if(request.getSession().getAttribute("currentUser") ==null) {
			return "addBook";
		}else {
			UserDTO currentUser = (UserDTO)request.getSession().getAttribute("currentUser");
			if(currentUser.getUsername().equals("admin")) {
				return "addBook";
			}else {
				return "redirect:/admin";
			}
		}
		
	}
	

	public FacadeUser getFacadeUser() {
		return facadeUser;
	}

	public void setFacadeUser(FacadeUser facadeUser) {
		this.facadeUser = facadeUser;
	}

	public FacadeBook getFacadeBook() {
		return facadeBook;
	}

	public void setFacadeBook(FacadeBook facadeBook) {
		this.facadeBook = facadeBook;
	}
	
	
	
}
