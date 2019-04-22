package com.example.demo.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Order;

@Mapper
public interface OrderMapper {
	
	/**
     * 
        * @Description: 增加订单
     */
	int addOrder(Order record);
	
}