     <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
</head>
<body onload="displayTime()">
<jsp:include page="/jsp/part/common.jsp"/>
<div class="easyui-layout" fit="true">
	<jsp:include page="/jsp/part/top.jsp"/>
	<jsp:include page="/jsp/part/left.jsp"/>
	<div region="center" border="true" title="<a href='/quota'>首页</a>">
		<a href="/quota/users/yd-7111">测试</a>
		<br>
		<a href="/quota/users">用户表（示例）</a>
		<br>
		<script type="text/javascript">
		function cs(){
				$.ajax({
					url:"/quota/api/quotaCoreData?opt['year']=2016",
					type:"get",
					success:function(data){
						console.log(data);
						alert("请看开发者模式console--->>"+data);
					}
				});
				
			}
		</script>
		<a href="#" onclick="cs()">核心指标数据表(接口)</a>
		<br>
		<a href="/quota/quotaCoreData">核心指标数据表(页面)</a>
		
		<br>
		licence:${licence }
	</div>
	<%session.setAttribute("licence", "123456");//测试代码 %>
	
</div>
</body>
</html>



