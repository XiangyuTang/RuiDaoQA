<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>问答系统头_已登录</title>
		<!--<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">-->
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" href="css/global.css">
		<script src="layui/layui.js"></script>
	</head>
	<body>
		<div class="header">
			<div class="main">
				<a class="title" href="index.jsp" target="_parent" title="睿道QA"> 

					<img src="images/logo.png" height="60" width="80"/>

					<i class="iconfont icon-jiaoliu layui-hide-xs" style="font-size: 22px;"></i>
					&nbsp;&nbsp;睿道QA</a>
				
				<form action="searchQues" class="fly-search">
							<input class="layui-input" autocomplete="off" placeholder="搜索你感兴趣的内容" type="text" name="q">
							<i class="iconfont icon-sousuo"></i>
				</form>
				
				<div class="fly-tab">
					<a href="add.html" target="_parent" class="layui-btn jie-add">发布问题</a>
				</div>
				
					<i class="layui-icon icon-jiaoliu layui-hide-xs" style="font-size: 22px;"></i>
					<!--睿道QA--></a>
					
				<div class="nav">
					<a class="nav-this" href="index.jsp">
						<i class="iconfont icon-wenda"></i>欢迎使用</a>
				</div>
				
				<c:if test = "${!empty  applicationScope.CurrentUser}">
					<div class="nav-user" >
						<a class="avatar" href="userinfo.jsp">
						<img src="${ applicationScope.CurrentUser.head_photo}">
						<cite>${ applicationScope.CurrentUser.nick_name}</cite>
						</a>
					<div class="nav">
						<a href="logoutServlet" target="_parent"><i class="iconfont icon-tuichu" style="top: 0; font-size: 22px;"></i>退出</a>
					</div>
					</div>
				</c:if>
				
				<c:if test = "${empty  applicationScope.CurrentUser}">
					<div class="nav-user" >
					  <a   class="iconfont icon-touxiang layui-hide-xs" style="margin-top: 4px; display: inline-block;">
                    </a>
                    <div class="nav"  style="font-size:14px;color: white;margin-top: -5px;margin-left: 1px; "  />
                    	<a href="login.html"  target="_parent" >登录</a>
                    	<a href="register.html" target="_parent" >注册</a>
                    </div>
					</div>
				</c:if>
			</div>
		</div>
		
		

	</body>
</html>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
<script>
	$(function(){
		$('i[class="iconfont icon-sousuo"]').click(function(){
			var searchtxt = $(this).prev().val();
			//1.new
			var xhr = new XMLHttpRequest();
			//2.open
			//注意与get方法时对比，在第二个参数后面不能加？。应该将传递到后台的参数用send()方法传递
			xhr.open('post','searchQues',true);
			//3.send
			//需要加一个头文件，才能用post提交
			xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
			//xhr.send(JSON.stringify(data));
			xhr.send('searchtxt='+searchtxt);
			//xhr.send('question_id='+question_id);
			//4.回调
			xhr.onload = function(){
				console.log(xhr.responseText);
				var ul = document.getElementById('LAY_demo');
				ul.innerHTML = xhr.responseText;
				//flush(ajax.responseText);
			}
			})
	}) 
</script>