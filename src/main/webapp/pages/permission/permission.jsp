<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<meta charset="UTF-8">
<title>角色管理</title>
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
</head>
<body>
	<div class="homeWrap">
				<div class="head-tabs">
						<div class="crumb">
							<span class="layui-breadcrumb"  style="visibility:visible;">
								<a href="">首页</a>
								<span lay-separator>》</span>
								<a href="">系统管理</a>
								<span lay-separator>》</span>
								<a href=""><cite>权限设置</cite></a>
							</span>
						</div>
				</div>
				<div class="tablist">
					<div class="tabtitle">
	  					<span>部门及权限管理</span>
					</div>
				</div>
		<div class="layui-tab-item layui-show " style="overflow-x: scroll; width: 100%;">
			<div class="allmebWrap">
				<div class="weadmin-block i-block">
					<button class="layui-btn" onclick="WeAdminShow('添加用户','addRolesView.do')"><i class="layui-icon"></i>添加部门</button>
				</div>
		<div class="allmebWrap">
			<table class="layui-table i-table">
				<thead>
					<tr>
						<th>部门名称</th>
						<th>部门描述</th>
						<th>创建时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="roleList" items="${requestScope['roleList']}">
						<tr>
								<td>${roleList['role_name'] }</td>
								<td>${roleList['role_descript'] }</td>
								<td>${roleList['role_createtime'] }</td>
								<td>
									<a href="deleteRole.do?roleId=${meetingList['role_id']}" onclick="return confirm('确认要删除该部门么？')">删除</a>
									<a onclick="WeAdminShow('修改部门权限','')">处理</a>
								</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
	</div>
	</div>
	<script>	
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