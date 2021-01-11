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
		<div class="am-cf admin-main">
		<!-- content start -->
		<div class="admin-content">
			<div class="admin-content-body" >
				<div class="am-g" >
					<form class="am-form am-form-horizontal" style="margin-left: -300px;"
						 method="post"
						style="padding-top:30px;" data-am-validator action="ModifyPwdServlet">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
							账号 </label>
							<div class="am-u-sm-9">
								<input type="text" id="doc-vld-pwd-1"  required placeholder="请输入用户名" 
									name="username"> 
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">
								密码</label>
							<div class="am-u-sm-9">
								<input type="password" id="doc-vld-pwd-2" required placeholder="请输入密码" 
									name="password"  data-equal-to="#doc-vld-pwd-1"  required> 
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