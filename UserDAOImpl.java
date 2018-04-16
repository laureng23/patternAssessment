package com.lauren.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.lauren.model.Order;
import com.lauren.model.User;
import com.lauren.dao.UserDAO;


@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public User getUserById(String id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public User updateUser(String username, String address, String paymentd) {
		User user = this.getUserById(username);
		user.setAddress(address);
		user.setPayment(paymentd);
		entityManager.flush();
		return user;
	}

	@Override
	public void addUserOrder(User user,Order order) {
		Set<Order> orders = user.getOrder();
		if(orders!=null) {
			user.getOrder().add(order);		
		}else {
			Set<Order> newOrder = new HashSet<>();
			newOrder.add(order);
			user.setOrder(newOrder);
		}
		entityManager.flush();	
	}

	@Override
	public List<User> getAllUsers() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        TypedQuery<User> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

}
