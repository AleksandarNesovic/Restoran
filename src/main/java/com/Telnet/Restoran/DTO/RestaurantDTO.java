package com.Telnet.Restoran.DTO;

import com.Telnet.Restoran.entity.RestaurantEntity;

public class RestaurantDTO {

	private int id;
	
	private String name;
	
	private String address;
	
	private String contact;

	public RestaurantDTO() {
		super();
	}
	

	public RestaurantDTO(RestaurantEntity restaurant) {
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
