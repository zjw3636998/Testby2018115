package com.zs.interceptors;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.Gson;
import com.zs.entity.other.Result;
import com.zs.service.LicenceHandle;


/**
 * 证书拦截器，用于实现安全访问的目的
 * 所有的api访问均需检查是否有证书
 * @author it023
 */
public class LicenceInter extends HandlerInterceptorAdapter{

	private Logger log=Logger.getLogger(LicenceInter.class);
	@Resource
	private LicenceHandle licenceHandle;
	private Gson gson=new Gson();
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url=request.getRequestURI();
		log.info(url);
		if (url.contains("/api")) {
			String lId=request.getHeader("licence");
			log.info("--licence-->>"+lId);
			int result=licenceHandle.validate(lId);
			log.info("--result-->>"+result);
			if (result==0) {
				return super.preHandle(request, response, handler);
			}else {
				Result<Object> res=new Result<Object>("error", result, null);
				String str=gson.toJson(res);
				log.info(str);
				response.setCharacterEncoding("utf-8");
				response.getWriter().print(str);
				response.getWriter().flush();
				response.getWriter().close();
				return false;
			}
		}else {
			//尝试获取licence
			Object licenceId=request.getSession().getAttribute("licence");
			if (licenceId==null) {
				response.sendRedirect("http://172.16.1.241:8080/IT_BDM/");
				log.error("session已失效，自动跳转登录页面");
				return false;
			}else {
				return super.preHandle(request, response, handler);
			}
		}
		
	}

	
	
}
