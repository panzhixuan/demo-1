package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SalerOrderService;

//负责卖方订单
@RequestMapping("/salerorder")
@RestController
public class SalerOrderController {
	@Resource 
	private SalerOrderService salerOrderService;
}
