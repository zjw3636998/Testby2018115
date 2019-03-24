package com.zs.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zs.dao.DaDemandMapper;
import com.zs.dao.QuotaCoreDataMapper;
import com.zs.dao.XtBqqMapper;
import com.zs.dao.XtBranchesMapper;
import com.zs.dao.XtPdaChangeMapper;
import com.zs.dao.XtSiteMapper;
import com.zs.dao.XtZmNumberMapper;
import com.zs.entity.QuotaCoreData;
import com.zs.service.QuotaCoreHandle;

@Service("coreHandel")
public class QuotaCoreHadelImpl implements QuotaCoreHandle{

	Logger log=Logger.getLogger(QuotaCoreHadelImpl.class);
	
	@Resource
	private DaDemandMapper demandMapper;
	@Resource
	private XtBqqMapper bqqMapper;
	@Resource
	private XtSiteMapper siteMapper;
	@Resource
	private XtPdaChangeMapper pdaMapper;
	@Resource
	private XtBranchesMapper branchesMapper;
	@Resource
	private XtZmNumberMapper zmNumberMapper;
	@Resource
	private QuotaCoreDataMapper dataMapper;

	/* 张顺，2017-2-24，目前的公式是：故障报修量/12  */
	public int reckonRJWH(String dId) {
		QuotaCoreData data=dataMapper.selectByPrimaryKey(dId);
		int year=data.getCoreInfo().getiYear().getYear()+1900;
		log.info(year);
		int result=0;
		if (data.getCoreInfo().getiName().equals("人均维护量")) {
			for (int i = 0; i < 12; i++) {
				Date start=new Date(year-1900, i, 1);
				Date end=new Date(year-1900, i+1, 0,23,59,59);
				log.info(start.toLocaleString());
				log.info(end.toLocaleString());
				int counts=demandMapper.countFromMonth(start, end);
				Double ratio=(double)counts/12;
				result=result+dataMapper.updateByidFromMonth(data.getdId(), i+1, ratio);
			}
		}
		return result;
	}

	/*账号维护及时率      黄光辉  2017年2月25日 ，目前公式是（维护日期<开通日期 ）/总数      */
	public int reckonZHWH(String dId) {
		QuotaCoreData data=dataMapper.selectByPrimaryKey(dId);
		int year=data.getCoreInfo().getiYear().getYear()+1900;
		log.info(year);
		int result=0;
		if (data.getCoreInfo().getiName().equals("账号维护及时率")) {
			for (int i = 0; i < 12; i++) {
				int count = 0;
				int counts= 0;
				Date start=new Date(year-1900, i, 1);
				Date end=new Date(year-1900, i+1, 0,23,59,59);
				log.info(start.toLocaleString());
				log.info(end.toLocaleString());
				count = siteMapper.timeComparison(start, end) + pdaMapper.timeComparison(start, end) +
						branchesMapper.timeComparison(start, end)+ zmNumberMapper.timeComparison(start, end)+ 
						bqqMapper.timeComparison(start, end);
				counts = siteMapper.countFromMonth(start, end) + pdaMapper.countFromMonth(start, end)+
						branchesMapper.countFromMonth(start, end)+ zmNumberMapper.countFromMonth(start, end)+
						bqqMapper.countFromMonth(start, end);
				System.out.println(count);
				System.out.println(counts);
				Double ratio=(double)counts/12;
				result=result+dataMapper.updateByidFromMonth(data.getdId(), i+1, ratio);
			}
		}
		return result;
	}

	public int reckonGZWH(String dId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int reckonRJCZ(String dId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int reckonBQPJ(String dId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int reckonSBXJ(String dId) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int reckonHXYY(String dId) {
		// TODO Auto-generated method stub
		return 0;
	} 


}
