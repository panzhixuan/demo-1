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
	
	/**
     * 
        * @Description: 获取邮箱
     */
	User selectByEmail(String userEmail);
	/**
     * 
        * @Description: 获取用户名
     */
	User selectByUsername(String userName);
	
	/**
     * 
        * @Description: 更改手机号码
     */
	User selectByTel(String userTel);
	
	/**
     * 
        * @Description: 登录
     */
	User Login(String userEmail,String userPassword);
	
	/**
     * 
        * @Description: 更新密码
     */
	void updateByTel(String userPassword,String userTel);
	
	/**
     * 
        * @Description: 获取用户
     */
	User getUserbyId(int id);
	
	/**
     * 
        * @Description: 修改用户
     */
	void modifyUserbyId(int id,String name,String realname,int sex,String email,String password,String tel);
}