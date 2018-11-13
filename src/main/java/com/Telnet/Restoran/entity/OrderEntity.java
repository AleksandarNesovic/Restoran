package com.Telnet.Restoran.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class OrderEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int order_id;

	@Column(name="quantity")
	private int quantity;
	
	@Column(name="order_price")
	private double order_price;

	@Column(name="order_date")
	private String orderDate;
	
	@Column(name="piece")
	private boolean piece;
	
	@Column(name="display")
	private boolean display;
	
	@Column(name="meal_id",insertable=false,updatable=false)
	private int mealId;
	
	@Column(name="client_id",insertable=false,updatable=false)
	private int clientId;
	
	@ManyToOne
	@JoinColumn(name="meal_id")
	private MealEntity meal;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	private ClientEntity client;

	public OrderEntity() {
		super();
	}

	public OrderEntity(int quantity, double order_price, String order_date, boolean piece, boolean display,
			MealEntity meal, ClientEntity client,int client_id) {
		super();
		this.quantity = quantity;
		this.order_price = order_price;
		this.orderDate = order_date;
		this.piece = piece;
		this.display = display;
		this.clientId=client_id;
		this.meal = meal;
		this.client = client;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getOrder_price() {
		return order_price;
	}

	public void setOrder_price(double order_price) {
		this.order_price = order_price;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String order_date) {
		this.orderDate = order_date;
	}

	public boolean isPiece() {
		return piece;
	}

	public void setPiece(boolean piece) {
		this.piece = piece;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public MealEntity getMeal() {
		return meal;
	}

	public void setMeal(MealEntity meal) {
		this.meal = meal;
	}

	public ClientEntity getClient() {
		return client;
	}

	public void setClient(ClientEntity client) {
		this.client = client;
	}
	
}
