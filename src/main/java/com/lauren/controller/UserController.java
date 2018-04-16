package com.lauren.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lauren.facadePattern.FacadeUser;
import com.lauren.dto.UserDTO;

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

	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String home() {
		return "register";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String doRegister(HttpServletRequest request,
			@RequestParam(value="username", required=false) String username, 
			@RequestParam(value="password", required=false) String password) {
		if(facadeUser.registerUser(username, password)) {
			return "redirect:/home";
		}else {
			return "register";
		}
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String doLogin(HttpServletRequest request,
			@RequestParam(value="username", required=false) String username, 
			@RequestParam(value="password", required=false) String password) {
		UserDTO dto = facadeUser.login(username, password);
		if(dto!=null) {
			request.getSession().setAttribute("currentUser",dto);
			return "redirect:books";
		}else {
			return "redirect:welcome";
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
				return "redirect:/welcome";
			}
		}else {
			return "redirect:/welcome";
		}
	}
	
}