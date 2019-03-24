package com.zs.tools;

import java.text.DecimalFormat;
import java.util.Date;

import com.google.gson.Gson;
import com.zs.entity.other.Result;

public class Test {

	public static void main(String[] args) {
		/*Date start=new Date(2017-1900, 0, 0,23,59,59);
		System.out.println(start.toLocaleString());
		DecimalFormat df = new DecimalFormat("#.00");  
        System.out.println(df.format(2.256));  */
		String str="{'result':'error','code':'11'}";
		Gson gson=new Gson();
		Result<Object> result=gson.fromJson(str, Result.class);
		System.out.println(result);
		System.out.println(result.getCode());
		
	}

}
