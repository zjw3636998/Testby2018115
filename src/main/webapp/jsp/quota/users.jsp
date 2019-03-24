<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户管理</title>

<script type="text/javascript">
var url;
function newUser(){
	$("#dlg").dialog("open").dialog("setTitle","新建用户");	
	$("#fm").form("clear");
	$("#fm input[name='_method']").val("post");
	$("#fm input[name='_header']").val("${licence }");
	url="/quota/api/users";
}

function editUser(){
	var row=$("#dg").datagrid("getSelected");
	console.log(row);
	if(row){
		$("#dlg").dialog("open").dialog("setTitle","编辑用户");
		$("#fm").form("load",row);
		$("#fm input[name='_method']").val("put");
		$("#fm input[name='_header']").val("${licence }");
		url="/quota/api/users/"+row.uNum;
	}
}
function saveUser(){
	console.log($("#fm").serializeArray());
	$("#fm").form("submit",{
		url:url,		
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function(data){
			console.log("提交:"+data);
			$('#dg').datagrid('reload');
		}
	});
}
function destoryUser(){
	var row=$("#dg").datagrid("getSelected");
	var uNum=row.uNum;
	if(row){
		$.messager.confirm(
			"操作提示",
			"您确定要删除吗？",
			function(data){
				if(data){
					$.ajax({
						url:"/quota/api/users/"+uNum,
						type:"delete",
						success:function(){
							$.ajax({
								url:url,
								data:$("#fm").serialize(),
								success: function (data) {
									console.log(data);
									$('#dg').datagrid('reload');
				                }
							});
						}
					});
				}
			}
		);
	}
}
</script>
</head>
<body onload="displayTime()">

<jsp:include page="/jsp/part/common.jsp"/>
<div class="easyui-layout" fit="true">
	<jsp:include page="/jsp/part/top.jsp"/>
	<jsp:include page="/jsp/part/left.jsp"/>
	<div region="center" border="true" title="<a href='/quota/index.jsp'>首页</a>><a href='/quota/jsp/quota/users.jsp'>用户管理</a>">
		<table id="dg" class="easyui-datagrid" border="false"
				url="/quota/api/users"
				method="get" toolbar="#toolbar"
				loadMsg="数据加载中请稍后……" displayMsg="{from} , {to} , {total}"
				striped="true" pagination="true"
				rownumbers="true" fitColumns="true" 
				singleSelect="true" fit="true">
			<thead>
				<tr>
					<th field="uNum" width="50" sortable="true">账号</th>
					<th field="uPass" width="50">密码</th>
					<th field="uName" width="50" sortable="true">用户名</th>
					<th field="uJob" width="50">职责</th>
					<th field="csId" width="50" sortable="true">部门</th>
					<th field="uStartTime" width="50" sortable="true">创建时间</th>
					<th field="rId" width="50" sortable="true">角色</th>
					<th field="uMail" width="50">邮箱</th>
					<th field="uState" width="50">状态</th>
				</tr>
			</thead>
		</table>
	</div>
</div>

<div id="toolbar">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加用户</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destoryUser()">删除用户</a>
	<br/>
	<p>
	css的单位，大家应该首先想到的是px,也就是像素，我们在网页布局中一般都是用px，但是近年来自适应网页布局越来越多，em和百分比也经常用到了，今天修改自己的博客模板时发现了一个问题，之前一直都是用自己的笔记本电脑来查看自己的博客，博客刚好显示的可以，但是一旦换了分辨率高的显示屏，网站就显得很不搭配了，要是css能够百分比加减固定像素就能解决问题了，于是百度相关，经过测试，终于解决了CSS百分比加减固定的像素的问题。
	</p>
	<div style="padding: 3px;"> 
		ID:<input/>
		Name:<input/>
		Num:<input/>
		Mail:<input/>
		<a href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
	</div>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px;height:400px;padding:10px 20px"
		closed="true" buttons="#dlg-buttons">
	<div class="ftitle">用户信息</div>
	<form id="fm" method="post" >
		<input type="hidden" name="_method" value="post"/>
		<input type="hidden" name="_header" value="${licence}"/>
		<div class="fitem">
			<label>uNum:</label>
			<input name="uNum" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>uPass:</label>
			<input name="uPass" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>uName:</label>
			<input name="uName" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>csId:</label>
			<input name="csId" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>uJob:</label>
			<input name="uJob" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>uStartTime:</label>
			<input name="uStartTime" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>rId:</label>
			<input name="rId" class="easyui-validatebox" required="true">
		</div>
		<div class="fitem">
			<label>uMail:</label>
			<input name="uMail" class="easyui-validatebox" validType="email" required="true">
		</div>
		<div class="fitem">
			<label>uState:</label>
			<input name="uState" class="easyui-validatebox" required="true">
		</div>
	</form>
</div>
<div id="dlg-buttons">
	<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">提交</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
</div>

</body>
</html>