package com.jzzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jzzx.bean.Employee;
import com.jzzx.bean.Permission;
import com.jzzx.bean.RoleTable;
import com.jzzx.bean.UserTable;
import com.jzzx.bean.Visited;
import com.jzzx.bean.XcxAccess;

public interface SystemDao {

	UserTable checkLogin(@Param("userName")String userName, @Param("password")String password);
	void addNewsLogin(@Param("u_id")int u_id, @Param("dataFormat")String dataFormat);
	
	List<Permission> selectPermission(@Param("u_id")int u_id);

	List<RoleTable> selectRole();

	List<Permission> permissionByRole(@Param("rid")int rid);

	List<Permission> queryAllNotPer(@Param("rid")int rid);

	void addPerByrole(@Param("perId")int perId,@Param("roleId")int roleId);

	void deletePerByRole(@Param("perId")int perId, @Param("roleId")int roleId);

	void deleleRoleById(@Param("delRole_id")int delRole_id);
	void deleteRole_perById(@Param("delRole_id")int delRole_id);

	List<Permission> searchAllPermisson();
	/*添加角色并返回Roleid*/
	void addRoles(@Param("roleName")String roleName, @Param("roleDescript")String roleDescript);
	int searchRoleId(@Param("roleName")String roleName);
	
	Employee selEmployeeById(@Param("uid")int uid);
	
	void updEmployee(@Param("username")String username, @Param("phone")String phone, @Param("uid")int uid);
	void updPassword(@Param("u_id")int u_id, @Param("newp")String newp);
	
	List<Visited> selVisited();
	List<XcxAccess> selXcxAccess();
	int selOrderCount();
	int selOrderPayCount();
	int selOrderDeal();
	int selReview();
	


}
