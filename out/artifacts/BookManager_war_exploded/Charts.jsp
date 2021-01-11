<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图表</title>
<script type="text/javascript" src="statics/js/html5shiv.js"></script>
<script type="text/javascript" src="statics/js/respond.min.js"></script>
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
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 统计管理 <span class="c-gray en">&gt;</span> 折线图
			<a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新"><i class="Hui-iconfont">&#xe68f;</i></a>
		</nav>
		<div class="page-container">
		
			<div id="container" style="min-width:700px;height:400px"></div>
		</div>
		<%! 
 int count = 3; %>
		<!--_footer 作为公共模版分离出去-->
		<script type="text/javascript" src="statics/js/jquery.min.js"></script>
		<script type="text/javascript" src="statics/js/layer.js"></script>
		<script type="text/javascript" src="statics/js/H-ui.min.js"></script>
		<script type="text/javascript" src="statics/js/H-ui.admin.js"></script>
		<!--/_footer 作为公共模版分离出去-->

		<!--请在下方写此页面业务相关的脚本-->
		<script type="text/javascript" src="statics/js/hcharts/Highcharts/5.0.6/js/highcharts.js"></script>
		<script type="text/javascript" src="statics/js/hcharts/Highcharts/5.0.6/js/modules/exporting.js"></script>
		<script type="text/javascript">
			$(function() {
				Highcharts.chart('container', {
					title: {
						text: '图书馆书籍借阅情况',
						x: -20 //center
					},
					subtitle: {
						text: 'Library book borrowing',
						x: -20
					},
					xAxis: {
						categories: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月']
					},
					yAxis: {
						title: {
							text: '本'
						},
						plotLines: [{
							value: 0,
							width: 1,
							color: '#808080'
						}]
					},
					tooltip: {
						valueSuffix: '本'
					},
					legend: {
						layout: 'vertical',
						align: 'right',
						verticalAlign: 'middle',
						borderWidth: 0
					},
					series: [ {
						name: '借阅书籍',
						data: [1, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
					}]
				});
			});
		</script>
</body>
</html>