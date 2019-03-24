<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
		<meta charset="UTF-8">
		<title>员工信息注册</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" type="text/css" href="themes/css/reset.css">
	    <link rel="stylesheet" type="text/css" href="themes/plugs/layui/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="themes/css/weadmin.css">
		<link rel="stylesheet" href="themes/plugs/trumbowyg/design/css/trumbowyg.css">
		<script type="text/javascript" src="themes/plugs/jquery/jquery.min.js"></script>
	    <script type="text/javascript" src="themes/plugs/layui/layui/layui.js"></script>
	    <script type="text/javascript" src="themes/plugs/Layer/layer.js"></script>
	    <script type="text/javascript" src="themes/js/weadmin.js"></script>
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>
	<body>
		<div class="i-body">
			<form class="layui-form i-meet-form" id="formMes">
				<div class="layui-form-item i-form-item">	 
		            	<label for="userename" class="layui-form-label i-meet-label">
                  			<span class="i-red">*</span>员工姓名
              			</label>
              			<div class="layui-input-block i-input-block">
							<input type="text" name="empName" lay-verify="required" jq-error="请输入姓名"  autocomplete="off" class="layui-input " >
						</div>  
				</div>
				<div class="layui-form-item i-form-item">	 
		            	<label for="userename" class="layui-form-label i-meet-label">
                  			<span class="i-red">*</span>员工电话
              			</label>
              			<div class="layui-input-block i-input-block">
							<input type="text" name="empPhone" lay-verify="required" jq-error="请输入电话"  autocomplete="off" class="layui-input " >
						</div>  
				</div>
				<div class="layui-form-item i-form-item">
					<label for="username" class="layui-form-label i-meet-label i-label-f">
                  		<span class="i-red">*</span>学历
              		</label>
		            <div class="layui-input-inline i-meet-slect">
		                <select name="education">
		                    <option value="0">--请选择学历--</option>
		                    <option value="大专">大专</option>
		                    <option value="本科">本科</option>
		                    <option value="硕士">硕士</option>
		                    <option value="博士">博士</option>
		                </select>
              		</div>
				</div>
				<div class="layui-form-item i-form-item">
					<label for="username" class="layui-form-label i-meet-label i-label-f">
                  		<span class="i-red">*</span>员工评级
              		</label>
		            <div class="layui-input-inline i-meet-slect">
	                  <select name="t_level">
		                  <option value="0">--请选择职级--</option>
		                  <option value="1">一级</option>
		                  <option value="2">二级</option>
		                  <option value="3">三级</option>
	                  </select>
              		</div>
				</div>
				<div class="layui-form-item i-form-item">
					<label for="username" class="layui-form-label i-meet-label i-label-f">
                  		<span class="i-red">*</span>员工所属部门
              		</label>
		            <div class="layui-input-inline i-meet-slect">
	                  <select name="m_department">
	                    <option value="0">---请选择部门---</option>
	                    <c:forEach var="roleList" items="${requestScope['roleList']}">
	                    	<option value="${roleList['role_id']}-${roleList['role_name']}">${roleList['role_name']}</option>
	                    </c:forEach>
	                  </select>
              		</div>
				</div>
				<div class="layui-form-item i-form-item">	 
		            	 <label for="userename" class="layui-form-label i-meet-label">
                  			<span class="i-red">*</span>入职时间
              			</label>
     					<div class="layui-input-inline i-meet-input">
     					   <input type="text" class="layui-input" id="testdate1" placeholder="yyyy-MM-dd" name="m_entry">
     					</div>
				</div>
				<div class="layui-form-item i-form-item">	 
		            	 <label for="userename" class="layui-form-label i-meet-label">
                  			<span class="i-red">*</span>预计转正时间
              			</label>
     					<div class="layui-input-inline i-meet-input">
     					   <input type="text" class="layui-input" id="testdate2" placeholder="yyyy-MM-dd" name="m_regular">
     					</div>
				</div>
				<div class="layui-form-item i-form-item">	 
		            	 <label for="userename" class="layui-form-label i-meet-label">
                  			<span class="i-red">*</span>注册账号
              			</label>
              			<div class="layui-input-block i-input-block">
							<input type="text" name="t_account" lay-verify="required" jq-error="请输入账号"  autocomplete="off" class="layui-input " >
						</div>  
				</div>
				<div class="layui-form-item">
					<div class="meet-submint-btn">
		            	 	<button type=button class="sub-btn" onclick="subMessage()">提交</button>     
		            </div>
				</div>
				
			</form>
		</div>
		<script type="text/javascript">
		layui.use('laydate', function(){
  			var laydate = layui.laydate;
  			 laydate.render({
    			elem: '#testdate1'
  			});
  			 laydate.render({
     			elem: '#testdate2'
   			});
			  			 //时间选择器
  		});
		function subMessage(){
  			var empname_val = $("#empname").val();
  			var empphone_val = $("#empphone").val();
  			var empdateOne_val = $("#testdate1").val();
  			var empdateTwo_val = $("#testdate2").val();
  			var empnumber_val = $("#empnumber").val();
  			var zh = /^[a-zA-Z0-9]{2,20}$/g;
  			if(empname_val.length<2||empname_val.length>5){
  				alert("姓名在2-5个字符");
  				return false;
  			}else if(empphone_val == "" || empphone_val.length != 11){
  				alert("手机号为11位数字");
  				return false;
  			}else if(empdateOne_val == ""){
  				alert("请选择时间");
  				return false;
  			}else if(empdateTwo_val == ""){
  				alert("请选择时间");
  				return false;
  			}else if(empnumber_val == "" || !zh.test(empnumber_val)) {
  				alert("账号有2-20位数字或英文组成");
  				return false;
  			}else {
  				$.ajax({
  				 	type: "POST",//方法类型
                 	dataType: "json",//预期服务器返回的数据类型
                 	url: "addEmployee.do" ,//url
                 	data: $('#formMes').serialize(),
                 	success: function (res) {
                 	    if (res.success == 200) {
                 	   	 parent.location.reload();
                 	   	 x_admin_close();
                 	   	 
                 	    }else{
                 	   	 alert("未知错误");
                 	   	 parent.location.reload();
                 	   	 x_admin_close(); 
                 	    }
                 	},
                 	error : function() {
                		 alert("添加失败!");
                		 parent.location.reload();
                		 x_admin_close();
                 	}
  				})
  			}
  			}
		</script>
	</body>

</html>