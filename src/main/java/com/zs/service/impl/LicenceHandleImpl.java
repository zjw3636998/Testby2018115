package com.zs.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zs.dao.LicenceMapper;
import com.zs.entity.Licence;
import com.zs.service.LicenceHandle;

@Service("licenceHandle")
public class LicenceHandleImpl implements LicenceHandle{

	private Logger log=Logger.getLogger(LicenceHandleImpl.class);
	
	@Resource
	private LicenceMapper licenceMapper;
	
	public int validate(String lId) {
		Licence licence=licenceMapper.selectByPrimaryKey(lId);
		if (licence==null) {
			return 1;//证书不存在
		}else {
			Date date=new Date();
			if (date.after(licence.getlEnd())) {
				return 2;//超时
			}else {
				/*更新超时时间,这里定为无操作2小时候失效*/
				date.setHours(date.getHours()+2);
				licence.setlEnd(date);
				if(licenceMapper.updateByPrimaryKeySelective(licence)<=0){
					log.error("更新证书最后超时时间出错。证书id为："+lId+",最后超时时间为："+date.toLocaleString());
				}
				return 0;//验证通过
			}
		}
	}

	public Licence get(String lId) {
		return licenceMapper.selectByPrimaryKey(lId);
	}

}
