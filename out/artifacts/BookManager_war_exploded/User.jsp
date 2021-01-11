<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import=" com.mysql.bean.*"  import=" com.mysql.user.*" import ="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="statics/css/amazeui.min.css">
		<link rel="stylesheet" href="statics/css/admin.css">
		<link rel="stylesheet" href="statics/css/app.css">
</head>
<body>
	<div class="am-cf admin-main" style="padding-top: 0px;">
			<!-- content start -->
			<div class="admin-content">
				<div class="admin-content-body">
					
					<div class="container">
						<div class="am-g">
							<div class="am-u-sm-12 am-u-md-6">
								<div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
										<button type="button" class="am-btn am-btn-default btnAdd">
											<span class="icon-plus"></span> 新增
										</button>

										
									</div>
								</div>
							</div>
							<div class="am-u-sm-12 am-u-md-3">

						
								<div class="am-selected am-dropdown " id="am-selected-dhh2q" data-am-dropdown=""> <button type="button" class="am-selected-btn am-btn am-dropdown-toggle am-btn-sm am-btn-default">     <i class="am-selected-icon am-icon-caret-down"></i>  </button>
									<div class="am-selected-content am-dropdown-content">
										
									
										<div class="am-selected-hint"></div>
									</div>
								</div>
								<div class="am-selected am-dropdown " id="am-selected-z6ofo" data-am-dropdown="">
									<button style="display: none;" type="button" class="am-selected-btn am-btn am-dropdown-toggle am-btn-sm am-btn-default">
										<span class="am-selected-status am-fl">请选择姓名</span>
										<i class="am-selected-icon am-icon-caret-down"></i>
									</button>
									<div class="am-selected-content am-dropdown-content">
										<h2 class="am-selected-header">
											<span class="am-icon-chevron-left">返回</span>
										</h2>
										
										<div class="am-selected-hint"></div>
									</div>
								</div>
							</div>

							<div class="am-u-sm-12 am-u-md-3">
								<div class="am-input-group am-input-group-sm">
									<input class="am-form-field" placeholder="请输入读者姓名" id="username" type="text">
									<span class="am-input-group-btn">
										<button class="am-btn am-btn-default" type="button" id="btnsearch">
											搜索
										</button> </span>
								</div>
							</div>
						</div>
						<div class="am-g" style="margin-top: -30px;">
							<div class="am-u-sm-12">
								<form class="am-form" action="user/delAll.action">
									<table class="am-table am-table-striped am-table-hover table-main">
										<thead>
											<tr>
												<th class="table-check">
													<input id="chkAll" type="checkbox">
												</th>
												
												
												<th class="table-title">
													姓名
												</th>
												<th>
													性别
												</th>
												<th>
													班级
												</th>
												<th>
													书籍
												</th>
												<th>
													借阅时间
												</th>
												<th>
													归还时间
												</th>
												
												<th class="table-set">
													操作
												</th>
											</tr>
										</thead>
										<tbody id="tUser">
											<% BookRentConn bookrentconn=new BookRentConn(); ArrayList<User> list=bookrentconn.list_return(); 
										for (int i=0;i<list.size();i++) {
										%>
											<tr>
												<td><input name="ids" value="1" type="checkbox"></td>
												<td><span class="am-badge am-badge-secondary"><%=list.get(i).getUser()%></span></td>
												<td><%=list.get(i).getSex()%></td>
												<td>
													<a href="#"><%=list.get(i).getGrade()%></a>
												</td>
												<td>
													<%=list.get(i).getBook() %>
												</td>
												<td><span class="am-badge am-badge-secondary"><%=list.get(i).getStart()%></span></td>
												<td><span class="am-badge am-badge-secondary"><%=list.get(i).getEnd()%></span></td>
												<td>
													<div class="am-btn-toolbar">
														<div class="am-btn-group am-btn-group-xs"><button type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary btnEdit"><span class="am-icon-pencil-square-o"></span> 编辑</button><button type="button" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only btnDel" ><span class="am-icon-trash-o"></span> 删除</button></div>
													</div>
												</td>
											</tr>
		<%} %>
		

										</tbody>
									</table>

								</form>
								<% list.clear(); %>
							</div>
						</div>
					</div>

				</div>
				<!-- content end -->
			</div>
		</div>

		<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

		<!--[if (gte IE 9)|!(IE)]><!-->
		<script src="statics/js/jquery-1.11.3.min.js"></script>
		<!--<![endif]-->
		<script type="text/javascript" src="statics/myplugs/js/plugs.js"></script>
		<script>
			$(function() {
				$(".btnAdd").click(function() {
					$.jq_Panel({
						title: "添加用户信息",
						url: "AddUser.jsp",
						iframeWidth: 800,
						iframeHeight: 600,
					});
				});
				$(".btnDel").click(function() {
					$.jq_Panel({
						title: "删除借阅人",
						url: "DelUser.jsp",
						iframeWidth: 800,
						iframeHeight: 600,
					});
				});
				$(".btnEdit").click(function() {
					$.jq_Panel({
						title: "编辑用户",
						url: "EditUser.jsp",
						iframeWidth: 800,
						iframeHeight: 600,
					});

				});

			});
		</script>
</body>
</html>