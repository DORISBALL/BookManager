<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<link rel="Bookmark" href="/favicon.ico">
		<link rel="Shortcut Icon" href="/favicon.ico" />
		<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
		<link rel="stylesheet" type="text/css" href="statics/css/H-ui.min.css" />
		<link rel="stylesheet" type="text/css" href="statics/css/H-ui.admin.css" />
		<link rel="stylesheet" type="text/css" href="statics/css/Hui-iconfont/1.0.8/iconfont.css" />
		<link rel="stylesheet" type="text/css" href="statics/skin/default/skin.css" id="skin" />
		<link rel="stylesheet" type="text/css" href="statics/css/style.css" />
		<!--[if IE 6]>
<script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
<script>DD_belatedPNG.fix('*');</script>
<![endif]-->
<title>图书管理员界面</title>
</head>
<body>
<%
		String list = (String) session.getAttribute("username");
		%>
	<header class="navbar-wrapper">
			<div class="navbar navbar-fixed-top">
				<div class="container-fluid cl">
					<a class="logo navbar-logo f-l mr-10 hidden-xs" href="/aboutHui.shtml">图书管理系统</a>
					<a class="logo navbar-logo-m f-l mr-10 visible-xs" href="/aboutHui.shtml">图书管理系统</a>
					<span class="logo navbar-slogan f-l mr-10 hidden-xs">管理员</span>
					<a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>

					<nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
						<ul class="cl">
							<li>管理员</li>
							<li class="dropDown dropDown_hover">
								<a href="#" class="dropDown_A"><%=list %> <i class="Hui-iconfont">&#xe6d5;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li>
										<a href="#">退出</a>
									</li>
								</ul>
							</li>
							<li id="Hui-msg">
								<a href="#" title="消息"><span class="badge badge-danger">1</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a>
							</li>
							<li id="Hui-skin" class="dropDown right dropDown_hover">
								<a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
								<ul class="dropDown-menu menu radius box-shadow">
									<li>
										<a href="javascript:;" data-val="default" title="默认（黑色）">默认（黑色）</a>
									</li>
									<li>
										<a href="javascript:;" data-val="blue" title="蓝色">蓝色</a>
									</li>
									<li>
										<a href="javascript:;" data-val="green" title="绿色">绿色</a>
									</li>
									<li>
										<a href="javascript:;" data-val="red" title="红色">红色</a>
									</li>
									<li>
										<a href="javascript:;" data-val="yellow" title="黄色">黄色</a>
									</li>
									<li>
										<a href="javascript:;" data-val="orange" title="橙色">橙色</a>
									</li>
								</ul>
							</li>
						</ul>
					</nav>
				</div>
			</div>
		</header>
		<aside class="Hui-aside">
			<div class="menu_dropdown bk_2">

				<dl id="menu-admin">
					<dt><i class="Hui-iconfont">&#xe62d;</i>书籍管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
					<dd>
						<ul>

							<li>
								<a data-href="BookInfo.jsp" data-title="书籍信息" href="javascript:void(0)">书籍信息</a>
							</li>
						</ul>
					</dd>
				</dl>
			
				<dl id="menu-product">
					<dt><i class="Hui-iconfont">&#xe620;</i> 读者管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
					<dd>
						<ul>
							<li>
								<a data-href="User.jsp" data-title="查询读者信息" href="javascript:void(0)">用户列表</a>
							</li>

						</ul>
					</dd>
				</dl>

				</dl>
		

				<dl id="menu-tongji">
					<dt><i class="Hui-iconfont">&#xe61a;</i> 查询统计<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
					<dd>
						<ul>
							<li>
								<a data-href="Charts.jsp" data-title="折线图" href="javascript:void(0)">统计图</a>
							</li>

						</ul>
					</dd>
				</dl>
				<dl id="menu-system">
					<dt><i class="Hui-iconfont">&#xe62e;</i> 登记书籍<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
					<dd>
						<ul>
							<li>
								<a data-href="BookManager.jsp" data-title="书籍管理" href="javascript:void(0)">书籍管理</a>
							</li>
						</ul>
					</dd>
				</dl>
				<dl id="menu-system">
					<dt><i class="Hui-iconfont">&#xe62e;</i> 账号管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
					<dd>
						<ul>
							<li>
								<a data-href="UpdatePwd.jsp" data-title="系统日志" href="javascript:void(0)">修改密码</a>
							</li>
						</ul>
					</dd>
				</dl>
			</div>
		</aside>

		<section class="Hui-article-box">
			<div id="Hui-tabNav" class="Hui-tabNav hidden-xs" style="display: none;">
				<div class="Hui-tabNav-wp">
					<ul id="min_title_list" class="acrossTab cl">
						<li class="active">
							<span title="我的桌面" data-href="role.html">我的桌面</span>
							<em></em></li>
					</ul>
				</div>
				<div class="Hui-tabNav-more btn-group">
					<a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a>
					<a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a>
				</div>
			</div>
			<div id="iframe_box" class="Hui-article">
				<div class="show_iframe">
					<div class="loading"></div>
					<iframe scrolling="yes" frameborder="0" src="Role.jsp"></iframe>
				</div>
			</div>
		</section>

		<div class="contextMenu" id="Huiadminmenu">
			<ul>
				<li id="closethis">关闭当前 </li>
				<li id="closeall">关闭全部 </li>
			</ul>
		</div>
		<!--_footer 作为公共模版分离出去-->
		<script type="text/javascript" src="statics/js/jquery.min.js"></script>
		<script type="text/javascript" src="statics/js/layer.js"></script>
		<script type="text/javascript" src="statics/js/H-ui.min.js"></script>
		<script type="text/javascript" src="statics/js/H-ui.admin.js"></script>
		<!--/_footer 作为公共模版分离出去-->

		<!--请在下方写此页面业务相关的脚本-->
		<script type="text/javascript" src="lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
		<script type="text/javascript">
			$(function() {
				/*$("#min_title_list li").contextMenu('Huiadminmenu', {
					bindings: {
						'closethis': function(t) {
							console.log(t);
							if(t.find("i")){
								t.find("i").trigger("click");
							}		
						},
						'closeall': function(t) {
							alert('Trigger was '+t.id+'\nAction was Email');
						},
					}
				});*/
			});
			

			/*用户-添加*/
			function member_add(title, url, w, h) {
				layer_show(title, url, w, h);
			}
		</script>
</body>
</html>