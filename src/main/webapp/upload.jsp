<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="upload.do" method="post" enctype="multipart/form-data">
		      <label for="sourceModule" >上传文件:</label>
		      <input type="file" name="file"/><br/>  
		      <input type="text" name="fileName">文件名称
		      <input type="submit" value="提交" /><br/> 
	</form>
</body>
</html>