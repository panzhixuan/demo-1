package com.example.demo.controller;

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
import com.example.demo.service.UserInforService;

//负责用户信息修改
@RequestMapping("/userinfor")
@RestController
public class UserInforController {
	@Resource 
	private UserInforService userInforService;
	
	/**
     * 
        * @Description: 获取用户
     */
	@GetMapping("/getUserbyId/{id}")
	@ResponseBody
	public User getUserbyId(@PathVariable int id) {
		System.out.println("On Controller!");
		return userInforService.getUserbyId(id);
	}
	
	/**
     * 
        * @Description: 修改用户
     */
	@PostMapping("modifyUserbyId")
	@ResponseBody
	public String modifyUserbyId(@RequestBody Map map) {
		int id=Integer.parseInt(map.get("userId").toString().trim());
		String name=map.get("name").toString();
		String realname=map.get("realname").toString();
		int sex=Integer.parseInt(map.get("sex").toString().trim());
		String email=map.get("email").toString();
		String password=map.get("password").toString();
		String tel=map.get("tel").toString();
		userInforService.modifyUserbyId(id,name,realname,sex,email,password,tel);
		return "Success!";
	}
}
