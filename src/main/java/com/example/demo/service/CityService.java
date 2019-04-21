package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.CityMapper;
import com.example.demo.model.City;

@Service
public class CityService {
	  @Autowired
	  private CityMapper cityMapper;
	    /**
	     * 
	        * @Title: insertValues
	        * @Description: insert city
	        * @param @param city    参数
	        * @return void    返回类型
	        * @throws
	     */
	    public void insertValues(City city) {
	        cityMapper.insert(city);
	    }

	        /**
	        * @Title: listCity
	        * @Description: list  all 
	        * @param @return    参数
	        * @return List<City>    返回类型
	        * @throws
	        */

	    public List<City> listCity() {
	        return (List<City>) cityMapper.selelctList();
	    }

	    /**
	     * 
	        * @Title: selectByPrimaryKey
	        * @Description: find city  by  id 
	        * @param @param primaryKey
	        * @param @return    参数
	        * @return City    返回类型
	        * @throws
	     */
	    public City  selectByPrimaryKey(int primaryKey) {
	        return  cityMapper.selectByPrimaryKey(primaryKey);
	    }
}
