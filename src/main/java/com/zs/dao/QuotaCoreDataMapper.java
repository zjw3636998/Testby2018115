package com.zs.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zs.entity.QuotaCoreData;

public interface QuotaCoreDataMapper {
    int deleteByPrimaryKey(String dId);

    int insert(QuotaCoreData record);

    int insertSelective(QuotaCoreData record);

    QuotaCoreData selectByPrimaryKey(String dId);

    int updateByPrimaryKeySelective(QuotaCoreData record);

    int updateByPrimaryKey(QuotaCoreData record);
    
    List<QuotaCoreData> queryFromYear(@Param("year")Integer year,
			@Param("sort")String sort,@Param("order")String order,
			@Param("start")Integer start,@Param("size")Integer size);
    
    /*获取总数，用于分页组件*/
    int getCount();
    
    /**
     * 2017-2-24，张顺
     * 改变某个月的数据
     */
    int updateByidFromMonth(@Param("dId")String dId,@Param("i")int i,@Param("value")double value);
}