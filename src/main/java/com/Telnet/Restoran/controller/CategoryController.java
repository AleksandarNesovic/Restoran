package com.Telnet.Restoran.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.Telnet.Restoran.DAO.CategoryDAO;
import com.Telnet.Restoran.entity.CategoryEntity;

@RestController
@RequestMapping(value="/webapi/category")
public class CategoryController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoryEntity>> getAllCategories(){
		
		return new ResponseEntity<List<CategoryEntity>>(categoryDAO.getAllCategories(), HttpStatus.OK);
	
	}
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable int id){
		
		//return categoryDAO.getCategoryById(id);
		return new ResponseEntity<CategoryEntity>(categoryDAO.getCategoryById(id), HttpStatus.OK);
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<String> insertCategory(@RequestBody CategoryEntity cat) {
		
		categoryDAO.insertCategory(cat);
		return new ResponseEntity<String>("Category created",HttpStatus.CREATED);
	
	}
	@RequestMapping(method=RequestMethod.PUT, value="/{id}")
	public ResponseEntity<String> updateCategory(@RequestBody CategoryEntity cat,@PathVariable int id) {
		
		if(categoryDAO.getCategoryById(id)==null) {
			return new ResponseEntity<String>("Category doesn't exist!",HttpStatus.NOT_FOUND);
		}else {
			categoryDAO.updateCategory(cat, id);
			return new ResponseEntity<String>("Category successfully updated",HttpStatus.OK);
		}
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id) {
		
		if(categoryDAO.getCategoryById(id)==null) {
			return new ResponseEntity<String>("Category doesn't exist!",HttpStatus.NOT_FOUND);
		}else {
			categoryDAO.deleteCategory(id);
			return new ResponseEntity<String>("Category successfully deleted",HttpStatus.OK);
		}
	}

}
