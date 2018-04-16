package com.lauren.facadePattern;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.lauren.Utils;
import com.lauren.dto.BasketDTO;
import com.lauren.dto.OrderDTO;
import com.lauren.model.Basket;
import com.lauren.model.Order;
import com.lauren.model.User;
import com.lauren.facadePattern.FacadeOrder;
import com.lauren.service.BasketService;
import com.lauren.service.OrderService;
import com.lauren.service.AmountService;
import com.lauren.service.UserService;

@Component
public class FacadeOrderImpl implements FacadeOrder {

	@Autowired
	private BasketService basketService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private AmountService amountService;
	
	@Autowired
	private UserService userService;
	
	public BasketService getBasketService() {
		return basketService;
	}

	public void setBasketService(BasketService basketService) {
		this.basketService = basketService;
	}

	public OrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public AmountService getAmountService() {
		return amountService;
	}

	public void setAmountService(AmountService amountService) {
		this.amountService = amountService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Transactional
	@Override
	public OrderDTO placeOrder(BasketDTO basketDTO) {
		int basketId = basketDTO.getId();
		Basket basket = basketService.getBasketById(basketId);
		User user = userService.getUser(basketDTO.getUser().getUsername());
		if(amountService.updateAmount(basket)) {
			Order order = orderService.placeOrder(basket);
			userService.addUserToOrder(user, order);
			return Utils.convertOrder(order);
		}else {
			return null;
		}
	}
	
	@Override
	public List<OrderDTO> getUserOrders(String username) {
		User user = userService.getUser(username);
		List<OrderDTO> orders = new ArrayList<>();
		if(!CollectionUtils.isEmpty(user.getOrder())) {
			for(Order order:user.getOrder()) {
				orders.add(Utils.convertOrder(order));
			}
		}
		return orders;
	}

}