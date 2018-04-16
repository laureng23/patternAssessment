package com.lauren.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	
	@Id
	private String id;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String payment;
	private String address;
	@OneToOne
	private Basket basket;
	 @OneToMany
     @JoinTable(name="user_order",
         joinColumns = @JoinColumn( name="user_id"),
         inverseJoinColumns = @JoinColumn( name="order_id")
     )
	private Set<Order> order;
	
	public User() {
		
	}
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Basket getBasket() {
		return basket;
	}
	
	public void setBasket(Basket basket) {
		this.basket = basket;
	}
	
	public Set<Order> getOrder() {
		return order;
	}
	
	public void setOrder(Set<Order> order) {
		this.order = order;
	}
	
	public String getPaymentd() {
		return payment;
	}
	
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
}
