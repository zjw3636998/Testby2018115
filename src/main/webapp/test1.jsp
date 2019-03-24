<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%  
    // 获取请求的上下文  
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
        submitForm("<%=context%>/selFile.do?pageNum=1");  
        return true;  
    }  
}  
  
// 下一页  
function nextPage(){  
    if(currentPage == totalPage){  
        alert("已经是最后一页数据");  
        return false;  
    }else{  
        submitForm("<%=context%>/selFile.do?pageNum=" + (currentPage+1));  
        return true;  
    }  
}  
  
// 上一页  
function previousPage(){  
    if(currentPage == 1){  
        alert("已经是第一页数据");  
        return false;  
    }else{  
        submitForm("<%=context%>/selFile.do?pageNum=" + (currentPage-1));  
        return true;  
    }  
}  
  
// 尾页  
function lastPage(){  
    if(currentPage == totalPage){  
        return false;  
    }else{  
        submitForm("<%=context%>/selFile.do?pageNum=${totalPage}");  
            return true;  
        }  
    }  
</script>
</head>
<body>
				<table class="table">
					<thead>
						<tr>
							<th>姓名</th>
							<th>企业名称</th>
							<th>所属行业</th>
							<th>订单创建时间</th>
							<th>订单创建时间</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="wechatList" items="${requestScope['wechatList']}">
							<tr>
								<td>${wechatList['file_id']}</td>
								<td><a href="${fileList.file_url}">${fileList['file_name']}</a></td>
								<td><button onclick="download('${fileList.file_url}')">下载</button></td>
								<td>${fileList['file_type']}</td>
								<td>${fileList['file_user']}</td>
								<td><button onclick="delFile('${fileList.file_url}')">删除</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<script src="jquery-1.7.2.min.js" type="text/javascript"></script>
				<div>
		共${totalPage }页  当前第${currentPage}页    
    	<a href="#" onclick="firstPage();">首页</a>  
    	<a href="#" onclick="previousPage();">上一页</a>  
    	<a href="#" onclick="nextPage();">下一页</a>  
   		<a href="#" onclick="lastPage();">尾页</a>
	</div>
	分类:<input type="text" id="type">
	搜索内容:<input type="text" id="content">
	<button id="searchall">搜索</button>	
	<script type="text/javascript">
				$(function(){
					$("#searchall").click(function(){
						window.location.href="<%=context%>/selFile.do?searchContent="+encodeURI(encodeURI($("#content").val()))+"&searchType="+encodeURI($("#type").val());
					})
				})
				function download(e){
					$.ajax({
						url: "<%=context%>/downloadFile.do",
						data : {'fileUrl':e},
	                     dataType:"json",
	                     type: "POST",
	                     success: function (data){
	                    	 
	                     }
					})
				}
				function delFile(e){
					$.ajax({
						url: "<%=context%>/deleteFile.do",
						data : {'fileUrl':e},
	                     dataType:"json",
	                     type: "POST",
	                     success: function (data){
	                    	 alert(data);
	                     }
					})
				}
	</script>
</body>
</html>