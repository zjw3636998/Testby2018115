package com.jzzx.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzzx.bean.CaseTable;
import com.jzzx.bean.CaseType;
import com.jzzx.dao.CaseDao;
import com.jzzx.service.CaseService;

@Service("CaseService")
public class CaseServiceImp implements CaseService{
	private CaseDao caseDao;
	@Autowired
	public void setCaseDao(CaseDao caseDao) {
		this.caseDao = caseDao;
	}
	public int totalCount(int i) {
		return caseDao.totalCount(i);
	}
	public List<CaseTable> getPageUtilsCase(int fromIndex, int pageSize,int i) {
		return caseDao.getPageUtilsCase(fromIndex, pageSize,i);
	}
	public CaseTable searchCaseContent(int caseId) {
		return caseDao.searchCaseContent(caseId);
	}
	public void delCase(int caseId, int case_state) {
		caseDao.delCase(caseId,case_state);
	}
	public void addCase(CaseTable caseTable) {
		caseDao.addCase(caseTable);
	}
	public void deleteCase(int caseId) {
		caseDao.deleteCase(caseId);
	}
	public List<CaseType> searchCaseType() {
		return caseDao.searchCaseType();
	}

}
