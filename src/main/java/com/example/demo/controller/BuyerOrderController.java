package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.service.BuyerOrderService;

//负责购买订单
@RequestMapping("/buyerorder")
@RestController
public class BuyerOrderController {
	@Resource 
	private BuyerOrderService buyerOrderService;
	
	@GetMapping("/findAllByBuyerId/{userId}")
	public List<Order> findAllByBuyerId(@PathVariable int userId){
		System.out.println("On Controller!");
		return buyerOrderService.findAllByBuyerId(userId);
	}
	
	@GetMapping("/setBOrderFlag/{bookId}")
	public void setBOrderFlag(@PathVariable int bookId){
		System.out.println("On Controller1!");
		buyerOrderService.setBOrderFlag(bookId);
	}
	
	@GetMapping("/setOrderFlag/{bookId}")
	public void setOrderFlag(@PathVariable int bookId){
		System.out.println("On Controller2!");
		buyerOrderService.setOrderFlag(bookId);
	}
	
	@GetMapping("/deleteBOrder/{orderId}")
	public void deleteBOrder(@PathVariable int orderId){
		System.out.println("On Controller3!");
		buyerOrderService.deleteBOrder(orderId);
	}
}
