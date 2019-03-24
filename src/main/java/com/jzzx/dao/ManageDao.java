package com.jzzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jzzx.bean.Employee;
import com.jzzx.bean.FileTable;
import com.jzzx.bean.MeetingTable;
import com.jzzx.bean.UserTable;

public interface ManageDao {

	void uploadFile(FileTable fileTable);

	int fileCount(@Param("f_type")int f_type, @Param("searchType")String searchType, @Param("searchContent")String searchContent);

	List<FileTable> getPageFile(@Param("fromIndex")int fromIndex, @Param("pageSize")int pageSize, 
			@Param("f_type")int f_type, @Param("searchType")String searchType, @Param("searchContent")String searchContent);

	void deleteFile(@Param("fileUrl")String fileUrl);

	void uploadMeeting(MeetingTable meetingTable);

	int seletMeetCount(@Param("searchType")String searchType, @Param("searchContent")String searchContent);

	List<MeetingTable> getPageMeeting(@Param("fromIndex")int fromIndex, @Param("pageSize")int pageSize,
			@Param("searchType")String searchType, @Param("searchContent")String searchContent);

	void delMeeting(@Param("mid")int mid);

	String meetingContent(@Param("mid")int mid);

	int selectEmpCount(@Param("searchType")String searchType, @Param("searchContent")String searchContent);

	List<Employee> getPageEmployee(@Param("fromIndex")int fromIndex, @Param("pageSize")int pageSize,
			@Param("searchType")String searchType, @Param("searchContent")String searchContent);

	void updEmployee(@Param("user_id")int user_id, @Param("time")String time);

	void updUser(@Param("user_id")int user_id, @Param("time")String time);

	void delRoleUser(@Param("user_id")int user_id);

	UserTable userMessage(@Param("user_id")int user_id);

	int addAccount(UserTable userTable);
	void addEmpRole(@Param("u_id")int i, @Param("depart_id")int depart_id);
	
	void addEmployee(Employee emp);


	

}
