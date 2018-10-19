package com.Telnet.Restoran.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Telnet.Restoran.entity.CategoryEntity;
import com.Telnet.Restoran.entity.MealEntity;

@Repository
public interface MealRepository extends JpaRepository<MealEntity, Integer>{

	
	@Transactional
	@Modifying
	@Query(value="UPDATE MealEntity m SET m.name=:name, m.price=:price, m.link=:link, m.piece=:piece,m.category=category WHERE m.meal_id=:meal_id")
	public void updateMeal(@Param("meal_id") int id,@Param("name") String name,@Param("price") double price,@Param("link") String link,@Param("piece") boolean piece,@Param("category") CategoryEntity category);
		
}
