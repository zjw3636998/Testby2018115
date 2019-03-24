package com.zs.dao;

import com.zs.entity.Licence;

public interface LicenceMapper {
    int deleteByPrimaryKey(String lId);

    int insert(Licence record);

    int insertSelective(Licence record);

    Licence selectByPrimaryKey(String lId);

    int updateByPrimaryKeySelective(Licence record);

    int updateByPrimaryKey(Licence record);
}