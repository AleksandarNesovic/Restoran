package com.Telnet.Restoran.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Telnet.Restoran.DTO.MealDTO;
import com.Telnet.Restoran.entity.MealEntity;
import com.Telnet.Restoran.service.MealService;

@RestController
@RequestMapping("webapi/meal")
public class MealController {
	
	@Autowired
	MealService mealService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<MealEntity> getAllMeals(){
		return mealService.getAllMeals();
	}
	@GetMapping("/{id}")
	public MealEntity getMealById(@PathVariable int id) {
		return mealService.getMealById(id);
	}
	@GetMapping("/category/{categoryId}/scroll")
	public List<MealEntity> getMealsByCategory(@PathVariable int categoryId,@QueryParam("offset") int offset){
		return mealService.findMealsByCategory(categoryId, offset);
	}
	@GetMapping("category/scroll")
	public Page<MealEntity> getAllMealsByCategory(@QueryParam("offset") int offset){
		return mealService.getMealsByCategory(offset, 10);
	}
	@PostMapping
	public void insertMeal(@RequestBody MealEntity meal) {
		mealService.insertMeal(meal);
	}
	@PutMapping("/{id}")
	public void updateMeal(@RequestBody MealEntity meal,@PathVariable int id) {
		mealService.updateMeal(meal, id);
	}
	@DeleteMapping("/{id}")
	public void deleteMeal(@PathVariable int id) {
		mealService.deleteMeal(id);
	}
	
	@GetMapping("/restaurant/{restaurantId}/category/{categoryId}")
	public ResponseEntity<List<MealEntity>> getAllMealsByRestaurantAndCategory(@PathVariable int restaurantId, @PathVariable int categoryId,@QueryParam("offset") int offset){
		
		return new ResponseEntity<List<MealEntity>>(mealService.getMealsByCategoryAndRestaurant(categoryId, restaurantId,offset),HttpStatus.OK);
	}

	@GetMapping("/scroll")
	public ResponseEntity<List<MealDTO>> getScrollMeal(@QueryParam("offset") int offset){
		
		return new ResponseEntity<List<MealDTO>>(mealService.getScrollMeals(offset),HttpStatus.OK);
	
	}
}
