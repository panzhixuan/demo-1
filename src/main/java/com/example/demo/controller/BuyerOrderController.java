package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BuyerOrderService;

//负责购买订单
@RequestMapping("/buyerorder")
@RestController
public class BuyerOrderController {
	@Resource 
	private BuyerOrderService buyerOrderService;
}
