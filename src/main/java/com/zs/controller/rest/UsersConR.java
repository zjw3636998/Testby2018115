  package com.zs.controller.rest;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.zs.entity.Users;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.UserSer;
import com.zs.tools.ColumnName;
import com.zs.tools.NameOfDate;

@RestController
@RequestMapping("/api")
public class UsersConR implements BaseRestController<Users>{
	@Resource
	private UserSer userSer;
	
	private Logger log=Logger.getLogger(UsersConR.class);
	
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public EasyUIPage query(EasyUIAccept<Users> accept) {
		EasyUIPage uiPage=userSer.fenye(accept.getPage(), 
				accept.getRows(), 
				ColumnName.transToUnderline(accept.getSort()), 
				accept.getOrder());
		return uiPage;
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.GET)
	public Result<Users> get(@PathVariable("id")String id) {
		Users user=userSer.get(id);
		return new Result<Users>("success", 0, user);
	}
	@RequestMapping(value="/users",method=RequestMethod.POST)
	public Result<Integer> post(Users obj) {
		log.info("-------------private Result<Integer> post(U-----------------");
		Integer i=0;
		if (obj!=null) {
			i=userSer.save(obj);
		}		
		return new Result<Integer>("success", 0, i);
	}

	@RequestMapping(value="/users/{id}",method=RequestMethod.PUT)
	public Result<Integer> put(Users obj) {
		log.info("---------private Result<Integer> put(---------");
		log.info(obj);
		Integer i=0;
		if (obj!=null) {
			i=userSer.update(obj);
		}
		return new Result<Integer>("success", 0, i); 
	}
	
	@RequestMapping(value="/users/{id}",method=RequestMethod.DELETE)
	public Result<Integer> delete(@PathVariable("id")String id) {
		Integer i=userSer.delete(id);
		return new Result<Integer>("success", 0, i);
	} 
	
	
}
