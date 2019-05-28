<%@page import="com.neu.ruidaoQA.entity.User"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户信息</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link type="text/css" rel="stylesheet" href="css/userMessage.css" />
</head>

<body>
	<%
	    List<User> list = (List<User>) request.getAttribute("List");
	%>
	<div class="userMes">
		<div class="userMes_inside">
			<!-- 显示用户信息 -->
			<div class="userMes_table">
				<table class="contentTable">
					<thead>
						<tr class="contentTable1">
							<td>用户编号</td>
							<td>昵称</td>
							<td>性别</td>
							<td>简介</td>
						</tr>
					</thead>
					<tbody class="tb">
						<%
							if(list.size()>0){
						    for (int i = 0; i < list.size(); i++) {
						        User user = list.get(i);
						%>
						<tr>
							<td><%=user.getUser_id()%></td>
							<td ><%=user.getNick_name()%></td>
							<td><%=user.getSex()%></td>
							<td class="hideTd" id="hideId"><%=user.getBirthday()%></td>
							<td class="hideTd" id="hideSd"><%=user.getEmail()%></td>
							<td><%=user.getIntroduce()%></td>
							

							
							<td class="tdWidth">
								<!-- <input class="buttonMod" type="button" value="编辑" onclick="modifyTr(this);" />&nbsp;&nbsp;  -->
								<a class="aType" href="DelGuanZhuServlet?id=<%=user.getUser_id()%>">取消关注</a>&nbsp;&nbsp;
								<input class="buttonLok" type="button" value="查看" onclick="lookTr(this);" />
							</td>
						</tr>
						<%
						      }
						    }
						%>
					</tbody>
				</table>
			</div>
		</div>
		<!-- 查看用户信息 -->
		<div class="overLook" id="overLook" style="display:none;">
			<div class="overLook_child">
				<p class="locationP">用户信息如下</p>
				<table>
					<tbody id="overLook_tb">
						<tr>
							<td>用户编号：</td>
							<td><input type="text" disabled></td>
						</tr>
						<tr>
							<td>昵称：</td>
							<td><input type="text" disabled></td>
						</tr>
						<tr>
							<td>性别：</td>
							<td><input type="text" disabled></td>
						</tr>
						<tr>
							<td>生日：</td>
							<td><input type="text" disabled></td>
						</tr>
						<tr>
							<td>邮箱：</td>
							<td><input type="text" disabled></td>
						</tr>
						<tr>
							<td>简介：</td>
							<td><input type="text" disabled></td>
						</tr>
						<!-- <tr>
							<td>密码：</td>
							<td><input type="text" disabled></td>
						</tr> -->
					</tbody>
					<tr>
						<td><input type="button" value="取消" class="button" onclick="cancelLook(this);" /></td>
					</tr>
				</table>
				<div class="string"></div>
			</div>
		</div>
		<!-- 修改用户信息 -->
		<div class="overLook1" id="overLook1" style="display:none;">
			<div class="overLook_child1">
				<p class="locationP">请填写如下信息</p>
				<form action="ModifyUserServlet" onsubmit="return modifyUser()">
					<table>
						<tbody id="overLook_tb1">
						<tr>
							<td>用户编号：</td>
							<td><input type="text" name="user_id" id="user_id"></td>
						</tr>
						<tr>
							<td>昵称：</td>
							<td><input type="text" name="nickname" id="nickname"></td>
						</tr>
						<tr>
							<td>性别：</td>
							<td	><input type="text" name="sex" id="sex"></td>
						</tr>
						<tr>
							<td>生日：</td>
							<td><input type="text" name="birthday" id="birthday"></td>
						</tr>
						<tr>
							<td>邮箱：</td>
							<td><input type="text" name="email" id="email"></td>
						</tr>
						<tr>
							<td>简介：</td>
							<td><input type="text" name="introduce" id="introduce"></td>
						</tr>
						<tr>
							<td>密码：</td>
							<td><input type="text" name="password" id="password"></td>
						</tr>
						</tbody>
						<tr>
							<td>
								<input class="modSubmit" type="submit" value="确定">
								<input type="button" value="取消" class="button" onclick="modifyMes(this);" />
						</tr>
					</table>
				</form>
				<div class="string"></div>
			</div>
		</div>
		
	</div>
	<script type="text/javascript" src="js/admin.js"></script>
</body>
</html>
