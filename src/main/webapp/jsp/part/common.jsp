<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>公共引用，对于库，可以在这里集中处理</title>

<link rel="stylesheet" type="text/css" href="/quota/framework/jquery-easyui-1.5.1/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="/quota/framework/jquery-easyui-1.5.1/themes/icon.css">
<link rel="stylesheet" type="text/css" href="/quota/framework/jquery-easyui-1.5.1/demo/demo.css">
<script type="text/javascript" src="/quota/framework/jquery-easyui-1.5.1/jquery.min.js"></script>
<script type="text/javascript" src="/quota/framework/jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
<link rel="stylesheet" type="text/css" href="/quota/framework/css/zs.css">
<script type="text/javascript" src="/quota/framework/js/zs.js"></script>
<script type="text/javascript" src="/quota/framework/jquery-easyui-1.5.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
/*张顺，2017-2-25
 * ajax添加头信息
 * */
$.ajaxSetup({ 
	headers : {"licence":"${licence}"}
});
</script>
</head>
<body>

</body>
</html>