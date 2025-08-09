package com.sunbeam.service;

import java.util.List;

import org.springframework.data.domain.jaxb.SpringDataJaxb.OrderDto;

import com.sunbeam.dto.ApiResponse;
import com.sunbeam.dto.OrderResponse;
import com.sunbeam.dto.PlaceOrderDTO;

public interface OrderService {

	OrderResponse placeOrder(PlaceOrderDTO dto);

	ApiResponse cancelOrder(Long orderId);
	
	List<OrderDto> findAllDeliveredOrdersWithinSpecifiedTime(int hours);

}
