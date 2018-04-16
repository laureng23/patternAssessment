package com.lauren.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.lauren.model.Info;
import com.lauren.dao.InfoDAO;

@Transactional
@Repository
public class InfoDAOImpl implements InfoDAO {

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public Info addNewInfo(Info info) {
		entityManager.persist(info);
		return info;
	}
	@Override
	public void updateInfo(Info info) {
		Info in= getInfoById(info.getId());
		in.setQuantity(info.getQuantity());
		entityManager.flush();
	}
	@Override
	public Info getInfoById(int id) {
		return entityManager.find(Info.class, id);
	}

}
