package com.zs.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.zs.entity.XtBranches;

public interface XtBranchesMapper {
    int deleteByPrimaryKey(String bId);

    int insert(XtBranches record);

    int insertSelective(XtBranches record);

    XtBranches selectByPrimaryKey(String bId);

    int updateByPrimaryKeySelective(XtBranches record);

    int updateByPrimaryKey(XtBranches record);
    
    /*获取一个时间段内其维护的总量*/
    int timeComparison(@Param("start")Date start,@Param("end")Date end);
    
    /*获取一个时间段内其维护时间大于申请时间的数量*/
    int countFromMonth(@Param("start")Date start,@Param("end")Date end);
}