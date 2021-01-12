<%@ page language="java" contentType="text/html; charset=utf-8" import=" com.gdut.model.*" import=" com.gdut.book.*"
         import="java.util.ArrayList"
         pageEncoding="utf-8" %>
<%@ page import="com.gdut.dao.BookDao" %>
<%@ page import="com.gdut.model.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>书籍信息</title>
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
                        <div class="am-input-group am-input-group-sm">
                            <input class="am-form-field" id="departName" placeholder="请输入书籍名称" type="text">
                            <span class="am-input-group-btn">
										<button class="am-btn am-btn-default" type="button" id="btnsearch">
											搜索
										</button> </span>
                        </div>
                    </div>
                </div>

                <div class="am-g" style="margin-top: -30px;">
                    <div class="am-u-sm-12">
                        <form class="am-form">
                            <table class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                <tr>
                                    <th class="table-check">
                                        <input id="chkAll" type="checkbox">
                                    </th>
                                    <th class="table-id">
                                        ISBN
                                    </th>
                                    <th class="table-title">
                                        书名
                                    </th>
                                    <th class="table-title">
                                        价格
                                    </th>
                                    <th class="table-title">
                                        作者
                                    </th>
                                    <th class="table-title">
                                        出版社
                                    </th>
                                    <th class="table-set">
                                        操作
                                    </th>
                                </tr>
                                </thead>
                                <tbody id="tUser">

                                <%
                                    ArrayList<Book> list = BookDao.queryBook();
                                    for (int i = 0; i < list.size(); i++) {
                                %>

                                <tr>
                                    <td><input name="chks" value="27" type="checkbox"></td>
                                    <td><%=list.get(i).getIsbn() %>
                                    </td>
                                    <td><%=list.get(i).getBookname()%>
                                    </td>
                                    <td><%=list.get(i).getPrice()%>
                                    </td>
                                    <td><%=list.get(i).getAuthor()%>
                                    </td>
                                    <td><%=list.get(i).getPublish()%>
                                    </td>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <button type="button" id="depart_27"
                                                        class="am-btn am-btn-default am-btn-xs am-text-secondary btnedit">
                                                    <span class="am-icon-pencil-square-o"></span> 编辑
                                                </button>
                                                <button type="button"
                                                        class="am-btn am-btn-default am-btn-xs am-text-danger amt-hide-sm-only btndel">
                                                    <span class="am-icon-trash-o"></span> 删除
                                                </button>
                                            </div>
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
    $(function () {
        $(".btnedit").click(function () {
            $.jq_Panel({
                title: "修改书籍",
                iframeWidth: 500,
                iframeHeight: 300,
                url: "ModifyBook.jsp"
            });
        });
        $(".btndel").click(function () {
            $.jq_Panel({
                title: "删除书籍",
                iframeWidth: 500,
                iframeHeight: 300,
                url: "DelBook.jsp"
            });
        });

        $(".btnAdd").click(function () {

            $.jq_Panel({
                title: "添加书籍",
                iframeWidth: 500,
                iframeHeight: 300,
                url: "AddBook.jsp"
            });
        });
    });
</script>
</body>
</html>