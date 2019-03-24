<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>核心指标</title>
</head>
<body onload="displayTime()">
<jsp:include page="/jsp/part/common.jsp"/>

<div class="easyui-layout" fit="true">
	<jsp:include page="/jsp/part/top.jsp"/>
	<jsp:include page="/jsp/part/left.jsp"/>
	<div region="center" border="true"
		 title="<a href='/quota'>首页</a>><a href='/quota/quotaCoreData'>核心指标</a>">
		
		<table id="dg" class="easyui-datagrid" border="false"
				url="/quota/api/quotaCoreData?opt['year']=2016"
				method="get" toolbar="#toolbar"
				loadMsg="数据加载中请稍后……"
				striped="true" pagination="true"
				rownumbers="true" fitColumns="true" 
				singleSelect="true" fit="true">
			<thead>
				<tr>
					<th field="iType" width="80"
						data-options="
							formatter:function(value,row,index){
                                if(row.coreInfo){
									return row.coreInfo.iType;
	                            }
                         }">类型</th>
                    <th field="iName" width="100"
						data-options="
							formatter:function(value,row,index){
                                if(row.coreInfo){
									return row.coreInfo.iName;
	                            }
                         }">名称</th>
                    <th field="iTargetValue" width="50"
						data-options="
							formatter:function(value,row,index){
                                if(row.coreInfo){
									return row.coreInfo.iTargetValue;
	                            }
                         }">目标值</th>
					<th field="d1" width="50" sortable="true">1月</th>
					<th field="d2" width="50" sortable="true">2月</th>
					<th field="d3" width="50" sortable="true">3月</th>
					<th field="d4" width="50" sortable="true">4月</th>
					<th field="d5" width="50" sortable="true">5月</th>
					<th field="d6" width="50" sortable="true">6月</th>
					<th field="d7" width="50" sortable="true">7月</th>
					<th field="d8" width="50" sortable="true">8月</th>
					<th field="d9" width="50" sortable="true">9月</th>
					<th field="d10" width="50" sortable="true">10月</th>
					<th field="d11" width="50" sortable="true">11月</th>
					<th field="d12" width="50" sortable="true">12月</th>
					<th field="dNote" width="50">备注</th>
					<th field="iYear" width="50"
						data-options="
							formatter:function(value,row,index){
                                if(row.coreInfo){
									return row.coreInfo.iYear;
	                            }
                         }">年</th>
				</tr>
			</thead>
		</table>
		
		
	</div>
</div>
<script type="text/javascript">
function reckon(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		$.ajax({
			url:"/quota/api/quotaCoreData/"+row.dId+"/reckon",
			type:"put",
			success:function(data){
				if(data!=null && data>0){
					console.log(data+",成功");
				}else{
					console.log(data+",失败");
				}
				$('#dg').datagrid('reload');
			}
		});
	}
}
function edit(){
	var row=$("#dg").datagrid("getSelected");
	if(row){
		window.location.href="/quota/quotaCoreData/"+row.dId;
	}
}
</script>
<div id="toolbar">
	<a href="#" class="easyui-linkbutton" iconCls="icon-reload" plain="true" onclick="reckon()">刷新一年</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()">编辑数据</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true">编辑规则</a>
	<br/>
	<p>
	css的单位，大家应该首先想到的是px,也就是像素，我们在网页布局中一般都是用px，但是近年来自适应网页布局越来越多，em和百分比也经常用到了，今天修改自己的博客模板时发现了一个问题，之前一直都是用自己的笔记本电脑来查看自己的博客，博客刚好显示的可以，但是一旦换了分辨率高的显示屏，网站就显得很不搭配了，要是css能够百分比加减固定像素就能解决问题了，于是百度相关，经过测试，终于解决了CSS百分比加减固定的像素的问题。
	</p>
	<div style="padding: 3px;"> 
		ID:<input/>
		year:<input/>
		<a href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
	</div>
</div>
</body>
</html>