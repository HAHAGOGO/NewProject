<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basepath %>" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="file/chen/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(function(){
/* 	orderItems={};
 	orderItems['frontid']=1;
  	orderItems['orderItem[0].goodInfo.goodid'] = 1;
	orderItems['orderItem[0].goodInfo.price'] = 98; 
	orderItems['orderItem[0].goodInfo.quantity'] = 2; 
  	orderItems['orderItem[1].goodInfo.goodid'] = 2;
	orderItems['orderItem[1].goodInfo.price'] = 2; 
	orderItems['orderItem[1].goodInfo.quantity'] = 98; 
  	orderItems['orderItem[2].goodInfo.goodid'] = 3;
	orderItems['orderItem[2].goodInfo.price'] = 2; 
	orderItems['orderItem[2].goodInfo.quantity'] = 98;  */ 
	$.ajax({
		url:"order/addorder",
 		contentType:'application/json;charset=UTF-8',
		//data:orderItems,
		data:JSON.stringify({'frontid':1,orderItem:[{'goodid':1,'quantity':3,'price':23}]}),
		dataType:"text",
		type:'post',
		success:function(data){
			console.log(data);
		}
	});
	
	
}); 

</script>
</head>
<body>

</body>
</html>