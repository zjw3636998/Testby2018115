<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<meta charset="UTF-8">
	<title>线下咨询</title>
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
		        submitForm("<%=context%>/selXxzx.do?pageNum=1");  
		        return true;  
		    }  
		}  
		// 下一页  
		function nextPage(){  
		    if(currentPage == totalPage){  
		        alert("已经是最后一页数据");  
		        return false;  
		    }else{  
		        submitForm("<%=context%>/selXxzx.do?pageNum=" + (currentPage+1));  
		        return true;  
		    }  
		}  
		// 上一页  
		function previousPage(){  
		    if(currentPage == 1){  
		        alert("已经是第一页数据");  
		        return false;  
		    }else{  
		        submitForm("<%=context%>/selXxzx.do?pageNum=" + (currentPage-1));  
		        return true;  
		    }  
		}  
		// 尾页  
		function lastPage(){  
		    if(currentPage == totalPage){ 
		    	alert("已经是最后一页数据")
		        return false;  
		    }else{  
		        submitForm("<%=context%>/selXxzx.do?pageNum=${totalPage}");  
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
							<option value="order_state">按订单状态</option>
							<option value="out_trade_no">按订单号</option>
							<option value="openid">按openid</option>
						</select>
					</div>
		    	</div>
    		</div>
    		
			<table class="layui-table i-table">
				<thead>
					<tr>
						<th>姓名</th>
						<th>订单类型</th>
						<th>下单时间</th>
						<th>订单状态</th>
						<th>负责人</th>
						<th>电话</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="orderList" items="${requestScope['orderList']}">
					<tr>
						<td>${orderList['op_name'] }${orderList['op_deal']==sessionScope.employee.empName},${orderList['op_dealState']==3}</td>
						<c:choose>
								<c:when test="${orderList['op_type']==1}">
									<td>系统咨询</td>
								</c:when>
									<c:when test="${orderList['op_type']==2}">
									<td>深度咨询</td>
								</c:when>
						</c:choose>	
						<td>${orderList['op_createtime'] }</td>
						<td>
								<c:choose>
									<c:when test="${orderList['op_dealState']==1}">
										未处理
									</c:when>
									<c:when test="${orderList['op_dealState']==2}">
										正在审核
									</c:when>
									<c:when test="${orderList['op_dealState']==3}">
										正在处理
									</c:when>
								</c:choose>	
							</td>
						<td>
							<c:choose>
								<c:when test="${empty orderList['op_deal']}">
									<button onclick="dealEmp('${orderList.op_id}');" style="background-color: #fff;border: none;outline: none;">负责此单</button>
								</c:when>
								<c:otherwise>${orderList['op_deal']}</c:otherwise>
							</c:choose>	
						</td>
						<c:choose>
							<c:when test="${orderList['op_deal']==sessionScope.employee.empName&&orderList['op_dealState']==3}">
								<td>${orderList['op_phone'] }1</td>
							</c:when>
							<c:otherwise>
								<td>*************</td>
							</c:otherwise>
						</c:choose>
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
				var options=$("#selectContent option:selected");
				var param1=options.val();
				if(param1!=""){
					var param2=$("#searchMessage").val();
					window.location.href="selXxzx.do?searchType="+param1+"&searchContent="+encodeURI(encodeURI(param2));
				}else{
					alert('请选择搜索类型！');
				}
				
			});
		});
		function dealEmp(e) {
			var empName='${sessionScope.employee.empName}';
			var dealBoolean=confirm("确定要负责此单吗？");
			if(dealBoolean){
				$.ajax({
					 url: "<%=context%>/updXxzx.do",
					 data : {'empName':empName,'cid':e},
	                dataType:"json",
	                type: "POST",
	                success: function (data){
	                   if(data.success==200){
	                      alert("申请成功！");
	                      window.location.href="<%=context%>/selXxzx.do";
	                   }else{
	                	   alert("申请失败!");
	                	   window.location.href="<%=context%>/selXxzx.do";
	                   }
	                }
				})
			}
		}
		//页面
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