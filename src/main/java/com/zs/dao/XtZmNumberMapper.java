package com.zs.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.zs.entity.XtZmNumber;

public interface XtZmNumberMapper {
    int deleteByPrimaryKey(String zmId);

    int insert(XtZmNumber record);

    int insertSelective(XtZmNumber record);

    XtZmNumber selectByPrimaryKey(String zmId);

    int updateByPrimaryKeySelective(XtZmNumber record);

    int updateByPrimaryKey(XtZmNumber record);
    
    /*获取一个时间段内其维护的总量*/
    int timeComparison(@Param("start")Date start,@Param("end")Date end);
    
    /*获取一个时间段内其维护时间大于申请时间的数量*/
    int countFromMonth(@Param("start")Date start,@Param("end")Date end);
}