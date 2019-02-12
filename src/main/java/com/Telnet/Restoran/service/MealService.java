package com.Telnet.Restoran.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.Telnet.Restoran.DTO.MealDTO;
import com.Telnet.Restoran.entity.MealEntity;


public interface MealService {
	
	public List<MealEntity> getAllMeals();
	
	public MealEntity getMealById(int id);
	
	public void insertMeal(MealEntity meal);
	
	public void updateMeal(MealEntity meal,int id);
	
	public void deleteMeal(int id);
	
	public List<MealEntity> findMealsByCategory(int categoryId, int offset);
	
	public Page<MealEntity> getMealsByCategory(int offset, int limit);
	
	List<MealEntity> getMealsByCategoryAndRestaurant(int categoryId, int restaurantId,int offset);
	
	List<MealDTO> getScrollMeals(int offset);
}
