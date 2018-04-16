package com.lauren.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.lauren.model.Order;
import com.lauren.dao.OrderDAO;

@Transactional
@Repository
public class OrderDAOImpl implements OrderDAO {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Order addNewOrder(Order order) {
		entityManager.persist(order);
		return order;
	}

}
