package com.lauren.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Book {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String ISBN;
	private String author;
	private String title;
	private String genre;
	private int amount;
	private double price;
	@OneToMany
    @JoinTable(name="book_review",
        joinColumns = @JoinColumn( name="book_id"),
        inverseJoinColumns = @JoinColumn( name="review_id")
    )
	private Set<Review> review;
	@Lob
	private byte[] bookImage;
	
	public Book() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Set<Review> getReview() {
		return review;
	}
	public void setReview(Set<Review> review) {
		this.review = review;
	}
	public byte[] getBookImage() {
		return bookImage;
	}
	public void setBookImage(byte[] bookImage) {
		this.bookImage = bookImage;
	}
	
	private Book(BookBuilder builder) {
		this.author=builder.author;
		this.title=builder.title;
		this.genre=builder.genre;
		this.amount=builder.amount;
		this.price=builder.price;
		this.bookImage=builder.bookImage;
	}
	
	public static class BookBuilder{
		private String author;
		private String title;
		private String genre;
		private int amount;
		private double price;
		private byte[] bookImage;
		
		public BookBuilder setAuthor(String author) {
			this.author = author;
			return this;
		}
		public BookBuilder setTitle(String title) {
			this.title = title;
			return this;
		}
		public BookBuilder setGenre(String genre) {
			this.genre = genre;
			return this;
		}
		public BookBuilder setAmount(int amount) {
			this.amount = amount;
			return this;
		}
		public BookBuilder setPrice(double price) {
			this.price = price;
			return this;
		}
		public BookBuilder setBookImage(byte[] bookImage) {
			this.bookImage = bookImage;
			return this;
		}
		public Book build() {
			return new Book(this);
		}
		
	}
	
}
