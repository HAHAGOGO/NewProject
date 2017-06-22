<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<jsp:include page="../../util/base.jsp"></jsp:include>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<meta name="description" content="">
<meta name="author" content="">

<script src="js/jquery-1.8.3.js" type="text/javascript"></script>

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script type="text/javascript">
	function sub() {

		var i1 = document.getElementById("i1").value;

		var i2 = document.getElementById("i2").value;
		if (i1 == null || i1 == "") {
			alert("账号不能为空");
			return false;
		}
		if (i2 == null || i2 == "") {
			alert("密码不能为空");
			return false;
		}
		
		
		
		return true;
		/* $.ajax({
			url : "uc/gu",
			datatype : "text",
			type : "post",
			data : {
				loginname : $("input[name=loginname]").val(),
				loginpwd : $("input[name=loginpwd]").val()
			},
			success : function(data) {
				
				if (data == "1") {
					alert("密码正确");
				} else {

					alert("密码不正确");
				}
			}
		}) */
	}
</script>



</head>

<body>

	<div class="container">

		<form class="form-signin" method="post" action="buc/backLogin"
			onsubmit="return sub()">
			<h2 class="form-signin-heading">请登录</h2>
			<label for="inputEmail" class="sr-only">Email address</label> <input
				id="i1" name="loginname" type="text" id="inputEmail"
				class="form-control" placeholder="用户名" value="admin" autofocus> <label
				for="inputPassword" class="sr-only">Password</label> <input id="i2"
				name="loginpwd" type="password" id="inputPassword"
				class="form-control" placeholder="密码" value="admin">
			<button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
		</form>

	</div>
	<!-- /container -->


</body>
</html>