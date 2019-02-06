package com.Telnet.Restoran.service;

import java.util.List;

import com.Telnet.Restoran.entity.RestaurantEntity;

public interface RestaurantService {

	List<RestaurantEntity> getAllRestaurants();

	RestaurantEntity getRestaurantById(int id);

	void saveRestaurant(RestaurantEntity restaurant);

	void deleteRestaurant(int id);

	void updateRestaurant(RestaurantEntity restaurant);

}
