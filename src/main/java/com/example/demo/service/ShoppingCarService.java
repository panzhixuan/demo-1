package com.example.demo.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.mapper.ShoppingcarMapper;
import com.example.demo.model.Book;
import com.example.demo.model.Order;
import com.example.demo.model.Shoppingcar;

@Service
public class ShoppingCarService {
	@Autowired
	private ShoppingcarMapper shoppingcarMapper;
	
	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private OrderMapper orderMapper;
	
	public List<Book> getAllShoppingCars(int id) {
		System.out.println("On Service!");
		List<Shoppingcar> total=shoppingcarMapper.getAllShoppingCars(id);
		List<Book> result=new ArrayList<>();
		for(int i=0;i<total.size();i++) {
			int bookid=total.get(i).getBookId();
			result.add(bookMapper.getBookbyId(bookid));
		}
		return result;
	}
	
	public String deleteShoppingCar(int bookId,int userId) {
		System.out.println("On Service!");
		shoppingcarMapper.deleteShoppingCar(bookId,userId);
		bookMapper.updateBookflag(bookId,0);
		return  "Success!";
	}
	
	public String buyThisBook(int bookId,int userId) {
		System.out.println("On Service!!!!");
		shoppingcarMapper.deleteShoppingCar(bookId,userId);
		return  "Success!";
	}
	
	public String addOrder(Order order) {
		orderMapper.addOrder(order);
		return "Success!";
	}
}
