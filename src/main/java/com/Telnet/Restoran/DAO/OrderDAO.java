package com.Telnet.Restoran.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Telnet.Restoran.entity.OrderEntity;
import com.Telnet.Restoran.repositories.OrderRepository;
import com.Telnet.Restoran.service.OrderService;

@Service
public class OrderDAO implements OrderService{

	@Autowired
	OrderRepository orderRepo;

	@Override
	public List<OrderEntity> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public OrderEntity getOrderById(int id) {
		return orderRepo.findById(id).get();
	}

	@Override
	public void insertOrder(OrderEntity order) {
		orderRepo.save(order);		
	}

	@Override
	public void updateOrder(OrderEntity order, int id) {
		orderRepo.updateOrder(id, order.getQuantity(), order.getOrder_price(), order.getOrderDate(), order.isPiece(), order.isDisplay(), order.getMeal(), order.getClient());
	}

	@Override
	public void deleteOrder(int id) {
		orderRepo.deleteById(id);		
	}
	
	@Override
	public List<OrderEntity> getOrdersByClient(int id,int offset) {
		return orderRepo.findByClientId(id,offset);
	}
	@Override
	public List<OrderEntity> getOrdersByDate(String date) {
		return orderRepo.findByOrderDate(date);
	}

	@Override
	public List<OrderEntity> getOrdersByStartDate(String date) {
		return orderRepo.getOrdersByStartDate(date);
	}

	@Override
	public List<OrderEntity> getOrdersByEndDate(String date) {
		return orderRepo.getOrdersByEndDate(date);
	}

	@Override
	public List<OrderEntity> getOrdersByClientAndDate(String date, int clientId) {
		return orderRepo.getOrdersByClientAndDate(date, clientId);
	}

	@Override
	public List<OrderEntity> getOrdersByDateScroll(String orderDate, int offset) {
		return orderRepo.getOrdersByDateScroll(orderDate, offset);
	}

//	@Override
//	public List<OrderEntity> getOrdersByPeriod(String startDate, String endDate) {
//		return orderRepo.getOrdersByPeriod(startDate, endDate);
//	}
}
