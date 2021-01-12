<%@ page import="com.gdut.model.UserInfo" %>
<%@ page import="com.gdut.model.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8	">
   <link rel="stylesheet" href="statics/css/amazeui.min.css">
		<link rel="stylesheet" href="statics/css/admin.css">
		<link rel="stylesheet" href="statics/css/app.css">
<title>Insert title here</title>
</head>
<body>
		<%
			UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		%>
		<div class="am-cf admin-main">
		<!-- content start -->
		<div class="admin-content">
			<div class="admin-content-body" >
				<div class="am-g" style="margin: 50px">
					<form class="am-form am-form-horizontal" style="margin-left: -300px;"
						 method="post" data-am-validator action="ModifyPwdServlet">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">用户ID </label>
							<div class="am-u-sm-9">
								<label type="text" id="doc-vld-pwd-1" name="userId"><%=userInfo.getUserId()%></label>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								用户名</label>
							<div class="am-u-sm-9">
								<label type="password" id="doc-vld-pwd-2" name="username"><%=userInfo.getUsername()%></label>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								年龄</label>
							<div class="am-u-sm-9">
								<label type="password" id="doc-vld-pwd-2" name="username"><%=userInfo.getAge()%></label>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								性别</label>
							<div class="am-u-sm-9">
								<label type="password" id="doc-vld-pwd-2" name="username"><%=userInfo.getSex()%></label>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								账户余额</label>
							<div class="am-u-sm-9">
								<label type="password" id="doc-vld-pwd-2" name="username"><%=userInfo.getAccount()%></label>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								新密码</label>
							<div class="am-u-sm-9">
								<input type="text" id="doc-vld-pwd-1" name="newPassword" placeholder="请输入新密码" style="width: 300px"/>
							</div>
						</div>

						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<input type="submit" class="am-btn am-btn-success" value="修改密码" />
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="assets/js/libs/jquery-1.10.2.min.js">
	</script>
	<script type="text/javascript" src="statics/myplugs/js/plugs.js">
	</script>
</body>
</html>