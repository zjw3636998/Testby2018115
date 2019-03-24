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
</head>
<body>
	<body style="scroll-y: hidden;">
    	<div class="allmebWrap">
    		<div style="overflow-x: scroll; width: 100%;">
			<table class="layui-table i-table">
				<thead>
					<tr>
						<th>订单号</th>
						<th>购买内容</th>
						<th>下单时间</th>
						<th>申请人</th>
						<th>操作</th>
						<th>openid</th>
						<th>支付金额</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="list" items="${requestScope['list']}">
					<tr>
							<td>${list['out_trade_no'] }</td>
							<td>${list['order_content'] }</td>
							<td>${list['order_createtime'] }</td>
							<td>${list['order_deal'] }</td>
							<td>
								<a href="updDealWyzx.do?ds_id=${list['order_id']}&ds_state=3">同意</a>
								<a href="updDealWyzx.do?ds_id=${list['order_id']}&ds_state=1">不同意</a>
							</td>
							<td>${list['openid'] }</td>
							<td>${list['order_pay'] }</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
	</div>
</body>
</html>