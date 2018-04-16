package com.lauren.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.lauren.dto.UserDTO;
import com.lauren.facadePattern.FacadeUser;

@Controller
public class UserController {
	@Autowired
	private FacadeUser facadeUser;
	
	public FacadeUser getFacadeUser() {
		return facadeUser;
	}

	public void setFacadeUser(FacadeUser facadeUser) {
		this.facadeUser = facadeUser;
	}

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String homePage() {
		return "register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request,
			@RequestParam(value="username", required=false) String username, 
			@RequestParam(value="firstname", required=false) String firstname, 
			@RequestParam(value="lastname", required=false) String lastname, 
			@RequestParam(value="email", required=false) String email, 
			@RequestParam(value="password", required=false) String password) {
		if(facadeUser.registerUser(username, firstname, lastname,email, password)) {
			return "redirect:/home";
		}else {
			return "register";
		}
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			@RequestParam(value="username", required=false) String username, 
			@RequestParam(value="password", required=false) String password) {
		UserDTO dto = facadeUser.login(username, password);
		if(dto!=null) {
			request.getSession().setAttribute("currentUser",dto);
			return "redirect:books";
		}else {
			return "redirect:home";
		}	
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public String logout(HttpServletRequest request) {
		if(request.getSession().getAttribute("currentUser")!=null) {
			UserDTO currentUser = (UserDTO) request.getSession().getAttribute("currentUser");
			request.getSession().setAttribute("currentUser",null);
			request.getSession().setAttribute("sessionBasket",null);
			if(currentUser.getUsername().equals("admin")) {
				return "redirect:/admin";
			}else {
				return "redirect:/home";
			}
		}else {
			return "redirect:/home";
		}
	}
	
	@RequestMapping(value="/userAccount", method = RequestMethod.GET)
	public String userAccount(HttpServletRequest request,Model model) {
		UserDTO currentUser = (UserDTO) request.getSession().getAttribute("currentUser");
		if(currentUser!=null) {
			model.addAttribute("currentUser", currentUser);
			return "userAccount";
		}else {
			return "redirect:home";
		}
		
	}
	
	@RequestMapping(value="/edit-account", method = RequestMethod.POST)
	public String editUserAccount(HttpServletRequest request,Model model,
			@RequestParam(value="address", required=false) String address, 
			@RequestParam(value="payment", required=false) String payment) {
		
		UserDTO currentUser = (UserDTO) request.getSession().getAttribute("currentUser");
		String username = currentUser.getUsername();
		UserDTO updateUser = facadeUser.updateUserDetail(username, address, payment);
		request.getSession().setAttribute("currentUser",updateUser);
		model.addAttribute("currentUser", updateUser);
		return "redirect:userAccount";
	}

	
}
