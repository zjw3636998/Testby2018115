package com.jzzx.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.jzzx.bean.Employee;
import com.jzzx.bean.FileTable;
import com.jzzx.bean.MeetingTable;
import com.jzzx.bean.RoleTable;
import com.jzzx.bean.UserTable;
import com.jzzx.service.ManageService;
import com.jzzx.service.SystemService;
import com.jzzx.util.DealFile;
import com.jzzx.util.PageUtil;
import com.jzzx.util.RandomUtil;


/**
 * 公司职能管理类
 * 
 * @author yyq
 *'============================================================================
 *'uploadFile 上传文件到服务器
 *'selectFile 查询文件
 *'downloadFile 下载文件
 *'deleteFile 删除文件
 *'uploadMeeting 上传会议记录
 *'selMeeting 查询会议记录
 *'deleteMeeting 删除会议记录
 *'selectEmployee 查询员工
 *'dimissionEmp 员工离职
 *'addEmployeeView 添加员工页面渲染
 *'addEmployee  添加员工
 *'============================================================================
 */
@Controller
public class ManageController {
	private String rootPath="D:/testPath/";//存放文件根目录
	private String time;
	private ManageService manageService;
	@Autowired
	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
	}
	SystemService systemService;
	@Autowired
	public void setSystemService(SystemService systemService) {
		this.systemService = systemService;
	}
	/**
	 * @param file(File) fileName(String) fileType(String)
	 * @return
	 */
	@RequestMapping(value="/upload.do",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject uploadFile(HttpServletRequest request, @RequestParam(value="file",required=false)MultipartFile file,
		String fileName,String fileType,HttpSession session) throws Exception {
		JSONObject jsonObject=new JSONObject();
		try {
			String originalFilename = file.getOriginalFilename(); //得到文件名
			String prefix=originalFilename.substring(originalFilename.lastIndexOf(".")+1);//得到文件后缀名
			String randomFileName=RandomUtil.getRandomFileName();//本地文件名称
			String path=rootPath+randomFileName+"."+prefix;//本地路径
			UserTable userTable=(UserTable) session.getAttribute("userTable");
			String userName=userTable.getU_name();
			time=RandomUtil.getDataFormat();//上传时间
			File desFile = new File(path);
			if(!desFile.getParentFile().exists()){//是否存在
		       desFile.mkdirs();
			}
			file.transferTo(desFile);//保存文件
			FileTable fileTable=new FileTable(fileName,Integer.parseInt(fileType),path,userName,time);
			manageService.uploadFile(fileTable);
			jsonObject.put("success", 200);
		} catch (Exception e) {
			jsonObject.put("success",400);
		}
		return jsonObject;
	}
	/**
	 * @param pageNum(String) searchContent(String) searchType(String)
	 * @return list<FileTable>
	 * */
	@RequestMapping(value="/selFile.do")
	public String selectFile(Model model,String fileType,String pageNum,
			String searchContent,String searchType) throws UnsupportedEncodingException{
		int f_type=0;
		try{
			//如果搜索内容不为null解码前台encodeURI(encodeURI(String))
			if(searchContent != null && !"".equals(searchContent)){
				searchContent=java.net.URLDecoder.decode(searchContent, "utf-8");
			}
			f_type=Integer.parseInt(fileType);//访问文件类型 1为微信公众号文章2为公司文件
			int currentPage = 1;//第一页
			if (pageNum != null && !"".equals(pageNum)) {  
	            currentPage = Integer.parseInt(pageNum);  
	        } 
			 PageUtil pageUtil = new PageUtil(10, manageService.fileCount(f_type,searchType,searchContent), currentPage);  
		     List<FileTable> list = manageService.getPageFile(pageUtil.getFromIndex(), pageUtil.getPageSize(),f_type,searchType,searchContent);
		     
		     model.addAttribute("fileList",list);
		     model.addAttribute("currentPage",currentPage);
		     model.addAttribute("totalPage",pageUtil.getPageCount());
		}catch(Exception e){
			e.printStackTrace();
		}
		if(f_type==1){
			return "pages/fileTable/wechatArticle.jsp";	
		}else{
			return "pages/fileTable/companyFile.jsp";	
		}
		
	}
	/**
	 * @param fileUrl(String)
	 * @return 
	 * */
	@RequestMapping(value="/downloadFile.do",method = RequestMethod.POST)
	public String downloadFile(String fileUrl,HttpServletRequest request,
            HttpServletResponse response) throws IOException{
		InputStream in = new FileInputStream(fileUrl);
		fileUrl=URLEncoder.encode(fileUrl, "UTF-8");
		response.setHeader("Content-Disposition", "attachment;filename="+fileUrl);   
		response.setContentLength(in.available());
		OutputStream out = response.getOutputStream();
	    byte[] b = new byte[1024];
	    int len = 0;
	    while((len = in.read(b))!=-1){
	      out.write(b, 0, len);
	    }
	    out.flush();
	    out.close();
	    in.close();
		return null;
	}
	/**
	 *@param fileUrl(String)
	 *@return JSONobject
	 * */
	@RequestMapping(value="/deleteFile.do")
	public String deleteFile(String fileUrl,String fileType){
		try {
			manageService.deleteFile(fileUrl);
			if(DealFile.booleanDeleteFolder(fileUrl)){
				System.out.println("删除成功");
			}else{
				System.out.println("删除失败");
			}
		} catch (Exception e) {
			
		}
		String url="selFile.do";
		return url;
	}
	/**
	 * @param m_type(String),m_title(String),m_content(String),m_begin(String),m_end(String)
	 * @return 
	 * */
	@RequestMapping(value="/addMeeting.do",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject uploadMeeting(String m_type,String m_title,String m_content,String m_time,String m_date,HttpSession session){
		JSONObject jsonObject=new JSONObject();
		try {
			time=RandomUtil.getDataFormat();
			int mType=Integer.parseInt(m_type);
			UserTable userTable=(UserTable) session.getAttribute("userTable");//上传人
			String m_recorder=userTable.getU_name();
			String[] timeSplit=m_time.split("-");
			String m_begin=m_date+" "+timeSplit[0];
			String m_end=m_date+timeSplit[1];
			MeetingTable meetingTable=new MeetingTable(mType,m_title,m_content,m_begin,m_end,m_recorder,time);
			manageService.uploadMeeting(meetingTable);
			jsonObject.put("success", 200);
		} catch (Exception e) {
			jsonObject.put("success", 400);
		}
		
		return jsonObject;
	}
	/**
	 * @param pageNum(String) searchContent(String) searchType(String)
	 * @return list<MeetingTable>
	 * */
	@RequestMapping(value="/selMeeting.do")
	public String selMeeting(Model model,String pageNum,
			String searchContent,String searchType){
		try{
			//如果搜索内容不为null解码前台encodeURI(encodeURI(String))
			if(searchContent != null && !"".equals(searchContent)){
				searchContent=java.net.URLDecoder.decode(searchContent, "utf-8");
			}
			int currentPage = 1;//第一页
			if (pageNum != null && !"".equals(pageNum)) {  
	            currentPage = Integer.parseInt(pageNum);  
	        } 
			 PageUtil pageUtil = new PageUtil(10, manageService.seletMeetCount(searchType,searchContent), currentPage);  
		     List<MeetingTable> list = manageService.getPageMeeting(pageUtil.getFromIndex(), pageUtil.getPageSize(),searchType,searchContent);
		     model.addAttribute("meetingList",list);
		     model.addAttribute("currentPage",currentPage);
		     model.addAttribute("totalPage",pageUtil.getPageCount());
		}catch(Exception e){
			e.printStackTrace();
		}
		return "pages/meet/meet.jsp";
	}
	/**
	 * @param m_id(String)
	 * @return
	 * */
	@RequestMapping(value="/deleteMeeting.do")
	public String deleteMeeting(String m_id){
		if(m_id!=null&&!"".equals(m_id)){
			int mid=Integer.parseInt(m_id);
			manageService.delMeeting(mid);
		}
		return "selMeeting.do";
	}
	/**
	 * @param m_id(String)
	 * @return content(String)
	 * */
	@RequestMapping(value="/meetingContent.do")
	public String meetingContent(String m_id,Model model){
		if(m_id!=null&&!"".equals(m_id)){
			int mid=Integer.parseInt(m_id);
			String content=manageService.meetingContent(mid);
			model.addAttribute("content", content);
		}
		return "pages/meet/meetContent.jsp";
	}
	/**
	 * @param pageNum(String) searchContent(String) searchType(String)
	 * @return roleList<RoleTable> employeeList<Employee> 
	 * */
	@RequestMapping(value="/selEmp.do")
	public String selectEmployee(Model model,String pageNum,
			String searchContent,String searchType) throws UnsupportedEncodingException{
		if(searchContent != null && !"".equals(searchContent)){
			searchContent=java.net.URLDecoder.decode(searchContent, "utf-8");
		}
		int currentPage = 1;//第一页
		if (pageNum != null && !"".equals(pageNum)) {  
            currentPage = Integer.parseInt(pageNum);  
        }
		PageUtil pageUtil = new PageUtil(10, manageService.selectEmpCount(searchType,searchContent), currentPage);  
	    List<Employee> list = manageService.getPageEmployee(pageUtil.getFromIndex(), pageUtil.getPageSize(),searchType,searchContent);
	    List<RoleTable> roleTable =systemService.selectRole();
	    model.addAttribute("roleList", roleTable);
	    model.addAttribute("employeeList",list);	
	    model.addAttribute("currentPage",currentPage);
	    model.addAttribute("totalPage",pageUtil.getPageCount());
		return "pages/employee/employee.jsp";
	}
	/**
	 * @param userId(String)
	 * @return 
	 * */
	@RequestMapping(value="/dimission.do")
	public String dimissionEmp(String userId){
		if(userId!=null&&!"".equals(userId)){
			int user_id=Integer.parseInt(userId);
			String time=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			manageService.dimissionEmp(user_id,time);
		}
		return "selEmp.do";
	}
	/**
	 * @param userId(String)
	 * @return userTable<UserTable>
	 * */
	@RequestMapping(value="/moreUserMessage.do")
	public String userMessage(String userId,Model model){
		if(userId!=null&&!"".equals(userId)){
			int user_id=Integer.parseInt(userId);
			UserTable userTable=manageService.userMessage(user_id);
			model.addAttribute("userTable", userTable);
		}
		return "pages/employee/moreUserMessage.jsp";
	}
	/**
	 * @param
	 * @return roleList<RoleTable>
	 * */
	@RequestMapping(value="/addEmployeeView.do")
	public String addEmployeeView(Model model){
		List<RoleTable> roleList=systemService.selectRole();
		model.addAttribute("roleList",roleList);
		return "pages/employee/addEmployee.jsp";
	}
	/**
	 * @param empName(String) empPhone(String) education(String) t_level(String) m_department(String) m_entry(String) m_regular(String) t_account(String) 
	 * @return jsonObject<JSONObject>
	 * */
	@RequestMapping(value="/addEmployee.do",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject addEmployee(String empName,String empPhone,String education,String t_level,
			String m_department,String m_entry,String m_regular,String t_account,HttpSession session){
		JSONObject jsonObject=new JSONObject();
		String [] arr = m_department.split("-");
		int depart_id=Integer.parseInt(arr[0]);//角色ID
		String depart_name=arr[1];//角色名称
		try {
			UserTable userTable=new UserTable();
			userTable.setU_account(t_account);//账号
			userTable.setU_createtime(RandomUtil.getDataFormat());//注册时间
			userTable.setU_headimg("");//头像
			userTable.setU_name(empName);//昵称，默认姓名
			userTable.setU_phone(empPhone);//电话
			userTable.setU_password("123456");//初始密码.
			int u_id=manageService.addAccount(userTable,depart_id);
			Employee emp=new Employee();
			emp.setUser_id(u_id);//员工对应账号ID
			emp.setEmpName(empName);//员工名字
			emp.setEntry_time(m_entry);//入职时间
			emp.setRegular_time(m_regular);//转正时间
			emp.setEducation(education); //学历
			emp.setDepartment(depart_name);//部门
			emp.setLevel(Integer.parseInt(t_level));//等级sd
			Employee employee=(Employee) session.getAttribute("employee");
			String emp_name=employee.getEmpName();//修改人
			emp.setUpd_time(RandomUtil.getDataFormat());//修改时间
			emp.setUpd_emp(emp_name);
			manageService.addEmployee(emp);
			jsonObject.put("success", 200);
		} catch (Exception e) {
			jsonObject.put("success", 400);
			e.printStackTrace();
		}
		return jsonObject;
	}
}
