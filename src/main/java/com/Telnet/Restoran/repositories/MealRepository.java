package com.Telnet.Restoran.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
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
	@Query(value="UPDATE MealEntity m SET m.name=:name, m.price=:price, m.link=:link, m.piece=:piece,m.category=:category WHERE m.meal_id=:meal_id")
	public void updateMeal(@Param("meal_id") int id,@Param("name") String name,@Param("price") double price,@Param("link") String link,@Param("piece") boolean piece,@Param("category") CategoryEntity category);
	
	@Transactional
	@Modifying
	@Query(value="Select m.meal_id, m.name, m.price, m.link, m.piece, m.category_id from meals m where m.category_id=?1 offset ?2 ROWS FETCH NEXT 5 ROWS ONLY",nativeQuery = true)
	public List<MealEntity> findMealByCategory(int categoryId,int offset);
	
	public List<MealEntity> findByCategoryId(int categoryId,Pageable pageable);
	
	@Transactional
	@Modifying
	@Query(value="Select m.meal_id, m.name, m.price, m.link, m.piece, m.category_id, m.restaurant_id from meals m where m.category_id=?1 AND m.restaurant_id=?2 offset ?3 ROWS FETCH NEXT 5 ROWS ONLY",nativeQuery = true)
	List<MealEntity> findAllByCategoryIdAndRestaurantId(int categoryId, int restaurantId,int offset);
	
	@Transactional
	@Modifying
	@Query(value="select m.meal_id, m.name, m.price, m.link, m.piece, c.category_id, c.link as categoryLink, c.name as categoryName from meals m join category c on m.category_id=c.category_id OFFSET ?1 ROWS FETCH NEXT 10 ROWS ONLY",nativeQuery = true)
	List<MealEntity> findAllMeals(int offset);
	
	@Query(value="Select count(*) from meals",nativeQuery=true)
	int MealsCount();
	
	
}
