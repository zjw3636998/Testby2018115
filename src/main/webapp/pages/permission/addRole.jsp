<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE>
<html>
	<head>
		<meta charset="UTF-8">
		<title>权限设置</title>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" type="text/css" href="themes/css/reset.css">
		<link rel="stylesheet" type="text/css" href="themes/plugs/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="themes/css/weadmin.css">
		<link rel="stylesheet" href="themes/plugs/trumbowyg/design/css/trumbowyg.css">
		<script type="text/javascript" src="themes/plugs/jquery/jquery.min.js"></script>
	    <script type="text/javascript" src="themes/plugs/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="themes/plugs/layui/layui/layui.all.js"></script>
	    <script type="text/javascript" src="themes/plugs/Layer/layer.js"></script>
		<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
		<!--[if lt IE 9]>
	      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
	      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	</head>

	<body>
		<div class="i-body">
			<form class="layui-form i-role-form">
				<div class="layui-form-item i-form-item">
      				<label class="layui-form-label i-role-label">角色${fn:length(perList.per_p)} </label>
      				<div class="layui-input-block i-input-block">
							<input type="text" name="uername" lay-verify="required" jq-error="请输入分类名称"  autocomplete="off" class="layui-input i-input">
					</div>  	
   			 	</div>
				<div class="layui-form-item i-form-item">
      					<label class="layui-form-label i-role-label">权限范围</label>
      					<div class="layui-input-block i-input-block">
							<table style="height:652px; border:2px solid #eee;"  border="1" cellpadding="1" cellspacing="1" align="center">
 								<thead>
 								</thead>
 								<tbody>
 									<c:forEach var="perList" items="${requestScope['perList']}">
 									<tr>
 										<td width="80px" height="50px" rowspan="13" align="center">
 											<span>角色管理</span>
 										</td> 
 										<td  width="140px" height="50px" rowspan="4" align="center" class="second-td">
 											<span>互联网</span><form name=""><input type="checkbox" id="rolecheckone" value="2"></form>
 										</td>
 										<td  width="560px" height="50px" colspan="3">
 											 <div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="roleitems" value="21">
 											</div> 
 										</td>
 									</tr>	
 									<tr>
										<td  width="140px" height="50px" colspan="4">
											<div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="roleitems">
 											</div>
										</td>
 									</tr>				
 									<tr>
 										<td  width="140px" height="50px" >
 											<div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="roleitems">
 											</div>
 										</td>
 									</tr>
 									<tr>
 										<td  width="140px" height="50px" >
 											<div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="roleitems">
 											</div>
 										</td>
 									</tr> 
 									<tr>
 										<td  width="140px" height="50px" rowspan="1" align="center" class="second-td">
 											<span>咨询</span><form name=""><input type="checkbox" id="rolechecktwo" value="3"></form>
 										</td>
 										<td  width="140px" height="50px">
 											<div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="twoitems" value="31">
 											</div>
 										</td>
 									</tr>
 									<tr>
 										<td  width="140px" height="50px" rowspan="4" align="center" class="second-td">
 											<span>业务</span><form name=""><input type="checkbox" id="rolecheckthree" value="4"></form>
 										</td>
 										<td  width="300px" height="50px" >
 											<div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="threeitems" value="41">
 											</div>
 										</td>
 										
 									</tr>
 									<tr>
 										<td  width="300px" height="50px" >
 											<div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="threeitems">
 											</div>
 										</td>
 									</tr>						
 									<tr>
 										
 										<td  width="300px" height="50px" >
 											<div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="threeitems">
 											</div>
 										</td>
 										
 									</tr>
 									<tr>
 										
 										<td  width="500px" height="50px" >
 											<div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="threeitems">
 											</div>
 										</td>
 										
 									</tr>
 									<tr>
 										<td  width="140px" height="50px" rowspan="2" align="center" class="second-td">
 											<span>行政</span><form name=""><input type="checkbox" id="rolecheckfour" value="5"></form>
 										</td>
 										<td  width="140px" height="50px" >
 											<div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="fouritems" value="51">
 											</div>
 										</td>
 										
 									</tr>
 									<tr>
 										
 										<td  width="140px" height="50px" >
 											<div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="fouritems">
 											</div>
 										</td>
 										
 									</tr>
 									<tr>
 										<td  width="140px" height="50px" rowspan="2" align="center" class="second-td">
 											<span>财务</span><form name=""><input type="checkbox" id="rolecheckfive" value="6"></form>
 										</td>
 										<td  width="140px" height="50px">
 											<div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="fiveitems" value="61">
 											</div>
 										</td>
 										
 									</tr>
 									<tr>
 										<td  width="140px" height="50px" >
 											<div class="i-checkbox-sle">
 												<span>内容系统</span><input type="checkbox" name="fiveitems">
 											</div>
 										</td>
 									</tr>
 									</c:forEach>
 								</tbody>
							</table>
						</div> 
      			</div>
				<div class="layui-form-item layui-form-text i-form-item">
					<label for="desc" class="layui-form-label i-role-label">
                        描述
                    </label>
					<div class="layui-input-block">
						<textarea placeholder="请输入内容" id="desc" name="desc" class="layui-textarea i-role-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item i-role-item">
					<button class="layui-btn i-role-btn"  id="btnchange">修改</button>
				</div>
			</form>
		</div>
		<script type="text/javascript">
			
			$(function(){
				
				$("#rolecheckone").click(function() { 
			
					var flag=this.checked;
					$(":checkbox[name='roleitems']").prop('checked',flag);
				});
		
		//而且还实现了:当其中不勾选某一个选项的时候,则去掉全选复选框
					$(":checkbox[name='roleitems']").click(function(){
					
						$("#rolecheckone").prop('checked',
						$(":checkbox[name='roleitems']").length==$(":checkbox[name='roleitems']:checked").length);
					});


				$("#rolechecktwo").click(function() { 
			
					var flag=this.checked;
					$(":checkbox[name='twoitems']").prop('checked',flag);
				});
		
		//而且还实现了:当其中不勾选某一个选项的时候,则去掉全选复选框
					$(":checkbox[name='twoitems']").click(function(){
					
						$("#rolechecktwo").prop('checked',
						$(":checkbox[name='twoitems']").length==$(":checkbox[name='twoitems']:checked").length);
					});

					$("#rolecheckthree").click(function() { 
			
					var flag=this.checked;
					$(":checkbox[name='threeitems']").prop('checked',flag);
				});
		
		//而且还实现了:当其中不勾选某一个选项的时候,则去掉全选复选框
					$(":checkbox[name='threeitems']").click(function(){
					
						$("#rolecheckthree").prop('checked',
						$(":checkbox[name='threeitems']").length==$(":checkbox[name='threeitems']:checked").length);
					});



					$("#rolecheckfour").click(function() { 
			
					var flag=this.checked;
					$(":checkbox[name='fouritems']").prop('checked',flag);
				});
		
		//而且还实现了:当其中不勾选某一个选项的时候,则去掉全选复选框
					$(":checkbox[name='fouritems']").click(function(){
					
						$("#rolecheckfour").prop('checked',
						$(":checkbox[name='fouritems']").length==$(":checkbox[name='fouritems']:checked").length);
					});


					$("#rolecheckfive").click(function() { 
			
					var flag=this.checked;
					$(":checkbox[name='fiveitems']").prop('checked',flag);
				});
		
		//而且还实现了:当其中不勾选某一个选项的时候,则去掉全选复选框
					$(":checkbox[name='fiveitems']").click(function(){
					
						$("#rolecheckfive").prop('checked',
						$(":checkbox[name='fiveitems']").length==$(":checkbox[name='fiveitems']:checked").length);
					});




		$(function(){
			/*$("#roleForm").submit(function(){
				var index=parent.layer.getFrameIndex(window.name);
        		parent.layer.close(index); //再执行关闭
        		$.ajax({
           			async: false,
           			type: "post",
           			url:'',
           			contentType : "application/x-www-form-urlencoded; charset=utf-8",
           			data:$("#roleForm").serialize(),
           			dataType: "json",
           			success: function () {
           			  },
           			error: function () {
           			}
        		})
   			})*/
			
				/*alert("所有checkbox的值：" + idsstr);*/
			$("#btnchange").click(function(){
				var idsstr = "";
				var zhi = "";
				var fuqin = '';
				$(".i-body input[type=checkbox]").each(function(){ //遍历table里的全部checkbox	
					idsstr += $(this).val() + ","; //获取所有checkbox的值
					
					
				});
				if(idsstr.length > 0) //如果获取到
					idsstr = idsstr.substring(0, idsstr.length - 1); //把最后一个逗号去掉
				$(".i-body input[type=checkbox]:checked").each(function(){ //遍历table里的全部checkbox
					alert($(this).parent())
					fuqin += $(this).parent().val() + ","	
					zhi += $(this).val() + ","; //获取所有checkbox的值
					if(zhi.length > 0){ //如果获取到
					zhi = zhi.substring(0, zhi.length - 1); //把最后一个逗号去掉
					/*console.log("被选中checkbox的值：" + zhi);*/
					fuqin = fuqin.substring(0, fuqin.length - 1);
				}
					
				});
				
				/*alert("被选中checkbox的值：" + fuqin)*/
			})
			
		});
	})
			
		</script>
	</body>

</html>