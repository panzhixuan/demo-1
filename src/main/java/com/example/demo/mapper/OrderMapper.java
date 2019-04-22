package com.example.demo.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Order;

@Mapper
public interface OrderMapper {
	
	int addOrder(Order record);
	
}