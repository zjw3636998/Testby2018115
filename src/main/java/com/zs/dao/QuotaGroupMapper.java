package com.zs.dao;

import com.zs.entity.QuotaGroup;

public interface QuotaGroupMapper {
    int deleteByPrimaryKey(String qgId);

    int insert(QuotaGroup record);

    int insertSelective(QuotaGroup record);

    QuotaGroup selectByPrimaryKey(String qgId);

    int updateByPrimaryKeySelective(QuotaGroup record);

    int updateByPrimaryKey(QuotaGroup record);
}