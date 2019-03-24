package com.jzzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jzzx.bean.CenturyPlan;

public interface CenturyDao {

	int centuryCount(@Param("source")int source, @Param("searchType")String searchType, @Param("searchContent")String searchContent);
	List<CenturyPlan> getPageCentury(@Param("fromIndex")int fromIndex, @Param("pageSize")int pageSize, 
			@Param("searchType")String searchType, @Param("searchContent")String searchContent, @Param("source")int source);
	
	void insertDeal(@Param("dealEmp")String dealEmp, @Param("assignEmp")String assignEmp,
			@Param("cId")int cId, @Param("time")String time);
	
	void updCenturyPlanPs(@Param("content")String content, @Param("cId")int cId);
	
	void updDealMessage(@Param("empName")String empName, @Param("c_id")int c_id);
	
	void delCentury(@Param("c_id")int c_id);
	String selRemake(@Param("c_id")int c_id);
	void addRemake(@Param("c_id")int c_id, @Param("content")String content);

}
