package com.Telnet.Restoran.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Telnet.Restoran.DAO.OrderDAO;
import com.Telnet.Restoran.entity.OrderEntity;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderDAO orderDAO;
	
	@GetMapping
	public List<OrderEntity> getAllOrders(){
		return orderDAO.getAllOrders();
	}
	@GetMapping("/{id}")
	public OrderEntity getOrderById(@PathVariable int id) {
		return orderDAO.getOrderById(id);
	}
	@PostMapping
	public void insertOrder(@RequestBody OrderEntity order) {
		orderDAO.insertOrder(order);
	}
	@PutMapping("/{id}")
	public void updateOrder(@RequestBody OrderEntity order, @PathVariable int id) {
		orderDAO.updateOrder(order, id);
	}
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable int id) {
		orderDAO.deleteOrder(id);
	}
	@GetMapping("/client/{id}")
	public List<OrderEntity> getOrdersByClient(@PathVariable int id){
		return orderDAO.getOrdersByClient(id);
	}
	@GetMapping("/date/{date}")
	public List<OrderEntity> getOrdersByDate(@PathVariable String date){
		return orderDAO.getOrdersByDate(date);
	}
	@GetMapping("/startDate/{date}")
	public List<OrderEntity> getOrdersByStartDate(@PathVariable String date){
		return orderDAO.getOrdersByStartDate(date);
	}
	@GetMapping("/endDate/{date}")
	public List<OrderEntity> getOrdersByEndDate(@PathVariable String date){
		return orderDAO.getOrdersByEndDate(date);
	}
	@GetMapping("/combination")
	public List<OrderEntity> getOrdersByClientAndDate(@QueryParam("date") String date,@QueryParam("clientId") int clientId){
		return orderDAO.getOrdersByClientAndDate(date, clientId);
	}
//	@GetMapping("/period")
//	public List<OrderEntity> getOrdersByPeriod(@QueryParam("start") String startDate,@QueryParam("end") String endDate){
//		return orderDAO.getOrdersByPeriod(startDate, endDate);
//	}
}