package com.Telnet.Restoran.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Telnet.Restoran.entity.CategoryEntity;
@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer>{
	
	@Transactional
	@Modifying
	@Query(value="UPDATE CategoryEntity c SET c.name=:name,c.link=:link where c.category_id=:category_id")
	public void updateCategory(@Param("category_id") int id,@Param("name") String name,@Param("link") String link);
}
