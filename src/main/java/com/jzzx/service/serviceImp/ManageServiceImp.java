package com.jzzx.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzzx.bean.Employee;
import com.jzzx.bean.FileTable;
import com.jzzx.bean.MeetingTable;
import com.jzzx.bean.UserTable;
import com.jzzx.dao.ManageDao;
import com.jzzx.service.ManageService;
@Service("ManageService")
public class ManageServiceImp implements ManageService {
	private ManageDao manageDao;
	@Autowired
	public void setManageDao(ManageDao manageDao) {
		this.manageDao = manageDao;
	}
	@Override
	public void uploadFile(FileTable fileTable) {
		manageDao.uploadFile(fileTable);
	}
	@Override
	public int fileCount(int f_type,String searchType, String searchContent) {
		int i =manageDao.fileCount(f_type,searchType,searchContent);
		return i;
	}
	@Override
	public List<FileTable> getPageFile(int fromIndex, int pageSize, int f_type, String searchType, String searchContent) {
		return manageDao.getPageFile(fromIndex,pageSize,f_type,searchType,searchContent);
	}
	@Override
	public void deleteFile(String fileUrl) {
		manageDao.deleteFile(fileUrl);
	}
	@Override
	public void uploadMeeting(MeetingTable meetingTable) {
		manageDao.uploadMeeting(meetingTable);
	}
	@Override
	public int seletMeetCount(String searchType, String searchContent) {
		return manageDao.seletMeetCount(searchType,searchContent);
	}
	@Override
	public List<MeetingTable> getPageMeeting(int fromIndex, int pageSize, String searchType, String searchContent) {
		return manageDao.getPageMeeting(fromIndex,pageSize,searchType,searchContent);
	}
	@Override
	public void delMeeting(int mid) {
		manageDao.delMeeting(mid);
	}
	@Override
	public String meetingContent(int mid) {
		return manageDao.meetingContent(mid);
	}
	@Override
	public int selectEmpCount(String searchType, String searchContent) {
		return manageDao.selectEmpCount(searchType,searchContent);
	}
	@Override
	public List<Employee> getPageEmployee(int fromIndex, int pageSize, String searchType, String searchContent) {
		return manageDao.getPageEmployee(fromIndex,pageSize,searchType,searchContent);
	}
	@Override
	public void dimissionEmp(int user_id, String time) {
		System.out.println("user_id="+user_id+",time="+time);
		//删除账号对应角色
		manageDao.delRoleUser(user_id);
		//员工信息增加离职时间
		manageDao.updEmployee(user_id,time);
		//账号增加注销时间
		manageDao.updUser(user_id,time);

		
	}
	@Override
	public UserTable userMessage(int user_id) {
		return manageDao.userMessage(user_id);
	}
	@Override
	public int addAccount(UserTable userTable,int depart_id) {
		try {
			manageDao.addAccount(userTable);
			if(userTable.getU_id()!=0){
				manageDao.addEmpRole(userTable.getU_id(),depart_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("添加失败");
		}
		return userTable.getU_id();
	}
	@Override
	public void addEmployee(Employee emp) {
		manageDao.addEmployee(emp);
	}

}
