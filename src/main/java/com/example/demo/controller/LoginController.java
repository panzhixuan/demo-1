package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.CityService;
import com.example.demo.service.LoginService;

//负责登录注册找回密码
@RequestMapping("/login")
@RestController
public class LoginController {
	@Resource 
    private  LoginService loginService;
	
	/**
     * 
        * @Description: 注册用户
     */
	@PostMapping("addUser")
	@ResponseBody
	public String addUser(@RequestBody Map map) {
		User newuser=new User();
		newuser.setUserName(map.get("username").toString());
		newuser.setUserRealname(map.get("realname").toString());
		newuser.setUserSex(0);
		newuser.setUserEmail(map.get("email").toString());
		newuser.setUserPassword(map.get("password").toString());
		newuser.setUserTel(map.get("tel").toString());
		loginService.addUser(newuser);
		return "Success!";
	}
	
	/**
     * 
        * @Description: 检查邮箱
     */
	@GetMapping("/checkemail/{email}")
	public User checkEmail(@PathVariable String email){
		System.out.println("On Controller!");
		return loginService.checkEmail(email);
	}
	
	/**
     * 
        * @Description: 检查用户名
     */
	@GetMapping("/checkusername/{username}")
	public User checkUsername(@PathVariable String username){
		System.out.println("On Controller!");
		return loginService.checkUsername(username);
	}
	
	/**
     * 
        * @Description: 检查手机号码
     */
	@GetMapping("/checktel/{tel}")
	public User checkTel(@PathVariable String tel){
		System.out.println("On Controller!");
		return loginService.checkTel(tel);
	}
	
	/**
     * 
        * @Description: 登录
     */
	@GetMapping("/Login/{email}/{password}")
	public Integer Login(@PathVariable String email,@PathVariable String password){
		System.out.println("On Controller!");
		return loginService.Login(email,password);
	}
	
	/**
     * 
        * @Description: 更改密码
     */
	@GetMapping("/newpassword/{password}/{tel}")
	public String newPassword(@PathVariable String password,@PathVariable String tel){
		System.out.println("On Controller!");
		loginService.newPassword(password,tel);
		return "Success!";
	}
	
}
