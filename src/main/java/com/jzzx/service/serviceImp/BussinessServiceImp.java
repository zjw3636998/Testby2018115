package com.jzzx.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzzx.bean.CenturyPlan;
import com.jzzx.bean.OfflinePay;
import com.jzzx.bean.OrderTable;
import com.jzzx.dao.BussinessDao;
import com.jzzx.service.BussinessService;
@Service("BussinessService")
public class BussinessServiceImp implements BussinessService {
	private BussinessDao bussinessDao;
	@Autowired
	public void setBussinessDao(BussinessDao bussinessDao) {
		this.bussinessDao = bussinessDao;
	}

	@Override
	public List<CenturyPlan> sourceCentury(int dealState, int planSource) {
		return bussinessDao.sourceCentury(dealState,planSource);
	}

	@Override
	public void updDealState(int dsId, int state) {
		bussinessDao.updDealState(dsId,state);
		
	}

	@Override
	public List<OrderTable> sourceWyzx(int ordertype, int orderState) {
		return bussinessDao.sourceWyzx(ordertype,orderState);
	}

	@Override
	public void updDealWyzx(int dsId, int state) {
		bussinessDao.updDealWyzx(dsId,state);
	}

	@Override
	public List<OfflinePay> sourceXxzx(int orderState) {
		return bussinessDao.sourceXxzx(orderState);
	}

	@Override
	public void updDealXxzx(int dsId, int state) {
		bussinessDao.updDealXxzx(dsId,state);
	}

}
