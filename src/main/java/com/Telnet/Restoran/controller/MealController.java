package com.Telnet.Restoran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Telnet.Restoran.DAO.MealDAO;
import com.Telnet.Restoran.entity.MealEntity;

@RestController
@RequestMapping("/meals")
public class MealController {
	
	@Autowired
	MealDAO mealDAO;
	
	@GetMapping
	public List<MealEntity> getAllMeals(){
		return mealDAO.getAllMeals();
	}
	@GetMapping("/{id}")
	public MealEntity getMealById(@PathVariable int id) {
		return mealDAO.getMealById(id);
	}
	@PostMapping
	public void insertMeal(@RequestBody MealEntity meal) {
		mealDAO.insertMeal(meal);
	}
	@PutMapping("/{id}")
	public void updateMeal(@RequestBody MealEntity meal,@PathVariable int id) {
		mealDAO.updateMeal(meal, id);
	}
	@DeleteMapping("/{id}")
	public void deleteMeal(@PathVariable int id) {
		mealDAO.deleteMeal(id);
	}

}
