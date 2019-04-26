package com.example.demo.controller;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.service.SellService;


//负责销售中心
@RequestMapping("/sell")
@RestController
public class SellController {

	@Resource 
	private SellService sellService;
	
	@GetMapping("/deleteSalerBooks/{deletelist}")
	@ResponseBody
	public String deleteSalerBooks(@PathVariable List<Integer> deletelist) {
		int longs =  deletelist.size();
		int news;
		for(int i=0;i<longs;i++)
		{
			news=(int) deletelist.get(i);
			sellService.deleteSalerBook(news);
		}
		
		
		return "Success!";
	}
	
	@PostMapping("addSalerBook")
	@ResponseBody
	public String addSalerBook(@RequestBody Map map) {
		System.out.println("Get Map!!!");
		Book newbook=new Book();
		int typeId=Integer.parseInt(map.get("typeId").toString());
		int flag=Integer.parseInt(map.get("flag").toString());
		BigDecimal price=new BigDecimal(map.get("price").toString());
		BigDecimal oPrice=new BigDecimal(map.get("oPrice").toString());
		int saler=Integer.parseInt(map.get("salerId").toString());
		newbook.setSalerId(saler);
		System.out.println("saler"+saler);
		newbook.setBookName(map.get("name").toString());
		System.out.println("name");
		System.out.println(map.get("image").toString());
//		newbook.setBookImage(("http://app2.showapi.com/isbn/img1/eaa363cbced8474e992dea310faf176d.jpg").toString());
		newbook.setBookImage(map.get("image").toString());
		System.out.println("image");
		newbook.setBookAuthor(map.get("author").toString());
		System.out.println("author");
		newbook.setBookVersion(map.get("version").toString());
		System.out.println("version");
		newbook.setBookPrice(price);
		System.out.println("price");
		newbook.setBookOriginalprice(oPrice);
		System.out.println("oPrice");
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String t =time.format(new Date());
		newbook.setBookModifytime(t);
		System.out.println("time");
		newbook.setBookFlag(flag);
		System.out.println("flag");
		newbook.setBookType(typeId);
		System.out.println("type");
		sellService.addSalerBook(newbook);
		return "Success!";
	}
	
	@PostMapping("modifySalerBook")
	@ResponseBody
	public String modifySalerBook(@RequestBody Map map) {
		System.out.println("Get Map!!!");
		Book newbook=new Book();
		int bookId=Integer.parseInt(map.get("bookId").toString());
		System.out.println("Get Map!!!");
		int typeId=Integer.parseInt(map.get("typeId").toString());
		System.out.println("Get Map1111");
//		int flag=Integer.parseInt(map.get("flag").toString());
		System.out.println("Get Map2222");
		BigDecimal price=new BigDecimal(map.get("price").toString());
		System.out.println("Get Map3333");
		BigDecimal oPrice=new BigDecimal(map.get("oPrice").toString());
		System.out.println("Get Map4444");
		int saler=Integer.parseInt(map.get("salerId").toString());
		System.out.println("Get Map5555");
		newbook.setSalerId(saler);
		System.out.println("saler"+saler);
		newbook.setBookName(map.get("name").toString());
		System.out.println("name");
		newbook.setBookImage(map.get("image").toString());
		System.out.println("image");
		newbook.setBookAuthor(map.get("author").toString());
		System.out.println("author");
		newbook.setBookVersion(map.get("version").toString());
		System.out.println("version");
		newbook.setBookPrice(price);
		System.out.println("price");
		newbook.setBookOriginalprice(oPrice);
		System.out.println("oPrice");
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String t =time.format(new Date());
		newbook.setBookModifytime(t);
//		newbook.setBookModifytime(map.get("uploadTime").toString());
		System.out.println("time");
		newbook.setBookFlag(0);
		System.out.println("flag");
		newbook.setBookType(typeId);
		System.out.println("type");
		sellService.modifySalerBook(newbook,bookId);
		return "Success!";
	}
}

