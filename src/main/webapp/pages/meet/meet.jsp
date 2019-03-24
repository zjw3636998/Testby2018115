<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<meta charset="UTF-8">
<title>会议记录</title>
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
			        submitForm("<%=context%>/selMeeting.do?pageNum=1");  
			        return true;  
			    }  
			}  
			// 下一页  
			function nextPage(){  
			    if(currentPage == totalPage){  
			        alert("已经是最后一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selMeeting.do?pageNum=" + (currentPage+1));  
			        return true;  
			    }  
			}  
			// 上一页  
			function previousPage(){  
			    if(currentPage == 1){  
			        alert("已经是第一页数据");  
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selMeeting.do?pageNum=" + (currentPage-1));  
			        return true;  
			    }  
			}  
			// 尾页  
			function lastPage(){  
			    if(currentPage == totalPage){  
			    	alert("已经是最后一页数据");
			        return false;  
			    }else{  
			        submitForm("<%=context%>/selMeeting.do?pageNum=${totalPage}");  
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
								<a href=""><cite>会议记录</cite></a>
							</span>
						</div>
				</div>
				<div class="tablist">
					<div class="tabtitle">
	  					<span>会议记录管理及查询</span>
					</div>
				</div>
				<div class="weadmin-block i-block">
					<button class="layui-btn" onclick="WeAdminShow('添加用户','pages/meet/addMeeting.html')"><i class="layui-icon"></i>添加会议记录</button>
				</div>
		<div class="layui-tab-item layui-show " style="overflow-x: scroll; width: 100%;">
			<table class="layui-table i-table">
				<thead>
					<tr>
						<th>记录人</th>
						<th>会议类型</th>
						<th>会议主题</th>
						<th>记录时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="meetingList" items="${requestScope['meetingList']}">
						<tr>
								<td>${meetingList['m_recorder'] }</td>
								<td>${meetingList['m_type'] }</td>
								<td>${meetingList['m_title'] }</td>
								<td>${meetingList['m_createtime'] }</td>
								<td>
									<a href="deleteMeeting.do?m_id=${meetingList['m_id']}" onclick="return confirm('确认要删除此条信息？')">删除</a>
									<a onclick="WeAdminShow('查看内容','meetingContent.do?m_id=${meetingList['m_id']}')">详情</a>
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
	<script>
		layui.use('element', function(){
		  var $ = layui.jquery
		  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
		  var active = {
		    tabAdd: function(){
		      //新增一个Tab项
		      element.tabAdd('demo', {
		        title: '新选项'+ (Math.random()*1000|0) //用于演示
		        ,content: '内容'+ (Math.random()*1000|0)
		        ,id: new Date().getTime() //实际使用一般是规定好的id，这里以时间戳模拟下
		      })
		    }
		    ,tabDelete: function(othis){
		      //删除指定Tab项
		      element.tabDelete('demo', '44'); //删除：“商品管理”
		      
		      
		      othis.addClass('layui-btn-disabled');
		    }
		    ,tabChange: function(){
		      //切换到指定Tab项
		      element.tabChange('demo', '22'); //切换到：用户管理
		    }
		  };
		  
		  $('.site-demo-active').on('click', function(){
		    var othis = $(this), type = othis.data('type');
		    active[type] ? active[type].call(this, othis) : '';
		  });
		 
		  //Hash地址的定位
		  var layid = location.hash.replace(/^#test=/, '');
		  element.tabChange('test', layid);
		  
		  element.on('tab(test)', function(elem){
		    location.hash = 'test='+ $(this).attr('lay-id');
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