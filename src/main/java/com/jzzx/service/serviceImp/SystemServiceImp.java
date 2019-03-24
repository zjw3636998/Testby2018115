package com.jzzx.service.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jzzx.bean.Employee;
import com.jzzx.bean.Permission;
import com.jzzx.bean.RoleTable;
import com.jzzx.bean.UserTable;
import com.jzzx.bean.Visited;
import com.jzzx.bean.XcxAccess;
import com.jzzx.dao.SystemDao;
import com.jzzx.service.SystemService;
@Service("SystemService")
public class SystemServiceImp implements SystemService {
	private SystemDao systemDao;
	@Autowired
	public void setSystemDao(SystemDao systemDao) {
		this.systemDao = systemDao;
	}
	@Override
	public UserTable checkLogin(String userName, String password) {
		return systemDao.checkLogin(userName,password);
	}
	@Override
	public void addNewsLogin(int u_id, String dataFormat) {
		systemDao.addNewsLogin(u_id,dataFormat);
	}
	@Override
	public List<Permission> selectPermission(int u_id) {
		return systemDao.selectPermission(u_id);
	}
	@Override
	public List<RoleTable> selectRole() {
		return systemDao.selectRole();
	}
	@Override
	public List<Permission> permissionByRole(int rid) {
		return systemDao.permissionByRole(rid);
	}
	@Override
	public List<Permission> addRolesPermission(int rid) {
		return systemDao.queryAllNotPer(rid);
	}
	@Override
	public void addPerByrole(int perId, int roleId) {
		systemDao.addPerByrole(perId,roleId);
		
	}
	@Override
	public void deletePerByRole(int perId, int roleId) {
		systemDao.deletePerByRole(perId,roleId);
	}
	@Override
	public void deleleRoleById(int delRole_id) {
		systemDao.deleleRoleById(delRole_id);
		systemDao.deleteRole_perById(delRole_id);
	}
	@Override
	public List<Permission> searchAllPermisson() {
		return systemDao.searchAllPermisson();
	}
	@Override
	public int addRoles(String roleName, String roleDescript) {
		systemDao.addRoles(roleName,roleDescript);
		return systemDao.searchRoleId(roleName);
	}
	@Override
	public void addPerRole(int perId, int roleId) {
		systemDao.addPerByrole(perId, roleId);
	}
	@Override
	public Employee selEmployeeById(int uid) {
		return systemDao.selEmployeeById(uid);
	}
	@Override
	public void updEmployee(String username, String phone, int uid) {
		systemDao.updEmployee(username,phone,uid);
		
	}
	@Override
	public void updPassword(int u_id, String newp) {
		systemDao.updPassword(u_id,newp);
	}
	@Override
	public List<Visited> selVisited() {
		return systemDao.selVisited();
	}
	@Override
	public List<XcxAccess> selXcxAccess() {
		return systemDao.selXcxAccess();
	}
	@Override
	public int selOrderCount() {
		return systemDao.selOrderCount();
	}
	@Override
	public int selOrderPayCount() {
		return systemDao.selOrderPayCount();
	}
	@Override
	public int selOrderDeal() {
		return systemDao.selOrderDeal();
	}
	@Override
	public int selReview() {
		return systemDao.selReview();
	}
}
