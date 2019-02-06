package com.Telnet.Restoran.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Telnet.Restoran.entity.RestaurantEntity;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {

	
}
