package com.zs.service;

import java.util.Date;
import java.util.List;

import com.zs.entity.QuotaCoreData;
import com.zs.entity.Users;
import com.zs.entity.other.EasyUIPage;

public interface QuotaCoreDataSer {
	
	public List<QuotaCoreData> queryFromYear(Integer year,String sort,String order,Integer start,Integer size);
	
	public QuotaCoreData get(String id);
	
	public EasyUIPage fenye(Integer year,String sort,String order,Integer start,Integer size);
	
	public int update(QuotaCoreData qcd);
}
