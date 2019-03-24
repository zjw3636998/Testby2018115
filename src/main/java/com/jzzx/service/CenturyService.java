package com.jzzx.service;

import java.util.List;

import com.jzzx.bean.CenturyPlan;

public interface CenturyService {

	int centuryCount(int source, String searchType, String searchContent);

	List<CenturyPlan> getPageCentury(int fromIndex, int pageSize, String searchType, String searchContent, int source);

	void insertDeal(String dealEmp, String assignEmp, int id, String time);

	void updCenturyPlanPs(String content, int id);

	void updDealMessage(String empName, int c_id);

	void delCentury(int c_id);

	String selRemake(int c_id);

	void addRemake(int c_id, String content);

}
