<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户</title>

		<link rel="stylesheet" href="statics/css/amazeui.min.css">
		<link rel="stylesheet" href="statics/css/admin.css">
		<link rel="stylesheet" href="statics/css/app.css">
		<style>
			.admin-main {
				padding-top: 0px;
			}
		</style>
</head>
<body>

		<div class="am-cf admin-main">
			<!-- content start -->
			<div class="admin-content">
				<div class="admin-content-body">
					<div class="am-g">
						<form class="am-form am-form-horizontal" action="RentBookServlet" method="post" style="padding-top: 30px;">
							<input value="504" name="roleId" type="hidden">
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								姓名
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入姓名" value="" name="name" type="text">
									
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								性别
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入性别" value="" name="sex" type="text">
									
								</div>
								
							</div>
							
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								班级
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入班级" value="" name="grade" type="text">
									
								</div>
							</div>
					<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								借阅书籍
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入书籍" value="" name="book" type="text">
									
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
										借阅时间
									</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入借阅时间" value="" name="start" type="text">
									
								</div>
							</div>

							
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
										归还时间
									</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入归还时间" value="" name="end" type="text">
									
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="addRole" class="am-btn am-btn-success" value="提交" type="submit">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>