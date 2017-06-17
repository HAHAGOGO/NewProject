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
function f1(){
	$.ajax({
		url:"rpc/qrp",
		data:{receiptid:"1"},
		datatype:"json",
		type:"post",
		success:function(data){
			alert(data);
		}
		
		
	})
	
	
	
}
function f2(){
	$.ajax({
		url:"rpc/qbuid",
		data:{userid:"2"},
		datatype:"json",
		type:"post",
		success:function(data){
			alert(data);
		}
		
		
	})
	
	
	
}

</script>
</head>
<body>
<a href="javascript:void" onclick="f1()">zzzz</a>
<a href="javascript:void" onclick="f2()">zzzz</a>
<a href="rpc/qa">zzzz1</a>
<form action="rpc/ap">

姓名：<input type="text" name="pname"><br>
电话：<input type="text" name="phone"><br>
地区编号：<input type="text" name="area.areaID"><br>
地区详情：<input type="text" name="addressinfo"><br>
<input type="submit" value="提交">
</form><br>


</body>
</html>