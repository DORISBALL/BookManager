<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图书管理登录</title>
<style type="text/css">
			body{
				margin: 0;
				padding: 0;
				font-family: sans-serif;
				background: #34495e;
			}
			.box{
				width: 400px;
				padding: 60px;
				position: absolute;
				top: 50%;
				left: 50%;
				transform: translate(-50%,-50%);
				background: #191919;
				text-align: center;
			}
			.box h1{
				color: white;
				text-transform: uppercase;
				font-weight: 500;
			}
			.box input[type="text"],.box input[type="password"]{
				border: 0;
				background: none;
				display: block;
				margin: 20px auto;
				text-align: center;
				border: 2px solid #3498db;
				padding: 14px,10px;
				width: 200px;
				height: 30px;
				outline: none;
				color: white;
				border-radius: 24px;
				transition: 0.25s;
			}
			.box input[type="text"]:focus,.box input[type="password"]:focus{
				width: 280px;
				border: #2ecc71;
			}
			.box input[type="submit"],.box input[type="button"]{
				border: 0;
				background: none;
				display: block;
				margin: 20px auto;
				text-align: center;
				border: 2px solid #3498db;
				padding: 14px ,40px;
				width: 200px;
				height: 30px;
				outline: none;
				color: white;
				border-radius: 24px;
				transition: 0.25s;
				cursor: pointer;
				
			}
			.box input[type="submit"]:hover{
				background: #3498db;
			}
			
		</style>
</head>
<body>
<form  class="box"  action="MyServlet" method="post">
			<h1>图书管理登录</h1>
			<input type="text" name="userId"  value=""  placeholder="用户名"/>
			<input type="password" name="password"  value="" placeholder="密码" />
			<label>身份:</label>
			<label>用户</label>
			<input type="radio" value="1" name="usertype">
			<label>管理员</label>
			<input type="radio" value="2" name="usertype">
			<input type="submit" name="login" id="" value="登录" />
			<input type="button" onclick="javascript:window.location.href='Register.jsp';" value="注册" />
		</form>
</body>
</html>