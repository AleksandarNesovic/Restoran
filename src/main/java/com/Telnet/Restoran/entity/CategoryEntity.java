package com.Telnet.Restoran.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="category")
public class CategoryEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="category_id")
	private int category_id;
	
	@NotNull
	@Column(name="name")
	private String name;
	
	@Column(name="link")
	private String link;
	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL, targetEntity=MealEntity.class)
	private List<MealEntity> meal=new ArrayList<>();
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
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
