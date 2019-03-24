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
			        submitForm("<%=context%>/selWechatUser.do?pageNum=1");  
			        return true;  
			    }  
			}  
			// 下一页  
			function nextPage(){  
			    if(currentPage == totalPage){  
			        alert("已经是最后一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selWechatUser.do?pageNum=" + (currentPage+1));  
			        return true;  
			    }  
			}  
			// 上一页  
			function previousPage(){  
			    if(currentPage == 1){  
			        alert("已经是第一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selWechatUser.do?pageNum=" + (currentPage-1));  
			        return true;  
			    }  
			}  
			// 尾页  
			function lastPage(){  
			    if(currentPage == totalPage){  
			    	alert("已经是最后一条数据")
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selWechatUser.do?pageNum=${totalPage}");  
			            return true;  
			        }  
			    }  
		</script>
</head>
<body>
	<body style="scroll-y: hidden;">
    	<div class="allmebWrap" style="position: relative;">
			<div class="i-r-nav">
		    	<div class="i-search">
		    		<input type="text" class="i-search-input" placeholder="请输入关键词搜索" id="searchMessage">
		    			<img src="themes/images/search.png" height="21" width="20" alt="" class="search-img" id="searchInput">
		    	</div>
		    	<div class="btn-filter">
		    		<div class="layui-input-inline">
						<select name="cateid" id="selectContent">
							<option value="">筛选</option>
							<option value="openid">按openid</option>
							<option value="nickname">按昵称</option>
							<option value="company">按公司</option>
						</select>
					</div>
		    	</div>
    		</div>
    		<div class="layui-tab-item layui-show " style=" width: 100%;">
				<table class="layui-table i-table">
					<thead>
						<tr>
							<th>昵称</th>
							<th>性别</th>
							<th>地址</th>
							<th>联系方式</th>
							<th>公司名称</th>
							<th>最新登陆时间</th>
							<th>用户等级</th>
							<th>openid</th>
							<th>备注</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="wechatList" items="${requestScope['wechatList']}">
						<tr>
								<td>${wechatList['nickname']}</td>
								<td>${wechatList['sex']}</td>
								<td>${wechatList['country']},${wechatList['province']},${wechatList['city']}</td>
								<td>${wechatList['phone'] }</td>
								<td>${wechatList['company'] }</td>
								<td>${wechatList['logintime'] }</td>
								<td>${wechatList['level'] }</td>
								<td>${wechatList['openid'] }</td>
								<td>${wechatList['ps'] }</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
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
				var options=$("#selectContent option:selected");
				var param1=options.val();
				if(param1!=""){
					var param2=$("#searchMessage").val();
					window.location.href="selWechatUser.do?searchType="+param1+"&searchContent="+encodeURI(encodeURI(param2))
				}else{
					alert("请输入筛选内容！");					
				}
			});
		});
	</script>
</body>
</html>