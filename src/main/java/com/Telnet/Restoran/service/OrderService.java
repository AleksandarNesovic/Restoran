package com.Telnet.Restoran.service;

import java.util.List;

import com.Telnet.Restoran.entity.OrderEntity;

public interface OrderService {

	public List<OrderEntity> getAllOrders();
	
	public OrderEntity getOrderById(int id);
	
	public void insertOrder(OrderEntity order);
	
	public void updateOrder(OrderEntity order,int id);
	
	public void deleteOrder(int id);
	
	public List<OrderEntity> getOrdersByClient(int id);
	
	public List<OrderEntity> getOrdersByDate(String date);
	
	public List<OrderEntity> getOrdersByStartDate(String date);
	
	public List<OrderEntity> getOrdersByEndDate(String date);
	
	public List<OrderEntity> getOrdersByClientAndDate(String date,int clientId);
	
	//public List<OrderEntity> getOrdersByPeriod(String startDate,String endDate);
}
