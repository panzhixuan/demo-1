package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Shoppingcar;

@Mapper
public interface ShoppingcarMapper {
	List<Shoppingcar> getAllShoppingCars(int id);
	
	void deleteShoppingCar(int userId, int bookId);
	
//	void deleteAllShoppingCar(int userId);
	
	void insertShoppingCar(int userId, int bookId);
	
}