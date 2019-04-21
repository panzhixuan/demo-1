package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.SellService;

//负责销售中心
@RequestMapping("/sell")
@RestController
public class SellController {

	@Resource 
	private SellService sellService;
}
