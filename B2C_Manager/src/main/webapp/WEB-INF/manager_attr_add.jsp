<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品后台管理</title>

<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />

<script type="text/javascript">
    var attr_add_table_index = 0;
	 function spu_attr_table_add(){
		 
		 attr_add_table_index++;
		 
		 var table1 = '<table border="1" id="attr_add_table_'+attr_add_table_index+'">';
		 var tr1 = '<tr><td>属性名：<input type="text" name="attr_list['+attr_add_table_index+'].shxm_mch"/></td><td></td><td><a href="javascript:attr_add_value('+attr_add_table_index+')">添加属性</a></td></tr>';
		 var tr2 = '<tr><td>属性值：<input type="text" name="attr_list['+attr_add_table_index+'].list_value[0].shxzh"/></td><td>属性值名：<input type="text" name="attr_list['+attr_add_table_index+'].list_value[0].shxzh_mch"/></td><td><a href="javascript:">删除属性</td></tr>';
		 
		 var table2 = '</table><br/>';
		 
		 $("#attr_add_table").append(table1+tr1+tr2+table2);
	 }
	
	 
	 function attr_add_value(table_index){
		 
		var tr_index = $("#attr_add_table_"+table_index+" tr").length - 1;
		var tr = '<tr><td>属性值：<input type="text" name="attr_list['+table_index+'].list_value['+tr_index+'].shxzh"/></td><td>属性值名：<input type="text" name="attr_list['+table_index+'].list_value['+tr_index+'].shxzh_mch"/></td><td><a href="">删除属性</a></td></tr>';
		
		$("#attr_add_table_"+table_index).append(tr);
		
		
	 }
	
</script>
</head>
<body>

${requestScope.class_2_id } ${requestScope.class_2_name }<br>
<a href="javascript:spu_attr_table_add()">添加商品属性</a><br/><br/>

<form action="save_attr" method="post">
	<input type="hidden" name="class_2_id" value="${requestScope.class_2_id }"/>
	<input type="hidden" name="class_2_name" value="${requestScope.class_2_name }"/>
	
	<div id="attr_add_table">
		<table border="1" id="attr_add_table_0">
			<tr>
				<td>属性名：<input type="text" name="attr_list[0].shxm_mch"/></td>
				<td></td>
				<td><a href="javascript:attr_add_value(0)">添加属性</a></td>
			</tr>
	
			<tr>
				<td>属性值：<input type="text" name="attr_list[0].list_value[0].shxzh"/></td>
				<td>属性值名：<input type="text" name="attr_list[0].list_value[0].shxzh_mch"/></td>
				<td><a href="javascript:">删除属性</a></td>
			</tr>
		</table><br/>
	</div>

  <br/>
	<input type="submit" value="添加"/>
	</form>
</body>
</html>