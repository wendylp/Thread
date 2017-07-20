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
		
		$('#spu_publish_class_1').combobox({    
		    url:'json/class_1.js',    
		    valueField:'id',   //value属性
		    textField:'flmch1' , //文本值属性
		    width:'100',  //不能加px
		    value:'请选择......',  //默认值
		    onSelect:function(){
		    	var class_1_id = $(this).combobox('getValue');
		    	$('#spu_publish_class_2').combobox({
		    		url:'json/class_2_' + class_1_id + '.js',     
		 		    valueField:'id',   //value属性
		 		    textField:'flmch2' , //文本值属性
		 		    width:'100',  //不能加px
		 		    value:'请选择......'  //默认值
		    	});
		    	
		    	$("#spu_publish_tm").combobox({
		    		url:'json/tm_class_' + class_1_id + '.js',     
		 		    valueField:'id',   //value属性
		 		    textField:'ppmch' , //文本值属性
		 		    width:'100',  //不能加px
		 		    value:'请选择......'  //默认值	
		    		
		    	});
		    	
		    }
		}); 
		
		/* $.getJSON("json/class_1.js", function(data){
			$(data).each(function(i, json){
				$("#spu_publish_class_1").append("<option value="+json.id+">"+json.flmch1+"</option>");
			});
		}); */
		
	});
	
/* 	function spu_publish_change_class_2(){
		
		//先获取value属性值
		var class_1_id = $("#spu_publish_class_1 option:selected").val();
		 $.getJSON("json/class_2_" + class_1_id + ".js", function(data){
			
			$("#spu_publish_class_2").empty(); //循环之前先把以前的清掉
			$(data).each(function(i, json){
				
				$("#spu_publish_class_2").append("<option value="+json.id+">"+json.flmch2+"</option>");
				
			});
			
		}); 
		 
		 spu_publish_change_tm(); //调用下面的函数
		 
	}
		 */
/* 	function spu_publish_change_tm(){
		
		//先获取value属性值
		var class_1_id = $("#spu_publish_class_1 option:selected").val();
		 $.getJSON("json/tm_class_" + class_1_id + ".js", function(data){
			
			$("#spu_publish_tm").empty(); //循环之前先把以前的清掉
			$(data).each(function(i, json){
				
				$("#spu_publish_tm").append("<option value="+json.id+">"+json.ppmch+"</option>");
				
			});
			
		}); 
		
	}
	 */
	
	function spu_publish_image_button(index){
		
		$("#file_"+index).click();
		
	}
	
	function spu_publish_show_image(index){
		
		var image = $("#file_"+index)[0].files[0];
		
		var url = window.URL.createObjectURL(image);
		
		
		$("#image_"+index).attr("src", url);
		
		var length = $("#image_div :file").length;
		
		$("#image_length").html(5 - index);
		
		if(length == index && length < 5){
			
			//调用函数
			spu_publish_append_image(index);
			
		}else{
			$("#span_div").html("图片数量已达上限！");
			
		}
	}
	
	function spu_publish_append_image(index){
		
		var div1 = '<div style="float:left;">'
		var img = '<img id="image_'+(index+1)+'" alt="" src="image/upload_hover.png" width="50px" height="50px" onclick="spu_publish_image_button('+(index+1)+')"/>';
		var input = '<input id="file_'+(index+1)+'" type="file" name="files" style="display:none;" onchange="spu_publish_show_image('+(index+1)+')"/>';
		var div2 = '</div>'
		$("#image_div").append(div1+img+input+div2);
		
	}
	 
	
</script>
</head>
<body>

	<form action="spu_publish" method="post" enctype="multipart/form-data">
		
		<div class="easyui-layout" data-options="fit:true" style="width:700px;height:350px;">
			<div data-options="region:'north',split:true,border:true" style="height:50px">
				<h2>发布的商品信息</h2>
			</div>
			<div data-options="region:'west',split:true,border:true" style="width:200px">
				一级分类：<br>
				<select id="spu_publish_class_1" class="easyui-combobox" name="flbh1" ></select>
				<br/><br/>
				二级分类：<br/>
				<select id="spu_publish_class_2" class="easyui-combobox" name="flbh2"></select>
				<br/><br/>
				品牌：<br/>
				<select id="spu_publish_tm" class="easyui-combobox" name="pp_id"></select>
				<br/><br/>
			
			
			</div>
			
			<div data-options="region:'center',border:true">
			
				发布的商品名称：<input type="text" name="shp_mch"/>
				<br/><br/>
				发布的商品描述：<input type="text" name="shp_msh"/>
				<br/><br/>
			
				商品图片：<span id="span_div">你还可以上传<span id="image_length">5</span>张图片</span>
				<div id="image_div">
						<img id="image_1" alt="" src="image/upload_hover.png" width="50px" height="50px" onclick="spu_publish_image_button(1)"/>
						<input id="file_1" type="file" name="files" style="display:none;" onchange="spu_publish_show_image(1)"/>
				</div>
				
				<input type="submit" value="发布商品">
			</div>
		</div>
		
		<!-- this.value -->
	<!-- 	<select id="spu_publish_class_1" name="flbh1" onChange="spu_publish_change_class_2()"></select>
		<br/><br/>
		<select id="spu_publish_class_2" name="flbh2"></select>
		<br/><br/>
		<select id="spu_publish_tm" name="pp_id"></select>
		<br/><br/> -->
		
		<!-- 发布商品名称：<input type="text" name="shp_mch"/>
		<br/><br/>
		发布商品描述：<input type="text" name="shp_msh"/>
		<br/><br/> -->
		
		<!-- 商品图片：<span id="span_div">你还可以上传<span id="image_length">5</span>张图片</span>
		<div id="image_div">
				<img id="image_1" alt="" src="image/upload_hover.png" width="50px" height="50px" onclick="spu_publish_image_button(1)"/>
				<input id="file_1" type="file" name="files" style="display:none;" onchange="spu_publish_show_image(1)"/>
		</div> -->
		
		
		<!-- <input type="submit" value="发布商品"> -->
	</form>
</body>
</html>