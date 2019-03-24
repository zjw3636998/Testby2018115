package com.zs.service;

import java.util.List;

import com.zs.entity.Users;
import com.zs.entity.other.EasyUIPage;

public interface UserSer {
	
	public Users get(String id);
	
	public List<Users> queryFenye(Integer start,Integer size,String sort,String order);
	
	public int save(Users user);
	
	public int update(Users user);
	
	public int delete(String uNum);
	
	public int getCount();
	
	public EasyUIPage fenye(Integer start,Integer size,String sort,String order);
}
