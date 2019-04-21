package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.annotation.Resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.City;
import com.example.demo.service.CityService;

//测试用
@RequestMapping("/city")
@RestController
public class CityController {
	@Resource 
    private  CityService cityService;
    /**
     * 
        * @Title: insertValus
        * @Description: 插入数据
        * @param     参数
        * @return void    返回类型
        * @throws
        * @author wjk
     */
    @GetMapping("/insertValues")
    public void insertValus() {
        City city =  new  City();
        city.setCityCode("370001");
        city.setCityName("广东");
        city.setId(4);
        cityService.insertValues(city);
    }

    /**
     * 
        * @Title: listCity
        * @Description: 查询所有的记录
        * @param @return    参数
        * @return List<City>    返回类型
        * @throws
        * @author wjk
     */
    @GetMapping("/list")
    public List<City> listCity() {
        return  cityService.listCity();
    }

    /**
     * 
        * @Title: selectByPrimaryKey
        * @Description: TODO(这里用一句话描述这个方法的作用)
        * @param @return    参数
        * @return City    返回类型
        * @throws
     */
    @RequestMapping("getCityById")
    public City selectByPrimaryKey() {
        return  cityService.selectByPrimaryKey(1);
    }
}
