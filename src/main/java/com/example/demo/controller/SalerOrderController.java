package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.service.SalerOrderService;

//负责卖方订单
@RequestMapping("/salerorder")
@RestController
public class SalerOrderController {
	@Resource 
	private SalerOrderService salerOrderService;
	
	@GetMapping("/findAllSalerOrder/{userId}")
	public List<Order> findAllSalerOrder(@PathVariable int userId){
		System.out.println("On Controller!");
		return salerOrderService.findAllSalerOrder(userId);
	}
	
	@GetMapping("/setOrderFlagF/{bookId}")
	public void setOrderFlag(@PathVariable int bookId){
		System.out.println("On Controller!");
		salerOrderService.setOrderFlag(bookId);
	}
	
	@GetMapping("/deleteOrder/{orderId}")
	public void deleteOrder(@PathVariable int orderId){
		System.out.println("On Controller!");
		salerOrderService.deleteOrder(orderId);
	}
}
