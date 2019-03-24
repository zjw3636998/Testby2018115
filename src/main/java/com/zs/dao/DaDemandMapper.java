package com.zs.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.zs.entity.DaDemand;

public interface DaDemandMapper {
    int deleteByPrimaryKey(String dId);

    int insert(DaDemand record);

    int insertSelective(DaDemand record);

    DaDemand selectByPrimaryKey(String dId);

    int updateByPrimaryKeySelective(DaDemand record);

    int updateByPrimaryKey(DaDemand record);
    
    /*获取一个月的故障量*/
    int countFromMonth(@Param("start")Date start,@Param("end")Date end);
    
}