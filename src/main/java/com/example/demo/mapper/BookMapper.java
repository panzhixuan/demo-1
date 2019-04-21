package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.Book;

@Mapper
public interface BookMapper {
	Book getBookbyId(int bookid);
}