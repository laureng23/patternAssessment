package com.lauren.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.lauren.dao.BasketDAO;
import com.lauren.model.Basket;
import com.lauren.model.User;

@Transactional
@Repository
public class BasketDAOImpl implements BasketDAO {
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Basket addNewBasket(User user) {
		Basket basket = new Basket();
		basket.setUser(user);
		entityManager.persist(basket);
		return basket;
	}
	@Override
	public Basket getBasketById(int id) {
		return entityManager.find(Basket.class, id);
	}

}
