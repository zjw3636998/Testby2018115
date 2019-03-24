<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" type="text/css" href="../../themes/plugs/layui/layui/css/layui.css">
<link rel="stylesheet" type="text/css" href="../../themes/css/reset.css">
<link rel="stylesheet" type="text/css" href="../../themes/css/weadmin.css">
<link rel="stylesheet" href="../../themes/plugs/trumbowyg/design/css/trumbowyg.css">
<script type="text/javascript" src="../../themes/plugs/jquery/jquery.min.js"></script>
<script type="text/javascript" src="../../themes/plugs/layui/layui/layui.all.js"></script>
<script type="text/javascript" src="../../themes/plugs/layui/layui/layui.js"></script>
<script type="text/javascript" src="../../themes/plugs/Layer/layer.js"></script>
<title>Insert title here</title>
		<%  
   		 	String context = request.getContextPath();  
		%>  
</head>
<body>
	<textarea style="height: 200px;width: 480px;margin: 50px;border: 1px solid #ccc; margin-bottom: 0;" id="textContent"></textarea>
	<button id="remake_btn" style="width: 80px;height: 36px; border-radius: 4px;border: none;color: #fff;background-color: #0e72ef; margin-left: 50px; margin-top: 20px;">确认修改</button>
	<script type="text/javascript" src="../../themes/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		var cid="<%=request.getParameter("cid")%>";
		window.onload=function(){
			$.ajax({
			   url: "<%=context%>/selRemake.do",
		       data : {'cid':cid},
               dataType:"json",
               type: "POST",
               success: function (data){
                  if(data.success==200){
                	  $("#textContent").val(data.data);
                  }else{
                	  
                  }
               }
			})
		};
		$("#remake_btn").click(function(){
			var updContent=$("#textContent").val();
			$.ajax({
				url: "<%=context%>/addRemake.do",
			    data : {'cid':cid,'content':updContent},
	            dataType:"json",
	            type: "POST",
	            success: function (data){
	               if(data.success==200){
	            	   alert("保存成功！");
	               }else{
	            	   alert("保存失败！")
	               }
	            }
			})  
		})
	</script>
</body>
</html>