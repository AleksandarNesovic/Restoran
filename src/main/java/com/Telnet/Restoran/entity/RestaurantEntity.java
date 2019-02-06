package com.Telnet.Restoran.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.Telnet.Restoran.DTO.RestaurantDTO;

@Entity
@Table(name="restaurant")
public class RestaurantEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="contact")
	private String contact;
	
	public RestaurantEntity() {
		super();
	}

	public RestaurantEntity(RestaurantDTO restaurant) {
		super();
		this.id = restaurant.getId();
		this.name = restaurant.getName();
		this.address = restaurant.getAddress();
		this.contact = restaurant.getContact();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	

}
