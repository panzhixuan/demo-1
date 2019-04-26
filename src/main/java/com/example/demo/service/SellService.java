package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;

@Service
public class SellService {
	@Autowired
	private BookMapper bookMapper;
	/**
     * 
        * @return 
	 * @return 
	 * @Description: 澧炲姞涔︾睄
     */
	public String addSalerBook(Book newbook) {
		// TODO Auto-generated method stub
		System.out.println("this way!");
        bookMapper.insertBook(newbook);
        return "Success!!";
	}
	/**
     * 
        * @return 
	 * @return 
	 * @Description: 淇敼涔︾睄
     */
	public void modifySalerBook(Book newbook, int bookId) {
		// TODO Auto-generated method stub
		System.out.println("this way!");
		bookMapper.deleteBook(bookId);
		System.out.println("that way!!!");
        bookMapper.insertBook(newbook);
	}
	public void deleteSalerBook(int news) {
		// TODO Auto-generated method stub
		System.out.println("this way!");
		bookMapper.deleteBook(news);
	}
 
}
