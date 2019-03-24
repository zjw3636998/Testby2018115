package com.jzzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jzzx.bean.CaseTable;
import com.jzzx.bean.CaseType;

public interface CaseDao {
	int totalCount(@Param("state")int i);
	List<CaseTable> getPageUtilsCase(@Param("fromIndex")int fromIndex, @Param("pageSize")int pageSize, @Param("state")int i);
	CaseTable searchCaseContent(@Param("caseId")int caseId);
	void delCase(@Param("caseId")int caseId,@Param("case_state")int case_state);
	void addCase(CaseTable caseTable);
	void deleteCase(@Param("caseId")int caseId);
	List<CaseType> searchCaseType();
}
