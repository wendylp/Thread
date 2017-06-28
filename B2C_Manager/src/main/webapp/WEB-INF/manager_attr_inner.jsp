<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品后台管理</title>

<base href="http://${pageContext.request.serverName }:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<!-- <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script> -->
<script type="text/javascript">

</script>
</head>
<body>
	
<%-- 	${requestScope.get_attr_list } --%>
	<c:forEach items="${requestScope.get_attr_list }" var="attr">
		${attr.shxm_mch }
		
		<c:forEach items="${attr.list_value }" var="val">
			${val.shxzh }
			${val.shxzh_mch }
		</c:forEach>
		<br>
	</c:forEach>
	
	<br>
	<a href="javascript:add_tabs('attr_add?class_2_id=${requestScope.class_2_id }&class_2_name=${requestScope.class_2_name }', '添加属性')" >添加属性</a>
	
</body>
</html>