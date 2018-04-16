package com.lauren.dto;
import com.lauren.dto.BookDTO;

public class InfoDTO {

	private int id;
	private int quantity;
	private double price;
	private BookDTO book;
	
	public InfoDTO() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public BookDTO getBook() {
		return book;
	}

	public void setBook(BookDTO book) {
		this.book = book;
	}
	
	
}
