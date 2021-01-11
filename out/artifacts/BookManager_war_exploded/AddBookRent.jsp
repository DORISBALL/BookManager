<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
						<form class="am-form am-form-horizontal" action="AddRentServlet" method="post" >
							<input value="504" name="roleId" type="hidden" >
							<div class="am-form-group">
							
							<label for="user-name" class="am-u-sm-3 am-form-label">
									丢失书名
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入丢失书名" value="" name="bookname" type="text">
									</div>
							
								<label for="user-name" class="am-u-sm-3 am-form-label">
									丢失数量
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="丢失数量" value="" name="number" type="text">
									</div>		
							
							</div>
						
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="" class="am-btn am-btn-success" value="添加丢失书籍" type="submit">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
</body>
</html>