package com.sunbeam.controller;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.PlaceOrderDTO;
import com.sunbeam.service.OrderService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {
	private final OrderService orderService;
	/*
	 * Desc - Place Order 
	 * URL - http://host:port/orders
	 * Method - POST
	 * Payload - OrderRequestDTO
	 *    - customer id , restaurant id , 
	 *    array of - food item id n quantity
	 * Resp -  ApiResp - success SC OK - order placed with id
	 *  failure -ApiResp-  err mesg -
	 */
	@PostMapping
	public ResponseEntity<?> placeFoodOrder
	(@RequestBody PlaceOrderDTO dto)
	{
		System.out.println("place order "+dto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(orderService.placeOrder(dto));
	}
	
	@DeleteMapping("/{orderId}")
	@PreAuthorize("hasRole('CUSTOMER')")
	public ResponseEntity<?> cancelFoodOrder
	(@PathVariable Long orderId)
	{
		System.out.println("cancel order "+orderId);
		return ResponseEntity.ok(orderService.cancelOrder(orderId));
			
	}
	/*
	 * Desc - Get all delivered orders within last hour 
	 * URL - http://host:port/orders/delivered/{hours}
	 * Method - GET
	 * Payload - none
	 * Resp -  ApiResp - success SC OK - list of order dtos
	 *  empty list - SC 204
	 */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/delivered/{hours}")
	public ResponseEntity<?> getDeliveredOrders(@PathVariable int hours)
	{
		System.out.println("in get delivered orders "+hours);
		List<OrderDto> list = orderService.findAllDeliveredOrdersWithinSpecifiedTime(hours);
		if(list.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(list);
	}

}
