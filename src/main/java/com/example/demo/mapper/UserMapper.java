package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {
	
	/**
     * 
        * @Description: 注册用户
     */
	int insert(User record);
	
	User selectByEmail(String userEmail);
	
	User selectByUsername(String userName);
	
	User selectByTel(String userTel);
	
	User Login(String userEmail,String userPassword);
	
	void updateByTel(String userPassword,String userTel);
	
	User getUserbyId(int id);
	
	void modifyUserbyId(int id,String name,String realname,int sex,String email,String password,String tel);
}