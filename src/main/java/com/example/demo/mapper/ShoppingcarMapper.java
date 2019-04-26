package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Shoppingcar;

@Mapper
public interface ShoppingcarMapper {
	
	/**
     * 
        * @Description: 获取购物车
     */
	List<Shoppingcar> getAllShoppingCars(int id);
	
	/**
     * 
        * @Description: 删除购物车
     */
	void deleteShoppingCar(int bookId,int userId);

	
	void insertShoppingCar(int userId, int bookId);
	
}