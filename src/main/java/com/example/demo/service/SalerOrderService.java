package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.Book;
import com.example.demo.model.Order;

@Service
public class SalerOrderService {
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private BookMapper bookMapper;
	
	public List<Order> findAllSalerOrder(int userId){
		List<Book> book=bookMapper.getBookBySalerId(userId);
		List<Order> result=new ArrayList<>();
		for(int i=0;i<book.size();i++) {
			if(book.get(i).getSalerId() == userId) {
				System.out.println(book.get(i).getSalerId());
				System.out.println(book.get(i).getBookId());
				if(orderMapper.findOrderbybookId(book.get(i).getBookId())!=null) {
					result.add(orderMapper.findOrderbybookId(book.get(i).getBookId()));
				}
			}
		}
		return result;
	}
	
	public void setOrderFlag(int bookId) {
		orderMapper.setOrderFlag(bookId,3);
	}
	
	public void deleteOrder(int orderId) {
		orderMapper.deleteOrder(orderId);
	}

}
