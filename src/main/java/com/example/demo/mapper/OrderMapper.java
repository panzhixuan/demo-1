package com.example.demo.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Order;

@Mapper
public interface OrderMapper {
	
	/**
     * 
        * @Description: 增加订单
     */
	int addOrder(Order record);
	
	Order findOrderbybookId(int bookId);
	
	List<Order> findAllByBuyerId(int userId);
	
	void setOrderFlag(int bookId,int flag);
	
	void deleteOrder(int orderId);
	
}