<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sku信息发布</title>
</head>
<body>
<br/>

	<c:forEach items="${requestScope.get_attr_list }" var="attr_list" varStatus="index">
		<input class="attr${index.index }" type="checkbox" name="list_sku_attr_value[${index.index }].shxm_id" value="${attr_list.id }"/>${attr_list.shxm_mch }
	</c:forEach>

	<br/>
	<c:forEach items="${requestScope.get_attr_list }" var="attr_list" varStatus="index">
		
		<c:forEach items="${attr_list.list_value }" var="value">
			<input type="radio" name="list_sku_attr_value[${index.index }].shxzh_id" value="${value.id }"/>${value.shxzh }${value.shxzh_mch }
		</c:forEach>
		<br/>
	</c:forEach>
	
	<hr>
	库存：<input type="text" name="kc"/><br><br>
	价格：<input type="text" name="jg"/><br><br>
	名称：<input type="text" name="sku_mch"/><br><br>
	地址：<input type="text" name="kcdz"/><br><br/>

	<input type="submit" value="发布库存信息"/>
	
</body>
</html>