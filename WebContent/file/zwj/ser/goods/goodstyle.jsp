<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../../../util/base.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<title>商品分类页面</title>
<script type="text/javascript">
	function addName(){
		var ser=$("#serviceName").val();
		if(ser==null||ser==""){
			alert("分类名不能为空");
			return;
		}
		$("#addform").submit();
	}
	function updateName(id){
		var serviceName=$("#ser"+id).val();
		if(serviceName==null||serviceName==""){
			alert("分类名不能为空");
			return;
		}
		location.href="gsc/updategs?styleId="+id+"&styleName="+serviceName;
	}
</script>
</head>
<body>
	<h2>这里是商品分类页面</h2>
<table width="350" border="0" cellspacing="1">
	<tr>
		<th>分类id</th>
		<th>分类名</th>
		<th>操作</th>
	</tr>
	<c:forEach var="s" items="${allType }">
		<tr>
			<td>${s.styleId }</td>
			<td><input type="text" id="ser${s.styleId }" value="${s.styleName }"/></td>
			<td><a href="javascript:updateName('${s.styleId }')">保存修改</a></td>
		</tr>
	</c:forEach>
</table>
<form action="gsc/addgs" method="get" id="addform">
分类名:<input type="text" name="styleName" id="serviceName">
<input type="button" value="增加" onclick="addName()"/>
</form>
</body>
</html>