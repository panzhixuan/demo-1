package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;

@Service
public class UserInforService {
	@Autowired
	private UserMapper userMapper;
	
	/**
     * 
        * @Description: 获取用户
     */
	public User getUserbyId(int id) {
		System.out.println("On Service!");
		return userMapper.getUserbyId(id);
	}
	
	/**
     * 
        * @Description: 修改用户
     */
	public String modifyUserbyId(int id,String name,String realname,int sex,String email,String password,String tel) {
		System.out.println("On Service!");
		userMapper.modifyUserbyId(id,name,realname,sex,email,password,tel);
		return "Success!";
	}
	
}
