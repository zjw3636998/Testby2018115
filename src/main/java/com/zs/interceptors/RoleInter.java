package com.zs.interceptors;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.google.gson.Gson;
import com.zs.controller.rest.QuotaCoreDataConR;
import com.zs.entity.Licence;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.Result;
import com.zs.service.LicenceHandle;


/**
 * 权限拦截器，与IT_BDM对接，结果来自IT_BDM的权限拦截器
 * @author 
 */
public class RoleInter extends HandlerInterceptorAdapter{

	private Logger log=Logger.getLogger(RoleInter.class);
	@Resource
	private LicenceHandle licenceHandle;
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private Object hand;
	private Licence lic;
	private String url;
	private String methodname;
	private Class<?> classname;
	private Method method;
	
	private void init(HttpServletRequest request, HttpServletResponse response, Object handler){
		req=request;
		resp=response;
		hand=handler;
		String lId=request.getHeader("licence");
		lic=licenceHandle.get(lId);
		
		method=((HandlerMethod) handler).getMethod();
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("----------------------------------");
		url=request.getRequestURI();
		if (url.contains("/api")) {
			init(request, response, handler);
			Method me=QuotaCoreDataConR.class.getMethod("query", new Class[]{EasyUIAccept.class}); 
			if (me!=null && method.equals(me)) {
				return handleRole("4001");
			}else {
				return true;
			}
		}
		return true;
	}

	private boolean handleRole(String pId) throws IOException {
		String result=postForm("http://172.16.1.241:8080/IT_BDM/licence!licence",lic.getuNum(),pId);
		Gson gson=new Gson();
        Result ur=gson.fromJson(result, Result.class);
        if (ur!=null && ur.getResult().equals("success")) {
			return true;
		}else if(ur!=null){
			resp.setCharacterEncoding("utf-8");
			resp.getWriter().print(result);
			resp.getWriter().flush();
			resp.getWriter().close();
			return false;
		}else {
			log.error("错误");
			return false;
		}
	}
	
	/** 
     * post方式提交表单（模拟用户登录请求） 
     */  
    public String postForm(String url,String unum,String pname) {  
        // 创建默认的httpClient实例.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // 创建httppost    
        HttpPost httppost = new HttpPost(url);  
        // 创建参数队列    
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();  
        formparams.add(new BasicNameValuePair("u_num", unum));  
        formparams.add(new BasicNameValuePair("p_id", pname));  
        UrlEncodedFormEntity uefEntity;  
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {  
                	String content=EntityUtils.toString(entity, "UTF-8");
                    System.out.println("--------------------------------------");  
                    System.out.println("Response content: " + content);  
                    System.out.println("--------------------------------------");  
                    return content;
                }
            } finally {
                response.close();
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;
    }  
	
}
