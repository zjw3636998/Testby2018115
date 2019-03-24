package com.zs.service;

import org.springframework.stereotype.Service;

import com.zs.entity.Licence;

public interface LicenceHandle {
	
	/**
	 * 
	 * 验证证书
	 * @return 错误码（0为正确码，越大越严重）
	 */
	public int validate(String lId);
	
	
	public Licence get(String lId);
}
