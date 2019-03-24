package com.zs.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.zs.entity.XtSite;

public interface XtSiteMapper {
    int deleteByPrimaryKey(String sId);

    int insert(XtSite record);

    int insertSelective(XtSite record);

    XtSite selectByPrimaryKey(String sId);

    int updateByPrimaryKeySelective(XtSite record);

    int updateByPrimaryKey(XtSite record);
    
    /*获取一个时间段内其维护的总量*/
    int timeComparison(@Param("start")Date start,@Param("end")Date end);
    
    /*获取一个时间段内其维护时间大于申请时间的数量*/
    int countFromMonth(@Param("start")Date start,@Param("end")Date end);
}