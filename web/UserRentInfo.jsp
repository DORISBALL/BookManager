<%@ page import="com.gdut.model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.gdut.dao.BookRentDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户借阅图书</title>
    <link rel="stylesheet" href="statics/css/amazeui.min.css">
    <link rel="stylesheet" href="statics/css/admin.css">
    <link rel="stylesheet" href="statics/css/app.css">
</head>
<body>
<%
    String userId = (String) session.getAttribute("userId");
%>
<div class="am-cf admin-main" style="padding-top: 0px;">
    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">

            <div class="container">
                <div class="am-g">

                    <div class="am-u-sm-12 am-u-md-3">
                        <div class="am-input-group am-input-group-sm" style="margin: 30px; display: block">
                            <input class="am-form-field" id="userId" placeholder="请输入书籍名称" type="text" value="">
                            <button type="button" name="search">搜索</button>
                        </div>
                    </div>
                </div>
                <div class="am-g" style="margin: 30px; display: block">
                    <div class="am-u-sm-12">
                        <form class="am-form" action="user/delAll.action">
                            <table class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                <tr>
                                    <th class="table-title">
                                        用户ID
                                    </th>
                                    <th>
                                        性别
                                    </th>
                                    <th>
                                        用户名
                                    </th>
                                    <th>
                                        书籍ID
                                    </th>
                                    <th>
                                        借阅时间
                                    </th>
                                    <th>
                                        归还时间
                                    </th>
                                </tr>
                                </thead>
                                <tbody id="tUser">
                                <%
                                    ArrayList<User> list = BookRentDao.queryHistory(userId);
                                    for (User user : list) {
                                %>
                                <tr>
                                    <td><span class="am-badge am-badge-secondary"><%=user.getUserId()%></span></td>
                                    <td><%=user.getSex()%>
                                    </td>
                                    <td>
                                        <a href="#"><%=user.getUserName()%>
                                        </a>
                                    </td>
                                    <td>
                                        <%=user.getBookId() %>
                                    </td>
                                    <td><span class="am-badge am-badge-secondary"><%=user.getStart()%></span>
                                    </td>
                                    <td><span class="am-badge am-badge-secondary"><%=user.getEnd()%></span></td>
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
    $(function () {
        $(".btnAdd").click(function () {
            $.jq_Panel({
                title: "添加用户信息",
                url: "AddUser.jsp",
                iframeWidth: 800,
                iframeHeight: 600,
            });
        });
        $(".btnDel").click(function () {
            $.jq_Panel({
                title: "删除借阅人",
                url: "DelUser.jsp",
                iframeWidth: 800,
                iframeHeight: 600,
            });
        });
        $(".btnEdit").click(function () {
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
