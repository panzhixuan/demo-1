package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.OrderMapper;
import com.example.demo.model.Book;
import com.example.demo.model.Order;

@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;
	
	@Autowired
	private OrderMapper orderMapper;
	
	public void insertValues(Book book) {
		bookMapper.insertBook(book);
	}
	public List<Book> getAllBook() {
		return bookMapper.getAllBook();
	}
	
	public List<Book> getEducationBook() {
		return bookMapper.getEducationBook();
	}
	
	public List<Book> getLeisureBook() {
		return bookMapper.getLeisureBook();
	}
	
	public List<Book> getLiteratureBook() {
		return bookMapper.getLiteratureBook();
	}
	
	public List<Book> getScienceBook() {
		return bookMapper.getScienceBook();
	}
	
	public Book getBookById(int bookId) {
		return bookMapper.getBookbyId(bookId);
	}
	
	public List<Book> getBookBySalerId(int salerId) {
		return bookMapper.getBookBySalerId(salerId);
	}

	public Book getBookByName(String bookName) {
		return bookMapper.getBookByName(bookName);
	}
	
	public String addOrder(Order order,int bookId) {
		orderMapper.addOrder(order);
		bookMapper.setBookFlagToSold(bookId);
		return "Success!";
	}

}
