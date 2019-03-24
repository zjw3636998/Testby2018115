<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>核心指标数据编辑</title>
</head>
<body onload="displayTime()">

<jsp:include page="/jsp/part/common.jsp"/>
<script type="text/javascript">
var str = window.location.href;
var str1 = new Array();
str1=str.split("/");
$(function(){
	$.ajax({
		url:"/quota/api/quotaCoreData/"+str1[str1.length-1],
		type:"get",
		success:function(data){
			var coreData=data.data;
			$("#fm").form("load",coreData);
			$("#fm").form("load",{
				iType:coreData.coreInfo.iType,
				iName:coreData.coreInfo.iName,
				iMaster:coreData.coreInfo.iMaster,
				iDefinition:coreData.coreInfo.iDefinition,
				iUnit:coreData.coreInfo.iUnit,
				iSource:coreData.coreInfo.iSource,
				iFormula:coreData.coreInfo.iFormula,
				iTargetValue:coreData.coreInfo.iTargetValue,
				iYear:coreData.coreInfo.iYear
			});
		}
	});
	
});
function saveUser(){
	$("#fm").form("submit",{
		url:"/quota/api/quotaCoreData/"+str1[str1.length-1],
		onSubmit:function(){
			return $(this).form('validate');
		},
		success:function(data){
			if(data){
				var json=$.parseJSON(data)
				console.log(json.result);
				if (json.result=="success") {
					window.location.href="/quota/quotaCoreData";
				}else {
					$('#dg').datagrid('reload'); //重新加载当前数据页
				}
			}
			$('#dg').datagrid('reload'); //重新加载当前数据页
		}
	});
}
</script>
<div class="easyui-layout" fit="true">
	<jsp:include page="/jsp/part/top.jsp"/>
	<jsp:include page="/jsp/part/left.jsp"/>
	<div region="center" border="true" title="<a href='/quota'>首页</a>><a href='/quota/quotaCoreData'>核心指标</a>><a href='#'>修改</a>">
		<div>
</div>
		<div id="dlg"  style="width:820px;height:85%;padding:10px 20px"
				closed="true">
			<div class="ftitle">指标数据修改</div>
			<form id="fm" method="post">
				<div style="width:800px;height:230px;float:left;">
					<input type="hidden" name="_method" value="put"/>
					<input type="hidden" name="_header" value="${licence }"/>
					<div class="fitem">
						<input name="dId"  required="true" style="display: none;"/>
					</div>
					<div class="fitem">
						<input name="iId"  required="true" style="display: none;"/>
					</div>
					<div class="fitem">
						<label>类别:</label>
						<input name="iType"  required="true" style="border:none" readonly="readonly">
					</div>
					<div class="fitem">
						<label>指标名称:</label>
						<input name="iName"  required="true" style="border:none" readonly="readonly">
					</div>
					<div class="fitem">
						<label>指标责任人:</label>
						<input name="iMaster" required="true" style="border:none" readonly="readonly">
					</div>
					<div class="fitem">
						<label>指标定义:</label>
						<input name="iDefinition"  required="true" style="border:none" readonly="readonly">
					</div>
					<div class="fitem">
						<label>计量单位:</label>
						<input name="iUnit"  required="true" style="border:none" readonly="readonly">
					</div>
					<div class="fitem">
						<label>数据来源:</label>
						<input name="iSource"  required="true" style="border:none" readonly="readonly">
					</div>
					<div class="fitem">
						<label>计算公式:</label>
						<input name="iFormula"  required="true" style="border:none" readonly="readonly">
					</div>
					<div class="fitem">
						<label>目标数值:</label>
						<input name="iTargetValue" required="true" style="border:none" readonly="readonly">
					</div>
					<div class="fitem">
						<label>年:</label>
						<input name="iYear"  required="true" style="border:none" readonly="readonly">
					</div>
				</div>
				<div style="width:800px;height:350px;border:0px solid red;float:left;">
					<div class="fitem" style="width:400px;height:25px;float:left">
						<label>1月:</label>
						<input name="d1" class="easyui-validatebox" >
					</div>
					<div class="fitem" style="width:400px;height:25px;float:left">
						<label>2月:</label>
						<input name="d2" class="easyui-validatebox" >
					</div>
					<div class="fitem" style="width:400px;height:25px;float:left">
						<label>3月:</label>
						<input name="d3" class="easyui-validatebox" >
					</div>
					<div class="fitem" style="width:400px;height:25px;float:left">
						<label>4月:</label>
						<input name="d4" class="easyui-validatebox" >
					</div>
					<div class="fitem" style="width:400px;height:25px;float:left">
						<label>5月:</label>
						<input name="d5" class="easyui-validatebox">
					</div>
					<div class="fitem" style="width:400px;height:25px;float:left">
						<label>6月:</label>
						<input name="d6" class="easyui-validatebox" >
					</div>
					<div class="fitem" style="width:400px;height:25px;float:left">
						<label>7月:</label>
						<input name="d7" class="easyui-validatebox" >
					</div>
					<div class="fitem" style="width:400px;height:25px;float:left">
						<label>8月:</label>
						<input name="d8" class="easyui-validatebox" >
					</div>
					<div class="fitem" style="width:400px;height:25px;float:left">
						<label>9月:</label>
						<input name="d9" class="easyui-validatebox" >
					</div>
					<div class="fitem" style="width:400px;height:25px;float:left">
						<label>10月:</label>
						<input name="d10" class="easyui-validatebox" >
					</div>
					<div class="fitem" style="width:400px;height:25px;float:left">
						<label>11月:</label>
						<input name="d11" class="easyui-validatebox" >
					</div>
					<div class="fitem" style="width:400px;height:25px;float:left">
						<label>12月:</label>
						<input name="d12" class="easyui-validatebox" >
					</div>
					<div class="fitem">
						<label>备注:</label>
						<input name="dNote" class="easyui-validatebox" >
					</div>
					<div id="dlg-buttons">
						<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">提交</a>
						<a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
					</div>
				</div>
			</form>
		</div>
	</div>
		
</div>

</body>
</html>