package com.lauren.service;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lauren.dao.BasketDAO;
import com.lauren.model.Basket;
import com.lauren.model.Info;
import com.lauren.model.User;
import com.lauren.service.BasketService;

@Service
public class BasketServiceImpl implements BasketService {
	
	@Autowired
	private BasketDAO basketDao;
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Basket createNewBasket(User user) {
		return basketDao.addNewBasket(user);
	}

	@Transactional
	@Override
	public Basket addToBasket(Basket basket,Info info) {
		if(basket.getInfo()!=null) {
			basket.getInfo().add(info);
		}else {
			Set<Info> i = new HashSet<Info>();
			i.add(info);
			basket.setInfo(i);
		}		
		entityManager.flush();
		calculateBasket(basket);
		return basket;
	}

	@Transactional
	@Override
	public void calculateBasket(Basket basket) {
		double totalPrice = 0.0;
		for(Info info:basket.getInfo()) {
			double entryTotal = info.getBook().getPrice() * info.getQuantity();
			totalPrice = totalPrice + entryTotal;
		}
		basket.setTotalPrice(totalPrice);
		entityManager.flush();
	}
	
	@Override
	public Basket getBasketById(int id) {
		return basketDao.getBasketById(id);
	}

	public BasketDAO getBasketDao() {
		return basketDao;
	}

	public void setBasketDAO(BasketDAO basketDao) {
		this.basketDao = basketDao;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



}
