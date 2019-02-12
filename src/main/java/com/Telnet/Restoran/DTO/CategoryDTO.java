package com.Telnet.Restoran.DTO;

import com.Telnet.Restoran.entity.CategoryEntity;

public class CategoryDTO {
	
	private long category_id;
	private String name;
	private String link;
	public CategoryDTO() {
		super();
	}
	public CategoryDTO(CategoryEntity category) {
		super();
		this.category_id=category.getCategory_id();
		this.name = category.getName();
		this.link = category.getLink();
	}
	public long getCategory_id() {
		return category_id;
	}
	public void setCategory_id(long category_id) {
		this.category_id = category_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", name=" + name + ", link=" + link + "]";
	}
	

}
