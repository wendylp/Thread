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
				$("#attr_publish_class_1").append("<option value="+json.id+">"+json.flmch1+"</option>");
			});
		});
	
	});

	function attr_publish_change_class_2(){
	
	//先获取value属性值
		var class_1_id = $("#attr_publish_class_1 option:selected").val();
		 $.getJSON("json/class_2_" + class_1_id + ".js", function(data){
			
			$("#attr_publish_class_2").empty(); //循环之前先把以前的清掉
			$(data).each(function(i, json){
				
				$("#attr_publish_class_2").append("<option value="+json.id+">"+json.flmch2+"</option>");
				
			});
		
		}); 
	 
	}
	
	//Ajax发送异步请求
	function attr_publish_get_attr(class_2_id){
		var class_2_name = $("#attr_publish_class_2 option:selected").text();
		
		$.post("get_attr_class_2", {"class_2_id":class_2_id, "class_2_name":class_2_name}, function(data){
			
			$("#attr_publish_inner").html(data);
			
		});
		
	}
	
</script>
</head>
<body>
	<select id="attr_publish_class_1" name="flbh1" onchange="attr_publish_change_class_2()"></select>
	<br/><br/>
	<select id="attr_publish_class_2" name="flbh2" onchange="attr_publish_get_attr(this.value)"></select>
	
	<div id="attr_publish_inner"></div>
</body>
</html>