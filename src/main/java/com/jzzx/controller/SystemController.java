package com.jzzx.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jzzx.bean.Employee;
import com.jzzx.bean.Permission;
import com.jzzx.bean.RoleTable;
import com.jzzx.bean.UserTable;
import com.jzzx.bean.Visited;
import com.jzzx.bean.XcxAccess;
import com.jzzx.service.SystemService;
import com.jzzx.util.RandomUtil;
/**
 * 系统管理类
 * @author yyq
 *'============================================================================
 *'loginSystem 验证账号
 *'indexView 查询用户ID对应全部权限
 *'selectRole 查询角色
 *'permissionByRole 查询角色对应全部权限
 *'addPerView 查询全部未添加权限
 *'addPeimissionByRoles 添加单个角色权限
 *'deletePermissionByRole 删除单个角色权限
 *'deleleRoleById 删除角色
 *'addRolesView 添加角色（查询所有权限）
 *'addRoles 添加角色及权限(批量)
 *'updPassword 修改密码
 *'selEmployee 查询员工
 *;updEmployee 修改员工昵称及电话
 *'exitSystem 退出系统清除session和cookie
 *'selVisited 查询访问次数
 *'============================================================================
 */
@Controller
public class SystemController {
	SystemService systemService;
	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	/**
	 * @param userName(String) password(String)
	 * @return userTable<UserTable>
	 * */
	@RequestMapping(value="/loginSystem.do",method = RequestMethod.POST)
	public String loginSystem(String userName,String password,HttpSession session){
		UserTable userTable=systemService.checkLogin(userName,password);
		if(userTable!=null){
			Employee employee=systemService.selEmployeeById(userTable.getU_id());
			session.setAttribute("employee", employee);
			session.setAttribute("userTable",userTable);
			systemService.addNewsLogin(userTable.getU_id(),RandomUtil.getDataFormat());
			return "indexView.do";
		}else{
			return "";
		}
	}
	/**
	 * @param 
	 * @return list<Permission>
	 * */
	@RequestMapping("/indexView.do")
	public String indexView(Model model,HttpSession session){
		UserTable userTable=(UserTable)session.getAttribute("userTable");
		List<Permission> list=systemService.selectPermission(userTable.getU_id());
		session.setAttribute("permission", list);
		model.addAttribute("perList",list);
		return "index.jsp";
	}
	/**
	 * @param 
	 * @return list<RoleTable> 
	 * */
	@RequestMapping("/selRole.do")
	public String selectRole(Model model){
		List<RoleTable> roleTable =systemService.selectRole();
		model.addAttribute("roleList",roleTable);
		return "pages/permission/permission.jsp";
	}
	/**
	 * @param roleId(String)
	 * @return perList<Permission>
	 * @return roleId<String> 
	 * */
	@RequestMapping("/selPerByrole.do")
	public String permissionByRole(Model model,String roleId){
		int rid=0;
		if(roleId != null && !"".equals(roleId)){
			rid=Integer.parseInt(roleId);
		}
		List<Permission> list=systemService.permissionByRole(rid);
		model.addAttribute("perList", list);
		model.addAttribute("roleId",roleId);
		return "";
	}
	/**
	 * @param role_id(String) per_id(String)
	 * @return 
	 * */
	@RequestMapping("/deletePer.do")
	public String deletePermissionByRole(Model model,String role_id,String per_id){
		int perId=Integer.parseInt(per_id);
		int roleId=Integer.parseInt(role_id);
		systemService.deletePerByRole(perId,roleId);
		return "redirect:selPerByrole.do?roleId="+roleId;
	}
	/**
	 * @param roleId(String)
	 * @return list<Permission>
	 * */
	@RequestMapping("/addPerView.do")
	public String addPerView(Model model,String roleId){
		int rid=0;
		if(roleId != null && !"".equals(roleId)){
			rid=Integer.parseInt(roleId);
		}
		List<Permission> list=systemService.addRolesPermission(rid);
		model.addAttribute("perList", list);
		return "";
	}
	/**
	 * @param role_id(String) per_id(String)
	 * @return 
	 * */
	@RequestMapping("/addPer.do")
	public String addPeimissionByRoles(Model model,String role_id,String per_id){
		int perId=Integer.parseInt(per_id);
		int roleId=Integer.parseInt(role_id);
		systemService.addPerByrole(perId,roleId);
		return "redirect:addPerView.do?roleId="+role_id;
	}
	/**
	 * @param roleId(String)
	 * @return
	 * */
	@RequestMapping("/deleteRole.do")
	public String deleleRoleById(String roleId){
		int delRole_id=Integer.parseInt(roleId);
		systemService.deleleRoleById(delRole_id);
		return "selRole.do";
	}
	/**
	 * @param
	 * @return list<permission>
	 * */
	@RequestMapping("/addRolesView.do")
	public String addRolesView(Model model){
		List<Permission> list=systemService.searchAllPermisson();
		model.addAttribute("perList",list);
		return "pages/permission/addRole.jsp";
	}
	/**
	 * @param roleName(String) perList(String) roleDescript(String)
	 * @return 
	 * */
	@RequestMapping("/addRoles.do")
	public String addRoles(String roleName,String perList,String roleDescript){
		int addRole_id=systemService.addRoles(roleName,roleDescript);//添加角色
		String[] addPer_id=perList.split(",");
		for (String per_id : addPer_id) {
			int perId=Integer.parseInt(per_id);
			systemService.addPerRole(perId, addRole_id);
		}
		return "selRole.do";
	}
	/**
	 * @param uid(String) newp(String)
	 * @return jsonObject(JSONObject)
	 * */
	@ResponseBody
	@RequestMapping("/updPassword.do")
	public JSONObject updPassword(String uid,String newp,HttpSession session){
		JSONObject jsonObject=new JSONObject();
		UserTable ut=new UserTable();
		try {
			int u_id=0;
			if(uid != null && !"".equals(uid)){
				u_id=Integer.parseInt(uid);
			}else{
				ut=(UserTable) session.getAttribute("userTable");
				u_id=ut.getU_id();
			}
			systemService.updPassword(u_id,newp);
			ut.setU_password(newp);
			jsonObject.put("success", 200);
		} catch (Exception e) {
			jsonObject.put("success", 400);
		}
		System.out.println(jsonObject);
		return jsonObject;
	}
	/**
	 *@param 
	 *@return employee<Employee>
	 * */
	@RequestMapping("/exitSystem.do")
	public String exitSystem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
        session.removeAttribute("userTable");
		return "redirect:login.html";
	}
	@RequestMapping("/selEmployee.do")
	public String selEmployee(HttpSession session,Model model){
		try {
			UserTable ut=(UserTable) session.getAttribute("userTable");
			int uid=ut.getU_id();
			Employee emp=systemService.selEmployeeById(uid);
			model.addAttribute("employee", emp);
			return "pages/personal/personal.jsp";
		} catch (Exception e) {
			return "redirect:login.html";
		}
		
	}
	/**
	 * @param username<String>,phone<String>
	 * @return jsonObject<JSONObject>
	 * */
	@RequestMapping(value="/updEmp.do",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updEmployee(String username,String phone,HttpSession session){
		JSONObject jsonObject=new JSONObject();
		try {
			UserTable ut=(UserTable) session.getAttribute("userTable");
			int uid=ut.getU_id();
			systemService.updEmployee(username, phone, uid);
			ut.setU_name(username);
			ut.setU_phone(phone);
			jsonObject.put("success", 200);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("success", 400);
		}
		return jsonObject; 
	}
	@RequestMapping(value="/selVisited.do")
	@ResponseBody
	public JSONObject selVisited(HttpSession session){
		JSONObject jsonObject=new JSONObject();
		try {
			List<Visited> list=systemService.selVisited();//公众号及小程序总访问量
			jsonObject.put("visitedCount", list);
			List<XcxAccess> xcxList=systemService.selXcxAccess();//小程序阶段用户访问量
			jsonObject.put("xcxCount", xcxList);
			int orderCount=systemService.selOrderCount();//订单总数
			jsonObject.put("orderCount", orderCount);
			int orderPayCount=systemService.selOrderPayCount();//订单总价
			jsonObject.put("orderPayCount",orderPayCount);
			int orderDeal=systemService.selOrderDeal();//待处理数量
			jsonObject.put("orderDeal",orderDeal);
			int review=systemService.selReview();//待审核数量
			jsonObject.put("review",review);
			//判断是否拥有审核权限
			List<Permission> perList=(List<Permission>) session.getAttribute("permission");
			int getPermission=0;
			for (int i = 0; i < perList.size(); i++) {
				if(perList.get(i).getPer_id()==19){
					getPermission=1;
					break;
				}
			}
			jsonObject.put("getPermission", getPermission);
			
			jsonObject.put("success", 200);
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.put("success", 400);
		}
		System.out.println(jsonObject);
		return jsonObject;
	}
}
