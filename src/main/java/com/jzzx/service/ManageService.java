package com.jzzx.service;

import java.util.List;

import com.jzzx.bean.Employee;
import com.jzzx.bean.FileTable;
import com.jzzx.bean.MeetingTable;
import com.jzzx.bean.UserTable;

public interface ManageService {

	void uploadFile(FileTable fileTable);
	int fileCount(int f_type, String searchType, String searchContent);
	List<FileTable> getPageFile(int fromIndex, int pageSize, int f_type, String searchType, String searchContent);
	void deleteFile(String fileUrl);
	void uploadMeeting(MeetingTable meetingTable);
	int seletMeetCount(String searchType, String searchContent);
	List<MeetingTable> getPageMeeting(int fromIndex, int pageSize, String searchType, String searchContent);
	void delMeeting(int mid);
	String meetingContent(int mid);
	int selectEmpCount(String searchType, String searchContent);
	List<Employee> getPageEmployee(int fromIndex, int pageSize, String searchType, String searchContent);
	void dimissionEmp(int user_id, String time);
	UserTable userMessage(int user_id);
	int addAccount(UserTable userTable, int depart_id);
	void addEmployee(Employee emp);

}
