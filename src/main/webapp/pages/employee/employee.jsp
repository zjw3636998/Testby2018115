<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<meta charset="UTF-8">
<title>小程序用户</title>
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
			        submitForm("<%=context%>/selEmp.do?pageNum=1");  
			        return true;  
			    }  
			}  
			// 下一页  
			function nextPage(){  
			    if(currentPage == totalPage){  
			        alert("已经是最后一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selEmp.do?pageNum=" + (currentPage+1));  
			        return true;  
			    }  
			}  
			// 上一页  
			function previousPage(){  
			    if(currentPage == 1){  
			        alert("已经是第一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selEmp.do?pageNum=" + (currentPage-1));  
			        return true;  
			    }  
			}  
			// 尾页  
			function lastPage(){  
			    if(currentPage == totalPage){  
			    	alert("已经是最后一页数据")
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selEmp.do?pageNum=${totalPage}");  
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
								<a href="">职能管理</a>
								<span lay-separator>》</span>
								<a href=""><cite>员工管理</cite></a>
							</span>
						</div>
				</div>
				<div class="tablist">
					<div class="tabtitle">
	  					<span>员工管理</span>
	  					<button class="layui-btn fr-btn" onclick="WeAdminShow('添加员工','addEmployeeView.do')">添加员工</button>
					</div>
				</div>
				<div class="department">
					<c:forEach var="roleList" items="${requestScope['roleList']}">
						<button onclick="selDepartment('${roleList['role_name']}');" class="depart-btn">${roleList['role_name']}</button>
					</c:forEach>
				</div>		
			<div class="i-r-nav">
		    	<div class="i-search">
		    		<input type="text" class="i-search-input" placeholder="请输入关键词搜索" id="searchMessage">
		    			<img src="themes/images/search.png" height="21" width="20" alt="" class="search-img" id="searchInput">
		    	</div>
		    	<div class="btn-filter">
		    		<div class="layui-input-inline">
						<select name="cateid" id="selectContent">
							<option value="empName">按姓名</option>
						</select>
					</div>
		    	</div>
    		</div>
	<div class="layui-tab-item layui-show " style="overflow-x: scroll; width: 100%;">
			<table class="layui-table i-table">
				<thead>
					<tr>
						<th>姓名</th>
						<th>入职时间</th>
						<th>转正时间</th>
						<th>所属部门</th>
						<th>职级</th>
						<th>学历</th>
						<th>最近修改人</th>
						<th>修改时间</th>
						<th>操作</th>
					</tr>
				</thead> 
				<tbody>
				<c:forEach var="employeeList" items="${requestScope['employeeList']}">
					<c:if test="${empty employeeList['dimission']}">
						<tr>
								<td>${employeeList['empName'] }</td>
								<td>${employeeList['entry_time'] }</td>
								<td>${employeeList['regular_time'] }</td>
								<td>${employeeList['department'] }</td>
								<td>${employeeList['level'] }</td>
								<td>${employeeList['education'] }</td>
								<td>${employeeList['upd_emp'] }</td>
								<td>${employeeList['upd_time'] }</td>
								<td>
									<!-- <a href="">编辑</a> -->
									<a href="dimission.do?userId=${employeeList['user_id']}" onclick="return confirm('确定该员工已离职吗（点击确定将删除员工账号且不可恢复）')">离职</a>
									<a onclick="WeAdminShow('更多信息','moreUserMessage.do?userId=${employeeList['user_id']}',600,500)">更多</a>
								</td>
						</tr>
					</c:if>
				</c:forEach>
				</tbody>
			</table>
		</div>
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

	<script type="text/javascript" src="themes/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#searchInput').click(function() {
				var options=$("#selectContent option:selected");
				var param1=options.val();
				var param2=$("#searchMessage").val();
				window.location.href="selEmp.do?searchType="+param1+"&searchContent="+encodeURI(encodeURI(param2));
			});
		});
		function selDepartment(param){
			window.location.href="selEmp.do?searchType=department&searchContent="+encodeURI(encodeURI(param));
		}
		
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
</body>
</html>