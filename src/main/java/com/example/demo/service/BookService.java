package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;

@Service
public class BookService {
	@Autowired
	private BookMapper bookMapper;
	
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
	
//	public void setBookFlagToSold(int bookId) {
//		bookMapper.setBookFlagToSold(bookId);
//	}
//	
//	public void setBookFlagToSelling(int bookId) {
//		bookMapper.setBookFlagToSelling(bookId);
//	}
}
