package com.Telnet.Restoran.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Telnet.Restoran.entity.RestaurantEntity;
import com.Telnet.Restoran.repositories.RestaurantRepository;
import com.Telnet.Restoran.service.RestaurantService;

@Service
public class RestaurauntDAO implements RestaurantService{
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public List<RestaurantEntity> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public RestaurantEntity getRestaurantById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRestaurant(RestaurantEntity restaurant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRestaurant(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRestaurant(RestaurantEntity restaurant) {
		// TODO Auto-generated method stub
		
	}
	
	

}
