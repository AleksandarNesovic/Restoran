package com.Telnet.Restoran.DTO;

import com.Telnet.Restoran.entity.OrderEntity;

public class OrderDTO {

	private int order_id;
	
	private int quantity;
	
	private double order_price;
	
	private String orderDate;
	
	private boolean piece;
	
	private boolean display;
	
	private int mealId;
	
	private int clientId;
	
	private MealDTO meal;
	
	private ClientDTO client;

	public OrderDTO() {
		super();
	}

	public OrderDTO(OrderEntity order) {
		super();
		this.order_id = order.getOrder_id();
		this.quantity = order.getQuantity();
		this.order_price = order.getOrder_price();
		this.orderDate = order.getOrderDate();
		this.piece = order.isPiece();
		this.display = order.isDisplay();
		this.meal = new MealDTO(order.getMeal());
		this.client = new ClientDTO(order.getClient());
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

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
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

	public int getMealId() {
		return mealId;
	}

	public void setMealId(int mealId) {
		this.mealId = mealId;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public MealDTO getMeal() {
		return meal;
	}

	public void setMeal(MealDTO meal) {
		this.meal = meal;
	}

	public ClientDTO getClient() {
		return client;
	}

	public void setClient(ClientDTO client) {
		this.client = client;
	}
	
	
}
