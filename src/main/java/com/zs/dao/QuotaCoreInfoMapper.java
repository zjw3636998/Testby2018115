package com.zs.dao;

import com.zs.entity.QuotaCoreInfo;

public interface QuotaCoreInfoMapper {
    int deleteByPrimaryKey(String iId);

    int insert(QuotaCoreInfo record);

    int insertSelective(QuotaCoreInfo record);

    QuotaCoreInfo selectByPrimaryKey(String iId);

    int updateByPrimaryKeySelective(QuotaCoreInfo record);

    int updateByPrimaryKey(QuotaCoreInfo record);
}