package com.jzzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jzzx.bean.CenturyPlan;
import com.jzzx.bean.OfflinePay;
import com.jzzx.bean.OrderTable;

public interface BussinessDao {

	List<CenturyPlan> sourceCentury(@Param("dealState")int dealState, @Param("planSource")int planSource);

	void updDealState(@Param("dsId")int dsId, @Param("state")int state);

	List<OrderTable> sourceWyzx(@Param("orderType")int ordertype, @Param("orderState")int orderState);

	void updDealWyzx(@Param("dsId")int dsId, @Param("state")int state);

	List<OfflinePay> sourceXxzx(@Param("state")int orderState);

	void updDealXxzx(@Param("dsId")int dsId, @Param("state")int state);

}
