package com.Telnet.Restoran.DAO;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.Telnet.Restoran.entity.MealEntity;
import com.Telnet.Restoran.repositories.MealRepository;
import com.Telnet.Restoran.service.MealService;

@Service
public class MealDAO implements MealService{

	@Autowired
	MealRepository mealRepo;
	
	@Override
	public List<MealEntity> getAllMeals() {
		
		List<MealEntity> allMeals=mealRepo.findAll();
		return allMeals;
	}
	@Override
	public MealEntity getMealById(int id) {
		MealEntity meal=mealRepo.findById(id).get();
		return meal;
	}

	@Override
	public void insertMeal(MealEntity meal) {
		mealRepo.save(meal);		
	}

	@Override
	public void updateMeal(MealEntity meal, int id) {
		mealRepo.updateMeal(id, meal.getName(), meal.getPrice(), meal.getLink(), meal.isPiece(),meal.getCategory());
	}

	@Override
	public void deleteMeal(int id) {
		mealRepo.deleteById(id);
		
	}
	@Override
	public List<MealEntity> findMealsByCategory(int categoryId,int offset){
		List<MealEntity> meals=mealRepo.findMealByCategory(categoryId, offset);
		return meals;
	}

	public Page<MealEntity> getMealsByCategory(int offset, int limit) {
		PageRequest request = new PageRequest(offset , limit);
		Page<MealEntity> meals=mealRepo.findAll(request);
		return meals;
	}

	@Override
	public List<MealEntity> getMealsByCategoryAndRestaurant(int categoryId, int restaurantId,int offset) {
	
		return mealRepo.findAllByCategoryIdAndRestaurantId(categoryId, restaurantId,offset);
	}
}
