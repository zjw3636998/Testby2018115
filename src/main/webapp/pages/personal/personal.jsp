<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
       <meta charset="UTF-8">
		<title>个人账号设置</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" type="text/css" href="themes/css/reset.css">
		<link rel="stylesheet" type="text/css" href="themes/plugs/bootstrap/css/bootstrap.css">
	    <link rel="stylesheet" type="text/css" href="themes/plugs/layui/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="themes/css/weadmin.css">
		<script type="text/javascript" src="themes/plugs/jquery/jquery.min.js"></script>
	    <script type="text/javascript" src="themes/plugs/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="themes/plugs/layui/layui/layui.all.js"></script>
	    <script type="text/javascript" src="themes/plugs/Layer/layer.js"></script>
	    <script type="text/javascript" src="themes/js/weadmin.js"></script>
    </head>
    <body>
    	<div class="homeWrap">
    			<div class="head-tabs">
						<div class="crumb">
							<span class="layui-breadcrumb"  style="visibility:visible;">
								<a href="">首页</a>
								<span lay-separator>》</span>
								<a href="">职能管理</a>
								<span lay-separator>》</span>
								<a href=""><cite>个人账号管理</cite></a>
							</span>
						</div>
				</div>
				<div class="tablist">
					<div class="tabtitle">
	  					<div class="head-title">个人中心</div>
	  					<div class="changepw">
    						<button class="change-btn" onclick="WeAdminShow('修改密码','pages/personal/changePass.jsp',600,400)">修改密码</button>
    					</div>
					</div>
				</div>
    		<div class="set-content">
					<div class="set-form-item">
						<label for="username">姓名</label>
						<div class="set-input-block">
							<input type="text"  class="i-set-input" value="${requestScope.employee.empName }" readonly="readonly">
						</div>
					</div>
					<div class="set-form-item">
						<label for="username">部门</label>
						<div class="set-input-block">
							<input type="text" class="i-set-input" value="${requestScope.employee.department}" readonly="readonly">
						</div>
					</div>
					<div class="set-form-item">
						<label for="nicheng">账号昵称</label>
						<div class="set-input-block">
							<input type="text" class="i-set-input" id="username" value="${sessionScope.userTable.u_name}" 
							disabled="disabled" onblur="getUsername();">
						</div>
						<a class="set-item-a" id="set_user">点击修改昵称</a>
					</div>
					<div class="set-form-item">
						<label for="phone">手机</label>
						<div class="set-input-block">
							<input type="tel" class="i-set-input" id="phone" value="${sessionScope.userTable.u_phone}" 
							disabled="disabled" onblur="getPhone();">
						</div>
						<a class="set-item-a" id="btn_iphone">点击修改手机号</a> 
					</div>
					<div class="set-form-item">
						<label for="email">职级</label>
						<div class="set-input-block">
							<input type="text" class="i-set-input" value="${requestScope.employee.level}" readonly="readonly">
						</div>
					</div>
					<div class="set-form-item">
						<label for="remarks">入职时间</label>
						<div class="set-input-block">
							<input type="text" class="i-set-input" value="${requestScope.employee.entry_time}" readonly="readonly">
						</div>
					</div>
					<div class="set-form-item">
						<label for="remarks">转正时间</label>
						<div class="set-input-block">
							<input type="text" class="i-set-input" value="${requestScope.employee.regular_time}" readonly="readonly"">
						</div>
					</div>
					<div class="set-form-item">
						<label for="remarks">最近登陆</label>
						<div class="set-input-block">
							<input type="text" class="i-set-input" value="${sessionScope.userTable.u_newtime}" readonly="readonly">
						</div>
					</div>
					<div class="set-form-item">
						<div class="set-btn-block">
							<button class="set-btn"  onclick="subMessage()" >确认修改</button>
							<button type="reset" class="set-btn set-btn-primary">重新填写</button>
						</div>
					</div>
			</div>
		</div>
    </body>
    <script type="text/javascript">
    	
    		$(function(){
					$("#set_user").click(function(){
						document.all.username.disabled = false;
    		    	$("#username").val("").focus();
    			});
					$("#btn_iphone").click(function(){
						document.all.phone.disabled = false;
    		    	$("#phone").val("").focus();
    			});	
    		});
    		
    	function getUsername(){
    		var message=confirm("确认修改信息吗？");
    		if(message){
    			var namelength=$("#username").val().length;
    			if(namelength>=2&&namelength<=6){
    				document.all.username.disabled = true;
    			}else{
    				alert("昵称长度2-6");
    			}
    		}else{
    			document.all.username.disabled = true;
    			$("#username").val("${sessionScope.userTable.u_name}");
    		}
    	}
    	function getPhone(){
    		var message=confirm("确认修改信息吗？");
    		if(message){
    			var phonelength=$("#phone").val().length;
    			if(phonelength==11){
    				document.all.phone.disabled = true;
    			}else{
    				alert("手机号不正确");
    			}
    		}else{
    			document.all.phone.disabled = true;
    			$("#phone").val("${sessionScope.userTable.u_phone}");
    		}
    	}
		function subMessage(){
			var username=$("#username").val();
			var phone=$("#phone").val();
			var checkphone=document.all.phone.disabled;
			var checkname=document.all.username.disabled;
			if(checkphone==true&&checkname==true){
				$.ajax({
					type: "POST",
		            dataType: "json",
		            url: "updEmp.do",
		            data:{'username':username,'phone':phone},
		            success: function (res) {
		            	if(res.success==200){
		            		alert('添加成功');
		            	}
		            	location.reload();  
		            },
		            error : function(){
		            	location.reload();   
		            }
				}) 
			}else{
				alert("输入有误，请确认修改信息！");
			}
			
			}
  		/*点击事件*/
		window.WeAdminShow = function(title, url, w, h) {
		if(title == null || title == '') {
			title = false;
		};
		if(url == null || url == '') {
			url = "404.html";
		};
		if(w == null || w == '') {
			w = ($(window).width() * 0.9);
		};
		if(h == null || h == '') {
			h = ($(window).height() - 50);
		};
		layer.open({
			type: 2,
			area: [w + 'px', h + 'px'],
			fix: false, //不固定
			maxmin: true,
			shadeClose: true,
			shade: 0.4,
			title: title,
			content: url
		});
	}
	window.WeAdminEdit = function(title, url, id, w, h) {
		if(title == null || title == '') {
			title = false;
		};
		if(url == null || url == '') {
			url = "404.html";
		};
		if(w == null || w == '') {
			w = ($(window).width() * 0.9);
		};
		if(h == null || h == '') {
			h = ($(window).height() - 50);
		};
		layer.open({
			type: 2,
			area: [w + 'px', h + 'px'],
			fix: false, //不固定
			maxmin: true,
			shadeClose: true,
			shade: 0.4,
			title: title,
			content: url,
			success: function(layero, index) {
				//向iframe页的id=house的元素传值  // 参考 https://yq.aliyun.com/ziliao/133150
				var body = layer.getChildFrame('body', index);
				body.contents().find("#dataId").val(id);
				console.log(id);
			},
			error: function(layero, index) {
				alert("aaa");
			}
		});
	}
	</script>	
</html>