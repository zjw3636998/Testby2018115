package com.zs.controller.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.entity.QuotaCoreData;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;

@RestController
@RequestMapping("/api/quotaCoreInfo")
public class QuotaCoreInfoConR implements BaseRestController<QuotaCoreData>{

	public EasyUIPage query(EasyUIAccept<QuotaCoreData> accept) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result<QuotaCoreData> get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result<Integer> post(QuotaCoreData obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result<Integer> put(QuotaCoreData obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Result<Integer> delete(String id) {
		// TODO Auto-generated method stub
		return null;
	} 

	
}
