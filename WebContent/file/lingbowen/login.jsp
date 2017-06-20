<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../util/base.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>登陆啦！！！</h1>
<form action="fuc/islogin" method="post">
<input type="text" name="loginname" value="laowang">
<input type="text" name="loginpwd" value="123">
<input type="submit" >
</form>
</body>
</html>