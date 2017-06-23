<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../util/base.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>商品接口调用</h3>
<form action="gc/getgood" method="get">
	<input type="text" name="goodId"/>
	<input type="submit" value="查询">
</form>
<h3>商品分类接口调用</h3>
<form action="gc/getgoodtype" method="get">
	<input type="submit" value="获取分类">
</form>
<h3>根据商品分类获取商品接口调用</h3>
<form action="gc/getallgood" method="get">

	商品类别:<input type="text" name="styleId" /><br>
	当前页:<input type="text" name="cp" /><br>
	每页显示数量:<input type="text" name="ps" /><br>
	<input type="submit" value="调用">
</form>
<h3>首页轮播图接口调用</h3>
<form action="tic/turnimage" method="get">
	<input type="submit" value="查询">
</form>

<h3>获取商品图片接口调用</h3>
<form action="gc/goodimage" method="get">
	商品id:<input type="text" name="goodId" /><br>
	<input type="submit" value="查询">
</form>

</body>
</html>