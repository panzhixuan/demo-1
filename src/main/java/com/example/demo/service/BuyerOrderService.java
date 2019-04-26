package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.Order;

@Service
public class BuyerOrderService {
	@Autowired
	OrderMapper orderMapper;
	
	public List<Order> findAllByBuyerId(int userId){
		return orderMapper.findAllByBuyerId(userId);
	}
	
	public void setBOrderFlag(int bookId) {
		orderMapper.setOrderFlag(bookId,1);
	}
	
	public void setOrderFlag(int bookId) {
		orderMapper.setOrderFlag(bookId,2);
	}
	
	public void deleteBOrder(int orderId) {
		orderMapper.deleteOrder(orderId);
	}
}
