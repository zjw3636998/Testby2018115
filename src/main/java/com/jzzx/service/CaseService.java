package com.jzzx.service;

import java.util.List;

import com.jzzx.bean.CaseTable;
import com.jzzx.bean.CaseType;
/**
 * 案例接口
 * */
public interface CaseService {
	/* 查看所有案例 */
	int totalCount(int i);
	List<CaseTable> getPageUtilsCase(int fromIndex, int pageSize,int i);
	/*查看案例内容*/
	CaseTable searchCaseContent(int caseId);
	/* 删除案例（预删除） */
	void delCase(int caseId, int case_state);
	/* 增加案例 */
	void addCase(CaseTable caseTable);
	/* 完全删除案例 */
	void deleteCase(int caseId);
	/* 案例所属行业 */
	List<CaseType> searchCaseType();

}
