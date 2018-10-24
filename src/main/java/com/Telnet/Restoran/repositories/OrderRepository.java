package com.Telnet.Restoran.repositories;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Telnet.Restoran.entity.ClientEntity;
import com.Telnet.Restoran.entity.MealEntity;
import com.Telnet.Restoran.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{

	@Transactional
	@Modifying
	@Query(value="UPDATE OrderEntity o SET o.quantity=:quantity, o.order_price=:order_price, o.orderDate=:orderDate, o.piece=:piece,o.display=:display,o.client=:client, o.meal=:meal WHERE o.order_id=:order_id")
	public void updateOrder(@Param("order_id") int order_id,@Param("quantity") int quantity,@Param("order_price") double order_price, @Param("orderDate") String orderDate,@Param("piece") boolean piece,@Param("display") boolean display,@Param("meal") MealEntity meal,@Param("client") ClientEntity client);
	
	public List<OrderEntity> findByClientId(int clientId);
	
	public List<OrderEntity> findByOrderDate(String orderDate);
	
	@Query(value="FROM OrderEntity WHERE orderDate>=:orderDate")
	public List<OrderEntity> getOrdersByStartDate(@Param("orderDate") String orderDate);
	
	@Query(value="FROM OrderEntity WHERE orderDate<=:orderDate")
	public List<OrderEntity> getOrdersByEndDate(@Param("orderDate") String orderDate);
	
	@Query(value="FROM OrderEntity WHERE orderDate=:orderDate AND clientId=:clientId")
	public List<OrderEntity> getOrdersByClientAndDate(@Param("orderDate") String orderDate,@Param("clientId") int clientId);
	
//	@Query(value="FROM OrderEntity WHERE orderDate BETWEEN :orderDate and :orderDate")
//	public List<OrderEntity> getOrdersByPeriod(@Param("orderDate") String startDate,@Param("orderDate") String endDate);
}
