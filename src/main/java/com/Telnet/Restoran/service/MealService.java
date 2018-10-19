package com.Telnet.Restoran.service;

import java.util.List;

import com.Telnet.Restoran.entity.MealEntity;


public interface MealService {
	public List<MealEntity> getAllMeals();
	
	public MealEntity getMealById(int id);
	
	public void insertMeal(MealEntity meal);
	
	public void updateMeal(MealEntity meal,int id);
	
	public void deleteMeal(int id);
}
