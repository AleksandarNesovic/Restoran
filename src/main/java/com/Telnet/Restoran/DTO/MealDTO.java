package com.Telnet.Restoran.DTO;

import com.Telnet.Restoran.entity.CategoryEntity;
import com.Telnet.Restoran.entity.MealEntity;
import com.Telnet.Restoran.entity.RestaurantEntity;

public class MealDTO {
	
	private int meal_id;
	
	private String name;
	
	private double price;
	
	private String link;
	
	private boolean piece;
	
	private int categoryId;
	
	private int restaurantId;	
	
	private CategoryDTO category;
	
	private RestaurantDTO restaurant;
	
	private int numberOfMeals;

	public MealDTO() {
		super();
	}

	public MealDTO(MealEntity meal) {
		super();
		this.meal_id = meal.getMeal_id();
		this.name = meal.getName();
		this.price = meal.getPrice();
		this.link = meal.getLink();
		this.piece = meal.isPiece();
		this.categoryId = meal.getCategoryId();
		this.restaurantId = meal.getRestaurantId();
	}
	
	public MealDTO(MealEntity meal,CategoryEntity category, RestaurantEntity restaurant,int numberOfMeals) {
		super();
		this.meal_id = meal.getMeal_id();
		this.name = meal.getName();
		this.price = meal.getPrice();
		this.link = meal.getLink();
		this.piece = meal.isPiece();
		this.categoryId = meal.getCategoryId();
		this.restaurantId = meal.getRestaurantId();
		this.category=new CategoryDTO(category);
		this.restaurant=new RestaurantDTO(restaurant);
		this.numberOfMeals=numberOfMeals;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public RestaurantDTO getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(RestaurantDTO restaurant) {
		this.restaurant = restaurant;
	}

	public int getNumberOfMeals() {
		return numberOfMeals;
	}

	public void setNumberOfMeals(int numberOfMeals) {
		this.numberOfMeals = numberOfMeals;
	}
	
	
	
}
