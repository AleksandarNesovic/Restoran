package com.Telnet.Restoran.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Telnet.Restoran.DAO.ClientDAO;
import com.Telnet.Restoran.DTO.OrderDTO;
import com.Telnet.Restoran.entity.ClientEntity;
import com.Telnet.Restoran.entity.OrderEntity;
import com.Telnet.Restoran.security.JwtTokenProvider;
import com.Telnet.Restoran.service.OrderService;

@RestController
@RequestMapping("/webapi/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	 @Autowired
	 private JwtTokenProvider tokenProvider;
	
	 @Autowired
	 ClientDAO clientDAO;
	 
	@GetMapping
	public List<OrderEntity> getAllOrders(){
		return orderService.getAllOrders();
	}
	@GetMapping("/{id}")
	public OrderEntity getOrderById(@PathVariable int id) {
		return orderService.getOrderById(id);
	}
	@PostMapping("/list")
	public void insertOrder(@RequestBody List<OrderEntity> order,HttpServletRequest request) {
		String datum = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
		
		 String jwt = getJwtFromRequest(request);
		 int userId = tokenProvider.getUserIdFromJWT(jwt);
		 ClientEntity client=clientDAO.getClientById(userId);

		for (OrderEntity orderEntity : order) {
			orderEntity.setOrderDate(datum);
			orderEntity.setClient(client);
			orderService.insertOrder(orderEntity);
		}
		
	}
	@PutMapping("/{id}")
	public void updateOrder(@RequestBody OrderEntity order, @PathVariable int id) {
		orderService.updateOrder(order, id);
	}
	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable int id) {
		orderService.deleteOrder(id);
	}
	@GetMapping("/client/{id}")
	public List<OrderEntity> getOrdersByClient(@PathVariable int id,@QueryParam("offset") int offset){
		return orderService.getOrdersByClient(id,offset);
	}
	@GetMapping("singleDate/{date}")
	public List<OrderEntity> getOrdersByDate(@PathVariable String date){
		return orderService.getOrdersByDate(date);
	}
	@GetMapping("date/{date}")
	public List<OrderEntity> getOrdersByDateScroll(@PathVariable String date, @QueryParam("offset") int offset){
		return orderService.getOrdersByDateScroll(date, offset);
	}
	@GetMapping("/startDate/{date}")
	public List<OrderEntity> getOrdersByStartDate(@PathVariable String date){
		return orderService.getOrdersByStartDate(date);
	}
	@GetMapping("/endDate/{date}")
	public List<OrderEntity> getOrdersByEndDate(@PathVariable String date){
		return orderService.getOrdersByEndDate(date);
	}
	@GetMapping("/combination")
	public List<OrderEntity> getOrdersCombination(@QueryParam("date") String date,@QueryParam("clientId") int clientId){
		return orderService.getOrdersCombination(date, clientId);
	}
	@GetMapping("/clientAndDate")
	public List<OrderEntity> getOrdersByClientsAndDate(@QueryParam("date") String date,@QueryParam("client_id") String client_id,@QueryParam("offset") int offset){
		String[] items=client_id.split(",");
		int[] id=new int[items.length];
		for (int i = 0; i < items.length; i++) {
			id[i]=Integer.parseInt(items[i]);
		}
		return orderService.getOrdersByClientAndDate(date,id,offset);
	}
	
	
	@GetMapping("/clients")
	public ResponseEntity<List<OrderDTO>> getOrdersByClients(@QueryParam("id") String id,@QueryParam("offset") int offset){
		
		String[] items=id.split(",");
		int[] ids=new int[items.length];
		for (int i = 0; i < items.length; i++) {
			ids[i]=Integer.parseInt(items[i]);
		}
		return new ResponseEntity<List<OrderDTO>>(orderService.getOrdersByClients(ids, offset),HttpStatus.OK);
	}
//	@GetMapping("/period")
//	public List<OrderEntity> getOrdersByPeriod(@QueryParam("start") String startDate,@QueryParam("end") String endDate){
//		return orderDAO.getOrdersByPeriod(startDate, endDate);
//	}
	
	private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }
}
