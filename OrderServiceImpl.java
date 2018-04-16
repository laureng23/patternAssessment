package com.lauren.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lauren.dao.OrderDAO;
import com.lauren.model.Basket;
import com.lauren.model.Info;
import com.lauren.model.Order;
import com.lauren.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDao;
	
	@Override
	public Order placeOrder(Basket basket) {
		Order order = new Order();
		order.setUser(basket.getUser());
		order.setTotalPrice(basket.getTotalPrice());
		Set<Info> i = new HashSet<>(basket.getInfo());
		order.setInfo(i);	
		return orderDao.addNewOrder(order);
	}

	public OrderDAO getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}
	
	

}
