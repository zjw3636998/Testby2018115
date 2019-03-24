package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.UsersMapper;
import com.zs.entity.Users;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.UserSer;

@Service("userSer")
public class UserSerImpl implements UserSer{

	@Resource
	private UsersMapper usersMapper;
	
	public Users get(String id) {
		return usersMapper.selectByPrimaryKey(id);
	}

	public List<Users> queryFenye(Integer start,Integer size,String sort,String order) {
		return usersMapper.queryFenye(start, size,sort,order);
	}

	public int save(Users user) {
		return usersMapper.insertSelective(user);
	}

	public int update(Users user) {
		return usersMapper.updateByPrimaryKeySelective(user);
	}

	public int delete(String uNum) {
		return usersMapper.deleteByPrimaryKey(uNum);
	}

	public int getCount() {
		return usersMapper.getCount();
	}

	public EasyUIPage fenye(Integer start, Integer size, String sort, String order) {
		if (start!=null && size!=null) {
			start=(start-1)*size;
		}
		List list=usersMapper.queryFenye(start, size, sort, order);
		int total=usersMapper.getCount();
		EasyUIPage uiPage=new EasyUIPage(total, list);
		return uiPage;
	}

}
