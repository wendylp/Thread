<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品后台管理</title>

<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />

<script type="text/javascript">
	$("#redis_search_class_1").combobox({
	
 	url:'json/class_1.js',    
    valueField:'id',   //value属性
    textField:'flmch1' , //文本值属性
    width:'100',  //不能加px
    value:'请选择......', //默认值
  	onSelect:function(){
    	var class_1_id = $(this).combobox('getValue');
    	$('#redis_search_class_2').combobox({
    		url:'json/class_2_' + class_1_id + '.js',     
 		    valueField:'id',   //value属性
 		    textField:'flmch2' , //文本值属性
 		    width:'100',  //不能加px
 		    value:'请选择......' ,//默认值 */
 		    onSelect:function(){
 			   
		    	var class_2_id = $("#redis_search_class_2").combobox('getValue');
		    	var class_2_name = $("#redis_search_class_2").combobox('getText');
		    	
		    	$('#redis_search_inner_datagrid').datagrid({
		    		url:'get_attr_class_2_json',    
		 		    queryParams:{"class_2_id":class_2_id, "class_2_name":class_2_name},
		 		    columns:[[    
		 		        {field:'id',title:'属性id',width:100, checkbox:true}, 
		 		        {field:'shxm_mch',title:'属性名',width:100}, 
		 		        {field:'chjshj',title:'创建时间',width:100, formatter:function(value,row,index){
		 		        	
		 		        	var date = new Date(value);
		 		        	var time = date.toLocaleString();
		 		        	return time;
		 		        }}, 
		 		        
		 		        {field:'list_value',title:'属性值集合',width:100, formatter:function(value,row,index){
		 		        	
		 		        	var attrList = "";
		 		        	$(value).each(function(i, json){
		 		        		
		 		        		attrList += json.shxzh + json.shxzh_mch + "  ";
		 		        		
		 		        	});
		 		        	
		 		        	return attrList;
		 		        }}
		 		        
		 		    ]]    
		 		   
		    	});
		    	
 		   } 
 		   
   	});
    	
} 

});

	
	function redis_refresh_class_2(){
		var class_2_id = $("#redis_search_class_2").combobox('getValue');
		$.post("redis_search_class_2", {class_2_id:class_2_id}, function(data){
			
			alert("共刷新了" + data + "条数据到缓存中");
		});
		
	}

	
	function redis_refresh_attr_value(){
		
		var class_2_id = $("#redis_search_class_2").combobox('getValue');
		var attr_value = $("#redis_search_inner_datagrid").datagrid('getChecked');  //多个数字的数组
		
		var attr_array = new Array();
		
		$(attr_value).each(function(i, json){
			
			attr_array[i] = json.id;
		});
		
		$.post("redis_search_attr_value", {class_2_id:class_2_id, attr_array:attr_array}, function(data){
			
			alert("共刷新了" + data + "数据到缓存中");
		});
	}
</script>
</head>
<body>

	
	<div class="easyui-layout" data-options="fit:true" style="width:700px;height:350px;">
		<div data-options="region:'north',split:true,border:true" style="height:50px">
			<h2>检索缓存管理</h2>
		</div>
		
		<div data-options="region:'west',split:true,border:true" style="width:150px">
			一级分类：<br/>
			<select id="redis_search_class_1" class="easyui-combobox" name="flbh1" ></select>
			<br/><br/>
			二级分类：<br>
			<select id="redis_search_class_2" class="easyui-combobox" name="flbh2" ></select><br><br>
			
		</div>
		
		<div data-options="region:'center',border:true">
			<div id="redis_search_inner" >
				<!-- 静态引入内嵌页面 -->
				<jsp:include page="redis_search_inner.jsp"></jsp:include>
			</div>
			<br/>
			<a href="javascript:;redis_refresh_class_2()" >刷新二级分类缓存</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:;redis_refresh_attr_value()" >刷新属性属性值集合缓存</a>
		</div>
	</div>
</body>
</html>