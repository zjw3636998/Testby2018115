package com.zs.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zs.entity.Users;
import com.zs.service.UserSer;

@Controller
public class UsersCon {

	@Resource
	private UserSer userSer;
	
	
	@RequestMapping("/users/{id}")
	public String gotoQuery(Map<String, Object> map,@PathVariable("id")String id) {
		Users user=userSer.get(id);
		map.put("user", user);
		System.out.println(user);
		return "/views/success";
	}
	
	@RequestMapping("/users")
	public String gotoQuery() {
		ModelAndView view=new ModelAndView();
		return "/quota/users";
	}
}
