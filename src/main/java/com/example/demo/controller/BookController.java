package com.example.demo.controller;
import java.util.Date;
import java.util.List;
import java.util.Map;
import com.show.api.*;

import net.sf.json.JSONObject;

import javax.annotation.Resource;

import org.apache.naming.java.javaURLContextFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BookService;

import com.example.demo.model.Book;
import com.example.demo.model.Order;

import java.util.Timer;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;




@RequestMapping("/Book")
@RestController
public class BookController {
	@Resource 
	private BookService bookService;
	
//	@GetMapping("/sendISBN")
//	public String sendISBN(@RequestBody Map map) {
//		String res=new ShowApiRequest("http://route.showapi.com/1626-1","93011","39823d9847784f21929049af11687647")
//				.addTextPara("isbn","9787208061644")
//			  .post();
//		System.out.println(res);
//			
//		return "Success!";
//	}
	@GetMapping("/sendISBN/{ISBNCode}")
	public String sendISBN(@PathVariable String ISBNCode) {
		String res=new ShowApiRequest("http://route.showapi.com/1626-1","93011","39823d9847784f21929049af11687647")
	 			.addTextPara("isbn",ISBNCode)
			  .post();
		
		System.out.println(res);
		
		JSONObject resJson = JSONObject.fromObject(res);
		
		int code = resJson.getInt("showapi_res_code");
		if(code != 0) {
			System.out.println("trying to get book detail, but failed");
			return "trying to get book detail, but failed";
		}
		JSONObject resBody = resJson.getJSONObject("showapi_res_body");
		JSONObject bookDetail = resBody.getJSONObject("data");
		String produceString = bookDetail.getString("produce");
		String bindingString = bookDetail.getString("binding");
		int page = bookDetail.getInt("page");
		String authorString = bookDetail.getString("author");
		String paperString = bookDetail.getString("paper");
		String gist = bookDetail.getString("gist");
		String edition = bookDetail.getString("edition");
		String titleString = bookDetail.getString("title");
		int price = bookDetail.getInt("price");
		String isbn = bookDetail.getString("isbn");
		String img = bookDetail.getString("img");
		String format = bookDetail.getString("format");
		String publisher = bookDetail.getString("publisher");
		
		Book book = new Book();
		book.setBookName(titleString);
		book.setBookType(1);
		book.setSalerId(35);
		book.setBookImage(img);
		book.setBookAuthor(authorString);
		book.setBookVersion(edition);
		
//		java.util.Date date = new java.util.Date();
//		java.sql.Time time = new java.sql.Time(date.getTime());
//		book.setBookModifytime(time.toString());
	
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String t =time.format(new Date());
		
		book.setBookModifytime(t);
		
		BigDecimal number = new BigDecimal(0);
		number=BigDecimal.valueOf((int)price);
		book.setBookPrice(number);
		book.setBookOriginalprice(number);
		
		book.setBookFlag(1);
		
		bookService.insertValues(book);
		
		return res;
	}
	


	@GetMapping("/getBook/{bookType}")
	public List<Book> getBook(@PathVariable String bookType) {
		System.out.println("getBook");
		if(bookType.equals("all")) {
			return bookService.getAllBook();
		}
		else if(bookType.equals("science")) {
			return bookService.getScienceBook();
		}
		else if(bookType.equals("education")) {
			return bookService.getEducationBook();
		}
		else if(bookType.equals("leisure")) {
			return bookService.getLeisureBook();
		}
		else if(bookType.equals("literature")) {
			return bookService.getLiteratureBook();
		}
		else {
			return null;
		}
	}
	
	@GetMapping("/getBookById/{bookId}")
	public Book getBookbyId(@PathVariable int bookId) {
		System.out.println("getBookbyId");
		return bookService.getBookById(bookId);
	}
	
	@GetMapping("/getBookBySalerId/{salerId}")
	public List<Book> getBookBySalerId(@PathVariable int salerId) {
		return bookService.getBookBySalerId(salerId);
	}
	
	@GetMapping("/getBookByName/{bookName}")
	public Book getBookByName(@PathVariable String bookName) {
		System.out.println("getBookByName");
		return bookService.getBookByName(bookName);
	}
	
	@PostMapping("/buyNow")
	public String buyThisBook(@RequestBody Map map) {
		System.out.println(1111);
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String t =time.format(new Date());
		Order neworder = new Order();
		neworder.setBuyerId(Integer.parseInt(map.get("buyerId").toString().trim()));
		neworder.setOrderTime(t);
		neworder.setBookId(Integer.parseInt(map.get("bookId").toString().trim()));
		neworder.setOrderPrice(new BigDecimal(map.get("price").toString()));
		neworder.setOrderFlag(0);
		System.out.println(neworder.getBookId());
		System.out.println(neworder.getBuyerId());
		System.out.println(neworder.getOrderFlag());
		System.out.println(neworder.getOrderPrice());
		System.out.println(neworder.getOrderTime());
        bookService.addOrder(neworder,Integer.parseInt(map.get("bookId").toString().trim()));
        return "Success!";
	}

}
