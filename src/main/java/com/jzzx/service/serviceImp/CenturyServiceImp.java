package com.jzzx.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzzx.bean.CenturyPlan;
import com.jzzx.dao.CenturyDao;
import com.jzzx.service.CenturyService;
@Service("CenturyService")
public class CenturyServiceImp implements CenturyService {
	private CenturyDao centuryDao;
	@Autowired
	public void setCenturyDao(CenturyDao centuryDao) {
		this.centuryDao = centuryDao;
	}

	@Override
	public int centuryCount(int source, String searchType, String searchContent) {
		return centuryDao.centuryCount(source,searchType,searchContent);
	}

	@Override
	public List<CenturyPlan> getPageCentury(int fromIndex, int pageSize, String searchType, String searchContent,
			int source) {
		return centuryDao.getPageCentury(fromIndex,pageSize,searchType,searchContent,source);
	}

	@Override
	public void insertDeal(String dealEmp, String assignEmp, int cId, String time) {
		centuryDao.insertDeal(dealEmp,assignEmp,cId,time);		
	}

	@Override
	public void updCenturyPlanPs(String content, int cId) {
		centuryDao.updCenturyPlanPs(content,cId);
	}

	@Override
	public void updDealMessage(String empName, int c_id) {
		centuryDao.updDealMessage(empName,c_id);
	}

	@Override
	public void delCentury(int c_id) {
		centuryDao.delCentury(c_id);
	}

	@Override
	public String selRemake(int c_id) {
		return centuryDao.selRemake(c_id);
	}

	@Override
	public void addRemake(int c_id, String content) {
		centuryDao.addRemake(c_id,content);
	}

}
