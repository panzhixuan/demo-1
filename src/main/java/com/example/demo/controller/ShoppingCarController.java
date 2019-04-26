package com.example.demo.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.example.demo.model.Order;
import com.example.demo.model.User;
import com.example.demo.service.ShoppingCarService;

//负责购物车
@RequestMapping("/shoppingcar")
@RestController
public class ShoppingCarController {
	
	@Resource 
	private ShoppingCarService shoppingCarService;
	
	/**
     * 
        * @Description: 获取购物车
     */
	@GetMapping("/getAllShoppingCars/{id}")
	@ResponseBody
	public List<Book> getAllShoppingCars(@PathVariable int id) {
		System.out.println("On Controller!");
		return shoppingCarService.getAllShoppingCars(id);
	}
	
	/**
     * 
        * @Description: 删除购物车
     */
	@PostMapping("deleteShoppingCar/{bookId}/{userId}")
    @ResponseBody
    public String deleteShoppingCar(@PathVariable int bookId,@PathVariable int userId) {
        shoppingCarService.deleteShoppingCar(bookId,userId);
        return "Success!";
    }
	
	/**
     * 
        * @Description: 购物车购买书籍
     */
	@PostMapping("buyThisBook/{bookId}/{userId}/{bookPrice}")
    @ResponseBody
    public String buyThisBook(@PathVariable int bookId,@PathVariable int userId,@PathVariable BigDecimal bookPrice){
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String t =time.format(new Date());
		Order neworder = new Order();
		neworder.setBuyerId(userId);
		neworder.setOrderTime(t);
		neworder.setBookId(bookId);
		neworder.setOrderPrice(bookPrice);
		neworder.setOrderFlag(0);
//		System.out.println(neworder.getOrderTime());
        shoppingCarService.buyThisBook(bookId,userId);
        shoppingCarService.addOrder(neworder);
        return "Success!";
    }
	
	@PostMapping("/insertShoppingCar")
	@ResponseBody
	public String insertShoppingCar(@RequestBody Map map) {
		int userId = Integer.parseInt(map.get("userId").toString());
		int bookId = Integer.parseInt(map.get("bookId").toString());
		shoppingCarService.insertShoppingCar(userId, bookId);		
		return "success!";
	}
	
	
}
