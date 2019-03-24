package com.zs.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.zs.entity.XtBqq;

public interface XtBqqMapper {
    int deleteByPrimaryKey(String bId);

    int insert(XtBqq record);

    int insertSelective(XtBqq record);

    XtBqq selectByPrimaryKey(String bId);

    int updateByPrimaryKeySelective(XtBqq record);

    int updateByPrimaryKey(XtBqq record);
    
    /*获取一个时间段内其维护的总量*/
    int timeComparison(@Param("start")Date start,@Param("end")Date end);
    
    /*获取一个时间段内其维护时间大于申请时间的数量*/
    int countFromMonth(@Param("start")Date start,@Param("end")Date end);
}