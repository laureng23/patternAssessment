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

import com.lauren.dao.UserDAO;
import com.lauren.model.User;

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
	public void newUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public User updateUser(String username, String address, String payment) {
		User user = this.getUserById(username);
		user.setAddress(address);
		user.setPayment(payment);
		entityManager.flush();
		return user;
	}

	@Override
	public List<User> getAllUser() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        Root<User> rootEntry = cq.from(User.class);
        CriteriaQuery<User> all = cq.select(rootEntry);
        TypedQuery<User> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

}
