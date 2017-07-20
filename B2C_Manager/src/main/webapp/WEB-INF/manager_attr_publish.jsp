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
	
	/* 	$.getJSON("json/class_1.js", function(data){
			$(data).each(function(i, json){
				$("#attr_publish_class_1").append("<option value="+json.id+">"+json.flmch1+"</option>");
			});
		});
		 */
	 $("#attr_publish_class_1").combobox({
			
			 	url:'json/class_1.js',    
			    valueField:'id',   //value属性
			    textField:'flmch1' , //文本值属性
			    width:'100',  //不能加px
			    value:'请选择......', //默认值
			  	onSelect:function(){
			    	var class_1_id = $(this).combobox('getValue');
			    	$('#attr_publish_class_2').combobox({
			    		url:'json/class_2_' + class_1_id + '.js',     
			 		    valueField:'id',   //value属性
			 		    textField:'flmch2' , //文本值属性
			 		    width:'100',  //不能加px
			 		    value:'请选择......' ,//默认值 */
			 		    onSelect:function(){
			 			   
					    	var class_2_id = $("#attr_publish_class_2").combobox('getValue');
					    	var class_2_name = $("#attr_publish_class_2").combobox('getText');
					    	
					    	$('#attr_publish_inner_datagrid').datagrid({
					    		url:'get_attr_class_2_json',    
					 		    queryParams:{"class_2_id":class_2_id, "class_2_name":class_2_name},
					 		    columns:[[    
					 		        {field:'id',title:'属性id',width:100}, 
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
		 
});


	/*  function attr_publish_change_class_2(){
	
	//先获取value属性值
		var class_1_id = $("#attr_publish_class_1 option:selected").val();
		 $.getJSON("json/class_2_" + class_1_id + ".js", function(data){
			
			$("#attr_publish_class_2").empty(); //循环之前先把以前的清掉
			$(data).each(function(i, json){
				
				$("#attr_publish_class_2").append("<option value="+json.id+">"+json.flmch2+"</option>");
				
			});
		
		}); 
	 
	} */ 
	
	//Ajax发送异步请求
	/*  function attr_publish_get_attr(class_2_id){
		 var class_2_name = $("#attr_publish_class_2 option:selected").text(); 
		
		//var class_2_name = $("#attr_publish_class_2").combobox('getValue');
 		 $.post("get_attr_class_2", {"class_2_id":class_2_id, "class_2_name":class_2_name}, function(data){
			
			$("#attr_publish_inner").html(data);
			
		}); 
		
		
	}*/
	
</script>
</head>
<body>


	<div class="easyui-layout" data-options="fit:true" style="width:700px;height:350px;">
		<div data-options="region:'north',split:true,border:true" style="height:50px">
			<h2>商品属性信息发布</h2>
		</div>
		<div data-options="region:'west',split:true,border:true" style="width:150px">
			一级分类：<br/>
			<select id="attr_publish_class_1" class="easyui-combobox" name="flbh1" ></select>
			<br/><br/>
			二级分类：<br>
			<select id="attr_publish_class_2" class="easyui-combobox" name="flbh2" ></select><br><br>
			
		</div>
		
		<div data-options="region:'center',border:true">
			<div id="attr_publish_inner" >
				<!-- 静态引入内嵌页面 -->
				<jsp:include page="manager_attr_inner.jsp"></jsp:include>
			</div>
		
		</div>
	</div>
			
</body>
</html>