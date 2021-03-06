<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>个人密码修改</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" type="text/css" href="../../themes/css/reset.css">
		<link rel="stylesheet" type="text/css" href="../../themes/plugs/bootstrap/css/bootstrap.css">
	    <link rel="stylesheet" type="text/css" href="../../themes/plugs/layui/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="../../themes/css/weadmin.css">
		<script type="text/javascript" src="../../themes/plugs/jquery/jquery.min.js"></script>
	    <script type="text/javascript" src="../../themes/plugs/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="../../themes/plugs/layui/layui/layui.js"></script>
	    <script type="text/javascript" src="../../themes/plugs/Layer/layer.js"></script>
	    <script type="text/javascript" src="../../themes/js/weadmin.js"></script>
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>

	<body>
		<div class="weadmin-body changePass">
			<form  class="chPassword-form" id="chpForm" name="chpfrom">
				<div class="chp-form-item">
					<label for="oldp" class="chp-label">当前密码</label>
					<div class="chp-inp-block">
						<input type="password" class="chp-input" name="oldp" value="">
					</div>
				</div>
				<div class="chp-form-item">
					<label for="newp" class="chp-label">新密码</label>
					<div class="chp-inp-block">
						<input type="password" class="chp-input" name="newp" value="">
					</div>
				</div>
				<div class="chp-form-item">
					<label for="confirmp" class="chp-label">确认新密码</label>
					<div class="chp-inp-block">
						<input type="password" class="chp-input" name="confirmp" value="">
					</div>
				</div>
				<div class="chp-form-item">
					<label  class="chp-label"></label>
					<div class="chp-inp-block">
						<input type="button" class="chp-btn" name="chbtn" value="确认修改" id="chpBtn">
					</div>
				</div>
			</form>
		</div>
		<script type="text/javascript">
			$(function(){
				$("#chpBtn").click(function(){
					var oldPassword_val = document.chpfrom.oldp.value;
					var newPassword_val = document.chpfrom.newp.value;
					var confirmP_val = document.chpfrom.confirmp.value;
					if(oldPassword_val != '${sessionScope.userTable.u_password}'){
						alert("原密码错误！");
						return false;
					}
        			if(newPassword_val === ""){
        			    alert('请输入新的密码！')
        			}else if(newPassword_val.length < 6 || confirmP_val.length < 6){
        			    alert('密码长度不能小于6位');
        			}else if(confirmP_val === ""){
        			    alert('请再次输入新的密码！')
        			}else if(newPassword_val != confirmP_val){
        			    alert('两次输入的密码不一致！')
				    }else {
				    	$.ajax({
							type: "POST",
				            dataType: "json",
				            url: "../../updPassword.do",
				            data:{'newp':newPassword_val},
				            success: function (res) {
				            	if(res.success==200){
				            		alert('修改成功');
				            	}
				            	 x_admin_close();
				            	 window.open(url, windowName, windowFeatures, optionalArg4);
				            },
				            error : function(){
				            	x_admin_close();    
				            }
						}) 
        			    return true;
        			}
        		})
        	})
		</script>
	</body>
</html>