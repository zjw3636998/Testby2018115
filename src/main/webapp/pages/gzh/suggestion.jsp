<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<meta charset="UTF-8">
<title>Insert title here</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" type="text/css" href="themes/css/reset.css">
		<link rel="stylesheet" type="text/css" href="themes/plugs/bootstrap/css/bootstrap.css">
	    <link rel="stylesheet" type="text/css" href="themes/plugs/layui/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="themes/css/weadmin.css">
		<script type="text/javascript" src="themes/plugs/jquery/jquery.min.js"></script>
	    <script type="text/javascript" src="themes/plugs/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="themes/plugs/layui/layui/layui.js"></script>
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
			        submitForm("<%=context%>/selSuggestion.do?pageNum=1");  
			        return true;  
			    }  
			}  
			// 下一页  
			function nextPage(){  
			    if(currentPage == totalPage){  
			        alert("已经是最后一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selSuggestion.do?pageNum=" + (currentPage+1));  
			        return true;  
			    }  
			}  
			// 上一页  
			function previousPage(){  
			    if(currentPage == 1){  
			        alert("已经是第一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selSuggestion.do?pageNum=" + (currentPage-1));  
			        return true;  
			    }  
			}  
			// 尾页  
			function lastPage(){  
			    if(currentPage == totalPage){
			    	alert("已经是最后一页数据")
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selSuggestion.do?pageNum=${totalPage}");  
			            return true;  
			        }  
			    }  
		</script>
</head>
<body>
	<div class="allmebWrap">
				<div class="head-tabs">
						<div class="crumb">
							<span class="layui-breadcrumb"  style="visibility:visible;">
								<a href="">首页</a>
								<span lay-separator>》</span>
								<a href="">公众号管理</a>
								<span lay-separator>》</span>
								<a href=""><cite>意见反馈汇总</cite></a>
							</span>
						</div>
				</div>
				<div class="tablist">
					<div class="tabtitle">
	  					<span>意见反馈</span>
					</div>
				</div>
				<div class="i-r-nav">
			    	<div class="i-search">
			    		<input type="text" class="i-search-input" placeholder="输入openid搜索" id="searchMessage">
			    		<img src="themes/images/search.png" height="21" width="20" alt="" class="search-img" id="searchInput">
			    	</div>
	    		</div>
		
			<table class="layui-table i-table">
				<thead>
					<tr>
						<th>意见反馈信息</th>
						<th>用户openid</th>
						<th>提交时间</th>
						<td>操作</td>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="suggestionList" items="${requestScope['suggestionList']}">
					<tr>
							<td>${suggestionList['st_content'] }</td>
							<td>${suggestionList['st_openid'] }</td>
							<td>${suggestionList['st_time'] }</td>
							<td><a href="delSuggestion.do?stId=${suggestionList['st_id'] }" onclick="return confirm('确认要删除此条信息？')">删</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		
			<div class="fenye" id="Fenye2">
				<ul class="fenye-block">    
		    		<li><a href="#" onclick="firstPage();">首页</a></li>  
		    		<li><a href="#" onclick="previousPage();">上一页</a></li>
		    		<li>${currentPage}/${totalPage}</li>  
		    		<li><a href="#" onclick="nextPage();">下一页</a></li>  
		   			<li><a href="#" onclick="lastPage();">尾页</a></li>
				</ul>
			</div>
		
	
</div>
	<script type="text/javascript" src="themes/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#searchInput').click(function() {
				var param1=$("#searchMessage").val();
				window.location.href="selSuggestion.do?openid="+param1;
			});
		});
	</script>
</body>
</html>