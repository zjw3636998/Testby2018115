<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
        <meta charset="UTF-8">
		<title>匠真后台管理系统</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
		<link rel="stylesheet" type="text/css" href="themes/plugs/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="themes/css/reset.css">
		<link rel="stylesheet" type="text/css" href="themes/css/weadmin.css">
		<link rel="stylesheet" href="themes/plugs/trumbowyg/design/css/trumbowyg.css">
		<script type="text/javascript" src="themes/plugs/jquery/jquery.min.js"></script>
	    <script type="text/javascript" src="themes/plugs/bootstrap/js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="themes/plugs/layui/layui.all.js"></script>
	    <script type="text/javascript" src="themes/plugs/Layer/layer.js"></script>
    </head>
    <body>
    	<div class="artWrap">
    		<div class="art-container">
    			<form action="addCase.do" class="artDet-con" id="artDelform" name="artdelF" method="post">
    				<div class="art-form-item">
    					<label for="" class="art-label-con">案例标题</label>
    					<div class="art-input-block">
    						<input type="text" class="art-input" name="arttitle" placeholder="请输入案例题目" >
    					</div>
    				</div>
    				<div class="art-form-item">
						<label for="username" class="art-label-con">
	                  		所属行业
	              		</label>
			            <div class="i-case-select">
		                  <select name="caseType">
		                  <i class="layui-edge"></i>	
		                 	<option value="0">行业类型</option>
		                  	<c:forEach var="caseList" items="${requestScope['caseList']}">
		                   		<option value="${caseList['caseType_id']}">${caseList['caseType_name']}</option>
		                    </c:forEach>
		                  </select>
	              		</div>
					</div>
    				<div class="art-form-item">
    					<label for="" class="art-label-con">案例描述</label>
    					<div class="art-input-block">
    						<div class="art-edit" style="width: 80%; margin-left:-14px; margin-top: -14px;">
								<textarea class="art_content" name="descript"></textarea>
							</div>
    					</div>
    				</div>
    				<div class="art-form-item">
    					<label for="" class="art-label-con">问题聚焦</label>
    					<div class="art-input-block">
    						<div class="art-edit" style="width: 80%; margin-left:-14px; margin-top: -14px;">
								<textarea class="art_content" name="question"></textarea>
							</div>
    					</div>
    				</div>
    				<div class="art-form-item">
    					<label for="" class="art-label-con">解决办法</label>
    					<div class="art-input-block">
    						<div class="art-edit" style="width: 80%; margin-left:-14px; margin-top: -14px;">
								<textarea class="art_content" name="answer"></textarea>
							</div>
    					</div>
    				</div>
    				<div class="art-form-item">
    					<label for="" class="art-label-con">取得效果</label>
    					<div class="art-input-block">
    						<div class="art-edit" style="width: 80%; margin-left:-14px; margin-top: -14px;">
								<textarea class="art_content" name="result"></textarea>
							</div>
    					</div>
    				</div>
    				<div class="art-form-item">
    					<div class="art-btn-block">
							<input class="set-btn"  type="button" value="提交内容"   onclick="SendForm();">
							<input class="set-btn set-btn-primary" type="reset" value="重置"  onclick="clearForm()">
						</div>
    				</div>
    			</form>
    		</div>
    	</div>
    	<script src="themes/plugs/trumbowyg/trumbowyg.min.js"></script>
        <script src="themes/plugs/trumbowyg/langs/fr.js"></script>
        <script src="themes/plugs/trumbowyg/plugins/upload/trumbowyg.upload.min.js"></script>
        <script src="themes/plugs/trumbowyg/plugins/base64/trumbowyg.base64.js"></script>
        <script>
        		$('.art_content').trumbowyg();
  				$('.art_content').trumbowyg({
              			 //设置中文
              			 lang: 'zh_cn',
              			 // closable: true,
              			 fixedBtnPane: true,
              			 //设置颜色插件
              			 btnsAdd: ['foreColor','backColor'],
              			  btnsDef: {
        				// 设置上传的3种方法，远程上传，本地上传，图片64位加密
        				image: {
        				            dropdown: ['insertImage', 'upload','base64'],
        				            ico: 'insertImage'
        				        }
        				    },
        				        // Redefine the button pane
        				        btns: ['viewHTML',
        				                '|', 'formatting',
        				                '|', 'btnGrp-semantic',
        				                '|', 'link',
        				                '|', 'image',
        				                '|', 'btnGrp-justify',
        				                '|', 'btnGrp-lists',
        				                '|', 'horizontalRule']
        		});

  					function check(){
  						var art_tit=document.artdelF.arttitle.value;
						if(art_tit =="" || art_tit.length< 3 || art_tit.length>30) {
							alert('格式不正确1');
							return false;
						}else{
							document.artdelF.submit();
							return true;
						}
						
					};
					 function SendForm(){
   					     if(check()) 
   					     {
   					         document.artdelF.submit();
   					     }
   					 }; 
   					function clearForm(){
						document.getElementById("artDelform").reset()
					}
   					
  				
        </script>
    </body>
</html>