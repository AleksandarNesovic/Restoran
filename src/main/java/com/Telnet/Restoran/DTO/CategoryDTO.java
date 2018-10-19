package com.Telnet.Restoran.DTO;

public class CategoryDTO {
	
	private long category_id;
	private String name;
	private String link;
	public CategoryDTO() {
		super();
	}
	public CategoryDTO(String name, String link) {
		super();
		this.name = name;
		this.link = link;
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
