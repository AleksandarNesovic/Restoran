package com.Telnet.Restoran.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MealEntity {
	
	
	@Id
	@GeneratedValue
	@Column(name="meal_id")
	private int meal_id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="price")
	private double price;
	
	@Column(name="link")
	private String link;
	
	@Column(name="piece")
	private boolean piece;
	
	private int numberOfMeals;
	
	@ManyToOne
	private CategoryEntity category;

	public MealEntity() {
		super();
	}

	public MealEntity(String name, double price, String link, boolean piece, int numberOfMeals,
			CategoryEntity category) {
		super();
		this.name = name;
		this.price = price;
		this.link = link;
		this.piece = piece;
		this.numberOfMeals = numberOfMeals;
		this.category = category;
	}

	public int getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public boolean isPiece() {
		return piece;
	}

	public void setPiece(boolean piece) {
		this.piece = piece;
	}

	public int getNumberOfMeals() {
		return numberOfMeals;
	}

	public void setNumberOfMeals(int numberOfMeals) {
		this.numberOfMeals = numberOfMeals;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	

}
