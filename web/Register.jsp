<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>注册界面</title>
 <style>

       .container1 {
            margin-top: 70px;
            width: 45%;
            margin-left: 30%;
        }

        /* 需要在一行的元素 */
        .inline-style {
            display: inline-block;
        }
        /* 文字需要靠右 */
        .font-position-right{
            text-align: right;
        }
        /* 注册按钮 */
        .register-btn{
            margin-left: 10%;
        }


    </style>
    
    <!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container1">

    <form class="form-horizontal" method="post" action="RegisterServlet">
        <div class="form-group">
            <!--<h2 class="form-signin-heading">注册</h2>-->
            <!-- class="sr-only"将label标签隐藏 -->
            <label for="exampleInputUsername1" class="col-sm-2 control-label inline-style font-position-right">用户名</label>
            <div class="col-sm-9 inline-style ">
                <input type="text" class="form-control" name="username" placeholder="用户名">
            </div>
        </div>
        <div class="form-group">
            <!--<h2 class="form-signin-heading">注册</h2>-->
            <label for="exampleInputUsername1" class="col-sm-2 control-label  inline-style font-position-right">密码</label>
            <div class="col-sm-9  inline-style">
                <input type="password" class="form-control" name="password" placeholder="密码">
            </div>
        </div>
     
     
          <div class="form-group">
           	<label for="exampleInputUsername1" class="col-sm-2 control-label  inline-style font-position-right">身份:</label>
			<label >用户</label>
			<input type="radio" value="1" name="usertype">
			<label >管理员</label>
			<input type="radio" value="2" name="usertype">
        </div>
     
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button class="btn btn-lg btn-primary btn-block register-btn" type="submit">注册</button>
            </div>

        </div>
    </form>

</div>
</body>
</html>