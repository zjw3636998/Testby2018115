package com.zs.controller.rest;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.zs.entity.QuotaCoreData;
import com.zs.entity.Users;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.service.QuotaCoreDataSer;
import com.zs.service.QuotaCoreHandle;
import com.zs.tools.ColumnName;

@RestController
@RequestMapping("/api")
public class QuotaCoreDataConR implements BaseRestController<QuotaCoreData>{

	@Resource
	private QuotaCoreDataSer coreDataSer;
	@Resource
	private QuotaCoreHandle coreHandle;
	
	private Logger log=Logger.getLogger(QuotaCoreDataConR.class);
	
	
	@RequestMapping(value="/quotaCoreData",method=RequestMethod.GET)
	public EasyUIPage query(EasyUIAccept<QuotaCoreData> accept) {
		EasyUIPage uiPage=coreDataSer.fenye(Integer.valueOf((String)accept.getOpt().get("year")), 
				ColumnName.transToUnderline(accept.getSort()), 
				accept.getOrder(), accept.getPage(), accept.getRows());
		return uiPage;
	}
	
	@RequestMapping(value="/quotaCoreData/{id}",method=RequestMethod.GET)
	public Result<QuotaCoreData> get(@PathVariable("id") String id){
		QuotaCoreData qcd = coreDataSer.get(id);
		return new Result<QuotaCoreData>("success", 0, qcd);
	}
	

	public Result<Integer> post(QuotaCoreData obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value="/quotaCoreData/{id}",method=RequestMethod.PUT)
	public Result<Integer> put(QuotaCoreData obj) {
		Integer i=0;
		if (obj!=null) {
			i=coreDataSer.update(obj);
		}
		return new Result<Integer>("success", 0, i);
	}

	public Result<Integer> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	} 
	
	@RequestMapping(value="/quotaCoreData/{id}/reckon",method=RequestMethod.PUT)
	public Result<Integer> reckon(@PathVariable("id")String id) {
		Integer i=coreHandle.reckonRJWH(id);
		return new Result<Integer>("success", 0, i);
	}
}
