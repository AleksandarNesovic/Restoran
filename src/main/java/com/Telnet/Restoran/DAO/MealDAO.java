package com.Telnet.Restoran.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

}
