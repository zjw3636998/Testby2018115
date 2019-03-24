package com.zs.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.QuotaCoreDataMapper;
import com.zs.dao.UsersMapper;
import com.zs.entity.QuotaCoreData;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.QuotaCoreDataSer;

@Service("coreDataSer")
public class QuotaCoreDataSerImpl implements QuotaCoreDataSer{

	@Resource
	private QuotaCoreDataMapper coreDataMapper;
	
	public List<QuotaCoreData> queryFromYear(Integer year,String sort,String order,Integer start,Integer size) {
		return coreDataMapper.queryFromYear(year,sort,order,start,size);
	}

	public QuotaCoreData get(String id) {
		return coreDataMapper.selectByPrimaryKey(id);
	}

	public EasyUIPage fenye(Integer year, String sort, String order, Integer start, Integer size) {
		if (start!=null && size!=null) {
			start=(start-1)*size;
		}
		int total=coreDataMapper.getCount();
		List list=coreDataMapper.queryFromYear(year, sort, order, start, size);
		EasyUIPage uiPage=new EasyUIPage(total, list);
		return uiPage;
	}

	public int update(QuotaCoreData qcd) {
		return coreDataMapper.updateByPrimaryKeySelective(qcd);
	}

}
