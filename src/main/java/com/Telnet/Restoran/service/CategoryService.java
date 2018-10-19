package com.Telnet.Restoran.service;

import java.util.List;

import com.Telnet.Restoran.DTO.CategoryDTO;
import com.Telnet.Restoran.entity.CategoryEntity;

public interface CategoryService {
	public List<CategoryEntity> getAllCategories();
	
	public CategoryEntity getCategoryById(int id);
	
	public void insertCategory(CategoryEntity cat);
	 
	public void updateCategory(CategoryEntity cat,int id);
	
	public void deleteCategory(int id);
	
}
