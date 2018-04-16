package com.lauren.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.lauren.dao.BookDAO;
import com.lauren.model.Book;


@Transactional
@Repository
public class BookDAOImpl implements BookDAO {

	final String GET_ALL = "SELECT b FROM Book as b ORDER BY b.id";	
	

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Book getBookById(int id) {
		return entityManager.find(Book.class, id);
	}

	@Override
	public void createBook(Book book) {
		entityManager.persist(book);
	}


	@Override
	public List<Book> getAllBook() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> rootEntry = cq.from(Book.class);
        CriteriaQuery<Book> all = cq.select(rootEntry);
        TypedQuery<Book> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

	

	@Override
	public void updateStock(Book book, int updatedStock) {
		book.setAmount(updatedStock);
		entityManager.flush();
	}

}
