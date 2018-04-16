package com.lauren;

import java.util.ArrayList;
import java.util.List;
import org.springframework.util.CollectionUtils;

import com.lauren.dto.BookDTO;
import com.lauren.dto.BasketDTO;
import com.lauren.dto.ReviewDTO;
import com.lauren.dto.InfoDTO;
import com.lauren.dto.OrderDTO;
import com.lauren.dto.UserDTO;
import com.lauren.model.Book;
import com.lauren.model.Basket;
import com.lauren.model.Review;
import com.lauren.model.Info;
import com.lauren.model.Order;
import com.lauren.model.User;

public class Utils {

	public static BookDTO convertBookDTO(Book book) {
		BookDTO dto = new BookDTO();
		dto.setId(book.getId());
		dto.setAuthor(book.getAuthor());
		dto.setTitle(book.getTitle());
		dto.setGenre(book.getGenre());
		dto.setPrice(book.getPrice());
		dto.setAmount(book.getAmount());
		dto.setImage(book.getBookImage());
		List<ReviewDTO> reviews = new ArrayList<ReviewDTO>();
		for(Review review:book.getReview()) {
			reviews.add(convertReview(review));
		}
		dto.setReview(reviews);
		if(CollectionUtils.isEmpty(reviews)) {
			dto.setRating(0);
		}else {
			int total = 0;
			for(Review review:book.getReview()) {
				total = total + review.getRating();
			}
			float rating = (float) total/book.getReview().size();
			dto.setRating(rating);
		}
		return dto;
	}
	
	public static InfoDTO convertInfoDTO(Info info) {
		InfoDTO dto = new InfoDTO();
		dto.setBook(convertBookDTO(info.getBook()));
		dto.setId(info.getId());
		dto.setQuantity(info.getQuantity());
		dto.setPrice(info.getQuantity()*info.getBook().getPrice());
		return dto;
	}
	
	
	public static UserDTO convertUserDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setUsername(user.getId());
		dto.setPayment(user.getPaymentd());
		dto.setAddress(user.getAddress());
		return dto;
	}
	
	public static OrderDTO convertOrder(Order order) {
		OrderDTO dto = new OrderDTO();
		dto.setId(order.getId());
		dto.setUser(convertUserDTO(order.getUser()));
		dto.setTotalPrice(order.getTotalPrice());
		List<InfoDTO> i = new ArrayList<InfoDTO>();
		for(Info info:order.getInfo()) {
			i.add(convertInfoDTO(info));
		}
		dto.setInfo(i);
		return dto;
	}
	
	public static BasketDTO convertBasket(Basket basket) {
		BasketDTO dto = new BasketDTO();
		dto.setId(basket.getId());
		dto.setUser(convertUserDTO(basket.getUser()));
		dto.setTotalPrice(basket.getTotalPrice());
		List<InfoDTO> i = new ArrayList<InfoDTO>();
		for(Info info:basket.getInfo()) {
			i.add(convertInfoDTO(info));
		}
		dto.setInfo(i);
		return dto;
	}
	
	
	
	public static ReviewDTO convertReview(Review review) {
		ReviewDTO dto = new ReviewDTO();
		dto.setReview(review.getReview());
		dto.setId(review.getId());
		dto.setRating(review.getRating());
		dto.setUsername(review.getUsername());
		return dto;
	}
	
}
