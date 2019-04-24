package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.service.ShoppingCarService;

//负责购物车
@RequestMapping("/shoppingcar")
@RestController
public class ShoppingCarController {
	
	@Resource 
	private ShoppingCarService shoppingCarService;
	
	@GetMapping("/getAllShoppingCars/{id}")
	@ResponseBody
	public List<Book> getAllShoppingCars(@PathVariable int id) {
		System.out.println("On Controller!");
		return shoppingCarService.getAllShoppingCars(id);
	}
	
	
	@PostMapping("/insertShoppingCar")
	@ResponseBody
	public String insertShoppingCar(@RequestBody Map map) {
		//System.out.println(map.get("userId").toString());
		int userId = Integer.parseInt(map.get("userId").toString());
		int bookId = Integer.parseInt(map.get("bookId").toString());
	
		//System.out.println(userId);
		//System.out.println(bookId);
//		
		shoppingCarService.insertShoppingCar(userId, bookId);		
		return "success!";
	}
	
	
//	@PostMapping("deleteShoppingCar/{bookId}/{userId}")
//    @ResponseBody
//    public String deleteShoppingCar(@PathVariable int bookId,@PathVariable int userId) {
//        shoppingCarService.deleteShoppingCar(bookId,userId);
//        return "Success!";
//    }
}
