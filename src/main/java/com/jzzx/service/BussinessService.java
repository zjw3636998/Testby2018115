package com.jzzx.service;

import java.util.List;

import com.jzzx.bean.CenturyPlan;
import com.jzzx.bean.OfflinePay;
import com.jzzx.bean.OrderTable;

public interface BussinessService {

	List<CenturyPlan> sourceCentury(int dealState, int planSource);

	void updDealState(int dsId, int state);

	List<OrderTable> sourceWyzx(int ordertype, int orderState);

	void updDealWyzx(int dsId, int state);

	List<OfflinePay> sourceXxzx(int orderState);

	void updDealXxzx(int dsId, int state);

}
