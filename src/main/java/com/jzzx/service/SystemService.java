package com.jzzx.service;

import java.util.List;

import com.jzzx.bean.Employee;
import com.jzzx.bean.Permission;
import com.jzzx.bean.RoleTable;
import com.jzzx.bean.UserTable;
import com.jzzx.bean.Visited;
import com.jzzx.bean.XcxAccess;

public interface SystemService {

	UserTable checkLogin(String userName, String password);
	
	void addNewsLogin(int u_id, String dataFormat);

	List<Permission> selectPermission(int u_id);

	List<RoleTable> selectRole();

	List<Permission> permissionByRole(int rid);

	List<Permission> addRolesPermission(int rid);

	void addPerByrole(int perId, int roleId);

	void deletePerByRole(int perId, int roleId);

	void deleleRoleById(int delRole_id);

	List<Permission> searchAllPermisson();

	int addRoles(String roleName, String roleDescript);

	void addPerRole(int perId, int addRole_id);

	Employee selEmployeeById(int uid);

	void updEmployee(String username, String phone, int uid);

	void updPassword(int u_id, String newp);

	List<Visited> selVisited();

	List<XcxAccess> selXcxAccess();

	int selOrderCount();

	int selOrderPayCount();

	int selOrderDeal();

	int selReview();



}
