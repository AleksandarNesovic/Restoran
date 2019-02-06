package com.Telnet.Restoran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Telnet.Restoran.entity.RestaurantEntity;
import com.Telnet.Restoran.service.RestaurantService;

@RestController
@RequestMapping(value="/webapi/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping
	public ResponseEntity<List<RestaurantEntity>> getAllRestaurant(){
		 
		return new ResponseEntity<List<RestaurantEntity>>(restaurantService.getAllRestaurants(),HttpStatus.OK);
	}
}
