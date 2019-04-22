package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.City;
import com.example.demo.model.User;

@Service
public class LoginService {
	@Autowired
	  private UserMapper userMapper;
	
	/**
     * 
        * @Description: 注册用户
     */
	 public String addUser(User user) {
	        userMapper.insert(user);
	        return "Success!!";
	    }
	 
	 /**
	     * 
	        * @Description: 检测邮箱
	     */
	 public User checkEmail(String email){
			System.out.println("On Service!");
			return userMapper.selectByEmail(email);
		}
	 
	 /**
	     * 
	        * @Description: 检查用户名
	     */
	 public User checkUsername(String username){
			System.out.println("On Service!");
			return userMapper.selectByUsername(username);
		}
	 
	 /**
	     * 
	        * @Description: 检查手机号码
	     */
	 public User checkTel(String tel){
			System.out.println("On Service!");
			return userMapper.selectByTel(tel);
		}
	 
	 /**
	     * 
	        * @Description: 登录
	     */
	 public Integer Login(String email,String password){
			System.out.println("On Service!");
			return userMapper.Login(email,password).getUserId();
		}
	 
	 /**
	     * 
	        * @Description: 设置密码
	     */
	 public String newPassword(String password,String tel){
			System.out.println("On Service!");
			userMapper.updateByTel(password,tel);
			return "Success!!";
		}
	 
}
