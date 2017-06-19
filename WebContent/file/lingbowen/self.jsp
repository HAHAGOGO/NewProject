<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../util/base.jsp"></jsp:include>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript">
	function f1(a) {
		alert(a);
		$.ajax({
			data : {
				"userid" : a
			},
			datatype : "json",
			type : "post",
			url : "rpc/qbuid",
			success : function(data) {
				alert(data);

			}

		})
		alert("s")

	}
</script>
</head>
<body>
<span>${sessionScope.user.nickName }</span>
	<h1>个人中心</h1>
	<a>全部订单</a>
	<a>待付款</a>
	<a>待发货</a>
	<a>待收货</a>
	<a>已完成</a>
	<a>退款售后</a>
	<a href="rpc/qbuid?userid=2">地址管理</a>
	<a>身份认证</a>
	<a href="rpc/delete?rpid=8">删除地址</a>
	<form action="rpc/update" method="post">
		id<input type="text" name="pid"><br> 姓名<input type="text"
			name="pname"><br> 电话<input type="text" name="phone"><br>
		地区<input type="text" name="area.areaID"><br> 详细地址<input
			type="text" name="addressinfo"><br> <input type="submit">

	</form>
	<a href="rpc/updateDefault?rpid=3">更改默认</a>
	<form action="rpc/ap" method="post">

		姓名：<input type="text" name="pname"><br> 电话：<input
			type="text" name="phone"><br> 地区编号：<input type="text"
			name="area.areaID"><br> 地区详情：<input type="text"
			name="addressinfo"><br> <input type="submit" value="提交">
	</form>
	<form action="fuc/sendMessage" method="post">
		電話<input type="text" name=phone><br> <input type="submit"
			value="提交">

	</form>
	<form action="fuc/checkCode" method="post">
		验证码<input type="text" name="code"><br> <input
			type="submit">

	</form>
	<a href="rpc/getAreaByFather?father=110100">地区</a>
	<a href="rpc/getCityByFather?father=130000">城市</a>
	<a href="rpc/getProvince">省</a>
</body>
</html>