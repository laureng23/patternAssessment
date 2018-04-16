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
import org.springframework.util.CollectionUtils;
import com.lauren.dao.BookDAO;
import com.lauren.model.Review;
import com.lauren.model.Book;


@Transactional
@Repository
public class BookDAOImpl implements BookDAO {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Book getBookById(int id) {
		return entityManager.find(Book.class, id);
	}

	@Override
	public void addBook(Book book) {
		entityManager.persist(book);
	}

	@Override
	public void updateAmount(Book book,int amount) {
		int currentAmount = book.getAmount();
		int newAmount = currentAmount-amount;
		book.setAmount(newAmount);
		entityManager.flush();
	}

	@Override
	public List<Book> getAllBooks() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        Root<Book> rootEntry = cq.from(Book.class);
        CriteriaQuery<Book> all = cq.select(rootEntry);
        TypedQuery<Book> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
	}

	

	@Override
	public Review addNewReview(Book book,int rating, String username, String review) {
		Review newReview = new Review();
		newReview.setReview(review);
		newReview.setRating(rating);
		newReview.setUsername(username);
		newReview.setBook(book);
		entityManager.persist(newReview);
		return newReview;
	}

	@Override
	public void addReview(Book book, Review review) {
		if(CollectionUtils.isEmpty(book.getReview())) {
			Set<Review> reviews = new HashSet<>();
			reviews.add(review);
			book.setReview(reviews);
		}else {
			book.getReview().add(review);
		}
		entityManager.flush();
	}

	@Override
	public void updateReview(Review r, int rating, String review) {
		r.setId(rating);
		r.setReview(review);
		entityManager.flush();
	}


	@Override
	public void updatedAmount(Book book, int newAmount) {
		book.setAmount(newAmount);
		entityManager.flush();
	}

}
