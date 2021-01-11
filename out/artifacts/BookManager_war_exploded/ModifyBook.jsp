<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改书籍</title>
	<link rel="stylesheet" href="statics/css/amazeui.min.css">
		<link rel="stylesheet" href="statics/css/admin.css">
		<link rel="stylesheet" href="statics/css/app.css">
		<style>
			.admin-main{
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
						<form class="am-form am-form-horizontal" action="ModifybookServlet" method="post" >
							<input value="504" name="roleId" type="hidden" >
							<div class="am-form-group">
							
							<label for="user-name" class="am-u-sm-3 am-form-label">
									书名
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入书名" value="" name="bookname" type="text">
									</div>
							
								<label for="user-name" class="am-u-sm-3 am-form-label">
									ISBN号
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="ISBN号" value="" name="isbn" type="text">
									</div>
								
									
									
									
								<label for="user-name" class="am-u-sm-3 am-form-label">
									价格
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入价格" value="" name="price" type="text">
								</div>
								
								
									
								<label for="user-name" class="am-u-sm-3 am-form-label">
									作者
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入作者" value="" name="author" type="text">
								</div>
								
								
									
								<label for="user-name" class="am-u-sm-3 am-form-label">
									出版社
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入出版社" value="" name="publish" type="text">	
								</div>
								
							</div>
						
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="" class="am-btn am-btn-success" value="修改书籍" type="submit">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>