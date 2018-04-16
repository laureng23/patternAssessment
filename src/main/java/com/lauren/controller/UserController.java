package com.lauren.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.lauren.service.UserService;
import com.lauren.dto.UserDTO;
import com.lauren.model.User;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request,
			@RequestParam(value="username", required=false) String username, 
			@RequestParam(value="password", required=false) String password) {
		if(userService.registerUser(username, password)) {
			return "redirect:/welcome";
		}else {
			return "register";
		}
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request,
			@RequestParam(value="username", required=false) String username, 
			@RequestParam(value="password", required=false) String password) {
		User user = userService.login(username, password);
		if(user!=null) {
			request.getSession().setAttribute("currentUser",user);
			return "redirect:books";
		}else {
			return "redirect:home";
		}	
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public String doLogout(HttpServletRequest request) {
		if(request.getSession().getAttribute("currentUser")!=null) {
			UserDTO currentUser = (UserDTO) request.getSession().getAttribute("currentUser");
			request.getSession().setAttribute("currentUser",null);
			request.getSession().setAttribute("sessionCart",null);
			if(currentUser.getUsername().equals("admin")) {
				return "redirect:/admin";
			}else {
				return "redirect:/home";
			}
		}else {
			return "redirect:/home";
		}
	}

	
}

