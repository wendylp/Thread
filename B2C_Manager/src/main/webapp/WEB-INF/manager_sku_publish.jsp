<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品后台管理</title>

<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<script type="text/javascript">

	$(function(){
	
		 $.getJSON("json/class_1.js", function(data){
			$(data).each(function(i, json){
				$("#sku_publish_class_1").append("<option value="+json.id+">"+json.flmch1+"</option>");
			});
		}); 
		
		
	
	});

	function sku_publish_change_class_2(){
	
	//先获取value属性值
		var class_1_id = $("#sku_publish_class_1 option:selected").val();
		 $.getJSON("json/class_2_" + class_1_id + ".js", function(data){
			
			$("#sku_publish_class_2").empty(); //循环之前先把以前的清掉
			$(data).each(function(i, json){
				
				$("#sku_publish_class_2").append("<option value="+json.id+">"+json.flmch2+"</option>");
				
			});
		
		}); 
		 
		sku_publish_change_tm(); //调用下面的函数
	 
	}
	
	
	function sku_publish_change_tm(){
		
		//先获取value属性值
		var class_1_id = $("#sku_publish_class_1 option:selected").val();
		 $.getJSON("json/tm_class_" + class_1_id + ".js", function(data){
			
			$("#sku_publish_tm").empty(); //循环之前先把以前的清掉
			$(data).each(function(i, json){
				
				$("#sku_publish_tm").append("<option value="+json.id+">"+json.ppmch+"</option>");
				
			});
			
		}); 
		
	}
	
	
	//Ajax发送异步请求
	function sku_publish_get_sku(class_2_id){
		var class_2_name = $("#sku_publish_class_2 option:selected").text();
		
		$.post("get_sku_class_2", {"class_2_id":class_2_id, "class_2_name":class_2_name}, function(data){
			
			//
			$("#sku_publish_inner").html(data);
			
		});
		
	}
	
	
	//Ajax发送异步请求
	function sku_publish_get_spu(tm_id){
	
		var class_1_id = $("#sku_publish_class_1").val();
		var class_2_id = $("#sku_publish_class_2").val();
		
		$.post("get_tm", {"class_1_id":class_1_id, "class_2_id":class_2_id, "tm_id":tm_id}, function(data){
			
			$(data).each(function(i, json){
				
				$("#sku_publish_tm_spu").append("<option value="+json.id+">"+json.shp_mch+"</option>");
				
			});
			
		});
	}
	
	
	$("#sku_publish_class_2").click(function(){
		
		$(".attr${index.index }").hide();
		
		
	});
</script>
</head>
<body>
<form action="save_sku" method="post">
	<div class="easyui-layout" data-options="fit:true" style="width:700px;height:350px;">
		<div data-options="region:'north',split:true,border:true" style="height:50px">
			<h2>商品sku信息发布</h2>
		</div>
		
		<div data-options="region:'west',split:true,border:true" style="width:200px;height:350px;">
			一级分类：<br/>
			<select id="sku_publish_class_1" name="flbh1"
			onchange="sku_publish_change_class_2()"></select>
			<br/><br/>
			二级分类：<br/>
			<select id="sku_publish_class_2" name="flbh2" onchange="sku_publish_get_sku(this.value)"></select>
			<br/><br/>
			品牌：<br/>
			<select id="sku_publish_tm" name="pp_id" onchange="sku_publish_get_spu(this.value)"></select>
			<br/><br/>
			商品名称：<br/>
			<select id="sku_publish_tm_spu" name="shp_id"></select>
		
		</div>
		<div data-options="region:'center',border:true">
			<!-- 内嵌页面 -->
			<div id="sku_publish_inner"></div>
			<br/><br/>
		</div>
	</div>
	</form>
	
		
</body>
</html>