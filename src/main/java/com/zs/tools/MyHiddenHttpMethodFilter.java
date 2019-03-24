package com.zs.tools;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.filter.HiddenHttpMethodFilter;


/**
 *
 * 处理form表单头的过滤器，
 * 如果表单有_header字段，可以自动将该字段转为request的header头信息（增加一条头）
 * @author it023
 */
public class MyHiddenHttpMethodFilter extends HiddenHttpMethodFilter{

	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String header=request.getParameter("_header");
		if (header!=null && !header.trim().equals("")) {
			HttpServletRequest wrapper = new HttpHeaderRequestWrapper(request,header);
			super.doFilterInternal(wrapper, response, filterChain);
		}else {
			super.doFilterInternal(request, response, filterChain);
		}
	}
	
	private static class HttpHeaderRequestWrapper extends HttpServletRequestWrapper{

		private final String header;
		
		public HttpHeaderRequestWrapper(HttpServletRequest request,String licence) {
			super(request);
			this.header=licence;
		}

		@Override
		public String getHeader(String name) {
			if (name!=null && name.equals("licence") && super.getHeader("licence")==null) {
				return header;
			}else {
				return super.getHeader(name);
			}
		}
		
	}
	
	
}
