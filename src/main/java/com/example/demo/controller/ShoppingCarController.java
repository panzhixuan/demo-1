package com.example.demo.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping("/getAllShoppingCars/{id}")
	@ResponseBody
	public List<Book> getAllShoppingCars(@PathVariable int id) {
		System.out.println("On Controller!");
		return shoppingCarService.getAllShoppingCars(id);
	}
	
	@PostMapping("deleteShoppingCar/{bookId}/{userId}")
    @ResponseBody
    public String deleteShoppingCar(@PathVariable int bookId,@PathVariable int userId) {
        shoppingCarService.deleteShoppingCar(bookId,userId);
        return "Success!";
    }
	
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
}
