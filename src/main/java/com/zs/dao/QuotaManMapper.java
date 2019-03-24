package com.zs.dao;

import com.zs.entity.QuotaMan;

public interface QuotaManMapper {
    int deleteByPrimaryKey(String qmId);

    int insert(QuotaMan record);

    int insertSelective(QuotaMan record);

    QuotaMan selectByPrimaryKey(String qmId);

    int updateByPrimaryKeySelective(QuotaMan record);

    int updateByPrimaryKey(QuotaMan record);
}