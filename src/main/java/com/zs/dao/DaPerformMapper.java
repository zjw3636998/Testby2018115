package com.zs.dao;

import com.zs.entity.DaPerform;

public interface DaPerformMapper {
    int deleteByPrimaryKey(String pId);

    int insert(DaPerform record);

    int insertSelective(DaPerform record);

    DaPerform selectByPrimaryKey(String pId);

    int updateByPrimaryKeySelective(DaPerform record);

    int updateByPrimaryKey(DaPerform record);
}