package com.zs.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.zs.entity.XtPdaChange;

public interface XtPdaChangeMapper {
    int deleteByPrimaryKey(String cId);

    int insert(XtPdaChange record);

    int insertSelective(XtPdaChange record);

    XtPdaChange selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(XtPdaChange record);

    int updateByPrimaryKey(XtPdaChange record);
    
    /*获取一个时间段内其维护的总量*/
    int timeComparison(@Param("start")Date start,@Param("end")Date end);
    
    /*获取一个时间段内其维护时间大于申请时间的数量*/
    int countFromMonth(@Param("start")Date start,@Param("end")Date end);
}