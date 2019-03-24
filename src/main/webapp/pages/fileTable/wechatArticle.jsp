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
			        submitForm("<%=context%>/selFile.do?pageNum=1&fileType=1");  
			        return true;  
			    }  
			}  
			// 下一页  
			function nextPage(){  
			    if(currentPage == totalPage){  
			        alert("已经是最后一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selFile.do?pageNum=" + (currentPage+1)+"&fileType=1");  
			        return true;  
			    }  
			}  
			// 上一页  
			function previousPage(){  
			    if(currentPage == 1){  
			        alert("已经是第一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selFile.do?pageNum=" + (currentPage-1)+"&fileType=1");  
			        return true;  
			    }  
			}  
			// 尾页  
			function lastPage(){  
			    if(currentPage == totalPage){  
			    	alert("已经是最后一页数据")
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selFile.do?pageNum=${totalPage}&fileType=1");  
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
								<a href=""><cite>公众号文章记录</cite></a>
							</span>
						</div>
				</div>
				<div class="tablist">
					<div class="tabtitle">
	  					<span>微信公众号上传文章查询</span>
					</div>
				</div>
				<div class="weadmin-block i-block">
						<button class="layui-btn" onclick="WeAdminShow('添加用户','pages/fileTable/addFile.html')"><i class="layui-icon"></i>添加</button>
					</div>
					<div class="i-r-nav">
				    	<div class="i-search">
				    		<input type="text" class="i-search-input" placeholder="请输入关键词搜索" id="searchMessage">
				    		<img src="themes/images/search.png" height="21" width="20" alt="" class="search-img" id="searchInput">
			    		</div>
				    	<div class="btn-filter">
				    		<div class="layui-input-inline">
								<select name="cateid" id="selectContent">
									<option value="">筛选</option>
									<option value="f_name">按文件名</option>
									<option value="f_user">按上传人</option>
								</select>
							</div>
			    		</div>
	    			</div>
				<div class="layui-tab-item layui-show " style="overflow-x: scroll; width: 100%;">
						<table class="layui-table i-table">
							<thead>
								<tr>
									<th>文件名</th>
									<th>上传人</th>
									<th>上传时间</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
							<c:forEach var="fileList" items="${requestScope['fileList']}">
								<tr>
										<td>${fileList['file_name']}</td>
										<td>${fileList['file_user']}</td>
										<td>${fileList['file_createtime'] }</td>
										<td>
											<a href="${fileList['file_url']}"  download=""  title="下载test"  mce_href="#">查看</a>
											<a href="deleteFile.do?fileUrl=${fileList['file_url']}&fileType=1" onclick="return confirm('确认要此文件？')">删除</a>
										</td>
								</tr>
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
					if(param1!=""){
					var param2=$("#searchMessage").val();
					window.location.href="selFile.do?searchType="+param1+"&searchContent="+encodeURI(encodeURI(param2))+"&fileType=1";
					}else{
						alert('请选择搜索类型！');
					}
				});
			});
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