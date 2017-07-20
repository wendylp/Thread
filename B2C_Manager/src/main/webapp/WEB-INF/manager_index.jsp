<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品后台管理</title>

<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
	<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<link rel="stylesheet" type="text/css"
		href="easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css">
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>

<script type="text/javascript">
	//自定义函数
	
	$(function(){
		var flag = "${requestScope.flag}";
		var url = "${requestScope.url}";
		
		if(flag.length != 0 && url.length != 0){
			
		add_tabs(url, flag);
			
		}
	});
	
	
	function add_tabs(url, title) {
		//避免可重复点击添加选项卡
		var exists = $("#tabs_div").tabs('exists', title);
		if (!exists) {

			$.get(url, function(data) {  //发送请求加载数据
				$('#tabs_div').tabs('add', {
					title : title,
					content : data,
					closable : true, //显示关闭按钮

				});
			});

		}

	}
</script>
</head>

<body class="easyui-layout">

	<div data-options="region:'north',border:false"
		style="height: 40px; background: #B3DFDA; padding: 10px">
		<h3>电商后台发布管理</h3>
	</div>
	<div data-options="region:'west',split:true,title:'商品管理'"
		style="width: 150px; padding: 10px;">

		<ul class="easyui-tree">
			<li><span>商品发布管理</span>

				<ul>
					<li><span><a
							href="javascript:add_tabs('goto_spu_publish', '商品spu信息发布')">商品spu信息发布</a></span>
					</li>
					<li><span><a
							href="javascript:add_tabs('goto_attr_publish', '商品属性信息发布')">商品属性信息发布</a></span>
					</li>
					<li><span><a
							href="javascript:add_tabs('goto_sku_publish', '商品sku信息发布')">商品sku信息发布</a></span>
					</li>

				</ul></li>
		</ul>

		<ul class="easyui-tree">
			<li><span>缓存信息管理</span>
				<ul>
					<li><a href="javascript:add_tabs('goto_search_redis', '检索缓存管理')">检索缓存管理</a></li>
					<li>用户缓存管理</li>
				</ul></li>
		</ul>


	</div>
	<div
		data-options="region:'east',split:true,collapsed:true,title:'East'"
		style="width: 100px; padding: 10px;">east region</div>
	<div data-options="region:'south',border:false"
		style="height: 50px; background: #A9FACD; padding: 10px;">south
		region</div>
	<div data-options="region:'center'">
		<div id="tabs_div" class="easyui-tabs"></div>
		
	


	</div>


	<!-- <a href="goto_spu_publish" class=>商品spu信息发布</a><br/><br/>
	<a href="goto_attr_publish">商品属性信息发布</a><br/><br/>
	<a href="goto_sku_publish">商品sku信息发布</a><br/><br/>
	 -->
</body>
</html>