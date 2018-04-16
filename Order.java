package com.lauren.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Order {


	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	 @OneToMany
     @JoinTable(name="order_info",
         joinColumns = @JoinColumn( name="order_id"),
         inverseJoinColumns = @JoinColumn( name="info_id")
     )
	private Set<Info> info;
	private double totalPrice;
	@ManyToOne
	private User user;
	
	public Order() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Set<Info> getInfo() {
		return info;
	}
	public void setInfo(Set<Info> info) {
		this.info = info;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
