package com.sunbeam.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.entities.Order;
import com.sunbeam.entities.OrderStatus;

public interface OrderDao extends JpaRepository<Order, Long> {
	// list all orders delivered after specified date n time
	List<Order> 
	findByOrderStatusAndDeliveryDateTimeGreaterThan
	(OrderStatus orderStatus, LocalDateTime dateTime);

}
