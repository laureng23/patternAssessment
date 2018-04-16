package com.lauren.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lauren.dto.BasketDTO;
import com.lauren.dto.OrderDTO;
import com.lauren.facadePattern.FacadeOrder;

@Controller
public class OrderController {

	@Autowired
	private FacadeOrder facadeOrder;
	
	@RequestMapping(value="/order/placeOrder", method = RequestMethod.POST)
	public String placeOrder(HttpServletRequest request,Model model) {
		if(request.getSession().getAttribute("sessionBasket")!=null&&request.getSession().getAttribute("currentUser")!=null) {
			BasketDTO basket = (BasketDTO) request.getSession().getAttribute("sessionBasket");
			OrderDTO order = facadeOrder.placeOrder(basket);
			if(order!=null) {
				 request.getSession().setAttribute("placedOrder",order);
				 request.getSession().setAttribute("sessionBasket",null);
				 return "redirect:/confirmation";
			}else {
				 return "redirect:/basket";
			}
		}
		return null;		
	}
	
	@RequestMapping(value="/confirmation", method = RequestMethod.GET)
	public String orderConfirmation(HttpServletRequest request,Model model) {
		if(request.getSession().getAttribute("placedOrder")!=null&&request.getSession().getAttribute("currentUser")!=null) {
			OrderDTO order = (OrderDTO)request.getSession().getAttribute("placedOrder");
			model.addAttribute("order",order);
			return "confirmation";
		}else {
			return "redirect:/basket";
		}
	}
	
	@RequestMapping(value="/order/user/{username}", method = RequestMethod.GET)
	public String getUserOrder(HttpServletRequest request,Model model,@PathVariable("username") String username) {
		if(request.getSession().getAttribute("currentUser") ==null) {
			return "redirect:/admin";
		}else {
			List<OrderDTO> orders = facadeOrder.getUserOrders(username);
			model.addAttribute("order",orders);
			return "allOrders";
		}		
	}

	public FacadeOrder getFacadeOrder() {
		return facadeOrder;
	}

	public void setFacadeOrder(FacadeOrder facadeOrder) {
		this.facadeOrder = facadeOrder;
	}
	
	
	
}
