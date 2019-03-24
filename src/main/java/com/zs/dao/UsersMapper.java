package com.zs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zs.entity.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(String uNum);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(String uNum);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    List<Users> queryFenye(@Param("start")Integer start,@Param("size")Integer size,@Param("sort")String sort,@Param("order")String order);
    
    int getCount();
}