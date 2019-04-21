package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BuyService;

//售卖中心操作
@RequestMapping("/buy")
@RestController
public class BuyController {
	@Resource 
	private BuyService buyService;
	String a;
}
