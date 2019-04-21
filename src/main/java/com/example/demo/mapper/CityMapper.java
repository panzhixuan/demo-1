package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.City;

@Mapper
public interface CityMapper {
	 /**
     * 
        * @Title: deleteByPrimaryKey
        * @Description: 根据city 表主键删�?? 数据
        * @param @param id
        * @param @return    参数
        * @return int    返回类型
        * @throws
        * @author wjk
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 
        * @Title: insert 	
        * @Description: 插入数据 
        * @param @param record
        * @param @return    参数
        * @return int    返回类型
        * @throws
        * @author wjk
     */
    int insert(City record);

    /**
     * 
        * @Title: insertSelective
        * @Description: TODO(这里用一句话描述这个方法的作�??)
        * @param @param record
        * @param @return    参数
        * @return int    返回类型
        * @throws
        * @author wjk
     */
    int insertSelective(City record);

    /**
     * 
        * @Title: selectByPrimaryKey
        * @Description: TODO(这里用一句话描述这个方法的作�??)
        * @param @param id
        * @param @return    参数
        * @return City    返回类型
        * @throws
        * @author wjk
     */
    City selectByPrimaryKey(Integer id);
    /**
     * 
        * @Title: updateByPrimaryKeySelective
        * @Description: TODO(这里用一句话描述这个方法的作�??)
        * @param @param record
        * @param @return    参数
        * @return int    返回类型
        * @throws
        * @author wjk
     */
    int updateByPrimaryKeySelective(City record);
    
    /**
     * 
        * @Title: updateByPrimaryKey
        * @Description: TODO(这里用一句话描述这个方法的作�??)
        * @param @param record
        * @param @return    参数
        * @return int    返回类型
        * @throws
        * @author wjk
     */
    int updateByPrimaryKey(City record);

    /**
     * 
        * @Title: selelctList
        * @Description: TODO(这里用一句话描述这个方法的作�??)
        * @param @return    参数
        * @return City    返回类型
        * @throws
     */
    List<City> selelctList();

}