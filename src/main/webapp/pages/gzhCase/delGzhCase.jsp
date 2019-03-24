<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<meta charset="UTF-8">
<title>会议记录</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" type="text/css" href="themes/css/reset.css">
	    <link rel="stylesheet" type="text/css" href="themes/plugs/layui/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="themes/css/weadmin.css">
		<script type="text/javascript" src="themes/plugs/jquery/jquery.min.js"></script>
	    <script type="text/javascript" src="themes/plugs/layui/layui/layui.js"></script>
	    <script type="text/javascript" src="themes/plugs/Layer/layer.js"></script>
	    <script type="text/javascript" src="themes/js/weadmin.js"></script>
	    <%  
   		 	String context = request.getContextPath();  
		%>  
		<script type="text/javascript">  
			// 当前第几页数据  
			var currentPage = ${currentPage};  
			  
			// 总页数  
			var totalPage = ${totalPage};  
			  
			function submitForm(actionUrl){  
			    window.location.href = actionUrl;  
			}  
			  
			// 第一页  
			function firstPage(){  
			    if(currentPage == 1){  
			        alert("已经是第一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/searchDeleteCase.do?pageNum=1");  
			        return true;  
			    }  
			}  
			// 下一页  
			function nextPage(){  
			    if(currentPage == totalPage){  
			        alert("已经是最后一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/searchDeleteCase.do?pageNum=" + (currentPage+1));  
			        return true;  
			    }  
			}  
			// 上一页  
			function previousPage(){  
			    if(currentPage == 1){  
			        alert("已经是第一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/searchDeleteCase.do?pageNum=" + (currentPage-1));  
			        return true;  
			    }  
			}  
			// 尾页  
			function lastPage(){  
			    if(currentPage == totalPage){  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/searchDeleteCase.do?pageNum=${totalPage}");  
			            return true;  
			        }  
			    }  
		</script>
</head>
<body>
	<div class="homeWrap">
		<div class="layui-tab-item layui-show " style="overflow-x: scroll; width: 100%;">
			<div class="allmebWrap">
		<div class="allmebWrap">
			<table class="layui-table i-table">
				<thead>
					<tr>
						<th>策略题目</th>
						<th>所属行业</th>
						<th>上传人</th>
						<th>上传时间</th>
						<th>阅读量</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="caseList" items="${requestScope['caseList']}">
						<tr>
							<td>${caseList['case_title']}</td>
							<td>${caseList['case_type'] }</td>
							<td>${caseList['case_author'] }</td>
							<td>${caseList['case_createTime'] }</td>
							<td>${caseList['case_reader'] }</td>
							<td>
								<a href="deleteCase.do?case_id=${caseList['case_id']}" onclick="return confirm('确认要删除此策略文章？')">删除</a>
								<a href="recoverCase.do?case_id=${caseList['case_id']}">恢复</a>
								</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div class="fenye" id="Fenye">
				<ul class="fenye-block">    
		    		<li><a href="#" onclick="firstPage();">首页</a></li>  
		    		<li><a href="#" onclick="previousPage();">上一页</a></li>
		    		<li>${currentPage}/${totalPage}</li>  
		    		<li><a href="#" onclick="nextPage();">下一页</a></li>  
		   			<li><a href="#" onclick="lastPage();">尾页</a></li>
				</ul>
			</div>
		</div>
		</div>
	</div>
	</div>
	<script>
	</script>	
</body>
</html>