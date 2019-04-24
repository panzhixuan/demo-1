package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Book;

@Mapper
public interface BookMapper {
	Book getBookbyId(int bookid);
	
	int insertBook(Book book);
	
	List<Book> getAllBook();
	List<Book> getScienceBook();
	List<Book> getEducationBook();
	List<Book> getLeisureBook();
	List<Book> getLiteratureBook();	
	
	void setBookFlagToSold(int bookId);
	void setBookFlagToSelling(int bookId);
	
	
	
}