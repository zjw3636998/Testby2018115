package com.zs.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.entity.QuotaCoreData;
import com.zs.entity.Users;
import com.zs.service.QuotaCoreDataSer;
import com.zs.service.UserSer;

@Controller
public class QuotaCoreCon {

	@Resource
	private QuotaCoreDataSer quotaSer;
	
	
	@RequestMapping("/quotaCoreData")
	public String gotoQuery(Map<String, Object> map) {
		return "/quota/quotaCore";
	}
	
	@RequestMapping("/quotaCoreData/{id}")
	public String gotoQuery(@PathVariable("id")String id) {
		return "/quota/quotaCoreEdit";
	}
}
