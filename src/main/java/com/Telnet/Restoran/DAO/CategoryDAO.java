package com.Telnet.Restoran.DAO;


import java.util.List;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Telnet.Restoran.entity.CategoryEntity;
import com.Telnet.Restoran.repositories.CategoryRepository;
import com.Telnet.Restoran.service.CategoryService;

@Service
public class CategoryDAO implements CategoryService{

	@Autowired
	CategoryRepository repo;
	
	@PostConstruct
	private void init() {
		
	}
	
	@Override
	public List<CategoryEntity> getAllCategories() {
		List<CategoryEntity> categories=repo.findAll();
//		for (CategoryEntity category : categories) {
//			CategoryDTO cat=new CategoryDTO();
//			BeanUtils.copyProperties(category, cat);
//			list.add(cat);
//		}
		return categories;
	}

	@Override
	public CategoryEntity getCategoryById(int id) throws NoSuchElementException {
		
			Optional<CategoryEntity> category = repo.findById(id);
//			CategoryDTO cat=new CategoryDTO();
//			BeanUtils.copyProperties(category.get(), cat);
			return category.get();
	}

	@Override
	public void insertCategory(CategoryEntity cat) {
//		CategoryEntity entity=new CategoryEntity();
//		BeanUtils.copyProperties(cat, entity);
		repo.save(cat);
		
	}

	@Override
	public void updateCategory(CategoryEntity cat,int id) {
//		CategoryEntity entity=new CategoryEntity();
//		BeanUtils.copyProperties(cat, entity);
//		entity.setCategory_id(id);
		repo.updateCategory(id, cat.getName(), cat.getLink());
	}

	@Override
	public void deleteCategory(int id) {
		repo.deleteById(id);
	}


}
