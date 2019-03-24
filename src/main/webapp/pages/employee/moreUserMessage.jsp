<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
		<meta charset="UTF-8">
		<title>会议信息记录</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" type="text/css" href="themes/css/reset.css">
	    <link rel="stylesheet" type="text/css" href="themes/plugs/layui/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="themes/css/weadmin.css">
		<link rel="stylesheet" href="themes/plugs/trumbowyg/design/css/trumbowyg.css">
		
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>
	<body>
		<div class="i-body">
		<form class="layui-form i-meet-form" action="##" method="post" id="formMes">
				<div class="layui-form-item i-form-item">
				    <label for="username" class="layui-form-label i-meet-label">
                  		<span class="i-red">*</span>后台账号
              		</label>
              		<div class="layui-input-block i-input-block">
						<input type="text" class="layui-input" readonly="readonly" value="${requestScope.userTable.u_account }">
					</div>
				</div>
				<div class="layui-form-item i-form-item">	 
		            	 <label for="userename" class="layui-form-label i-meet-label">
                  			<span class="i-red">*</span>昵称
              			</label>
              			<div class="layui-input-block i-input-block">
							<input type="text" class="layui-input" readonly="readonly" value="${requestScope.userTable.u_name }">
						</div>  
				</div>
				<div class="layui-form-item i-form-item">	 
		            	 <label for="userename" class="layui-form-label i-meet-label">
                  			<span class="i-red">*</span>联系方式
              			</label>
              			<div class="layui-input-block i-input-block">
							<input type="text" class="layui-input" readonly="readonly" value="${requestScope.userTable.u_phone }">
						</div>  
				</div>
				<div class="layui-form-item i-form-item">	 
		            	 <label for="userename" class="layui-form-label i-meet-label">
                  			<span class="i-red">*</span>账号创建时间
              			</label>
              			<div class="layui-input-block i-input-block">
							<input type="text" class="layui-input" readonly="readonly" value="${requestScope.userTable.u_createtime}">
						</div>  
				</div>
				<div class="layui-form-item i-form-item">	 
		            	 <label for="userename" class="layui-form-label i-meet-label">
                  			<span class="i-red">*</span>最近登陆时间
              			</label>
              			<div class="layui-input-block i-input-block">
							<input type="text" class="layui-input" readonly="readonly" value="${requestScope.userTable.u_newtime}">
						</div>
				</div>
		</form>
		</div>
	</body>
</html>