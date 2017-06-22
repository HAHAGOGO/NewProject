<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basepath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目管理系统 by www.mycodes.net</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}

.tabfont01 {
	font-family: "宋体";
	font-size: 9px;
	color: #555555;
	text-decoration: none;
	text-align: center;
}

.font051 {
	font-family: "宋体";
	font-size: 12px;
	color: #333333;
	text-decoration: none;
	line-height: 20px;
}

.font201 {
	font-family: "宋体";
	font-size: 12px;
	color: #FF0000;
	text-decoration: none;
}

.button {
	font-family: "宋体";
	font-size: 14px;
	height: 37px;
}

html {
	overflow-x: auto;
	overflow-y: auto;
	border: 0;
}
-->
div {
   display: none;
   width: 700px;
   margin:0 auto;
}
</style>


<!-- <link href="houtai_xiangmu/css/css.css" rel="stylesheet" type="text/css" />
<link href="houtai_xiangmu/css/style.css" rel="stylesheet"
	type="text/css" /> -->
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
function checkOrderf(oid){
	$("div").css("display","none");
	var orid ="#"+oid;
	$(orid).css("display","block");
}


function sendOrders(oid){
	var orid ="#order_rows"+oid;
	var orderstatus="#orderstatus"+oid;
	$.ajax({
		url:"order/update",
		data:{orderid:$(orid).text(),orderstatus:'4'},
		type:"post",
		success:function(data){
			var da =eval('('+data+')');
			if(da.result=='ok'){
				alert(data);
				$(orderstatus).text("已完成");
			}
		},
		error:function(data){
			
		}
	});
}
</script>



</head>
<body>

	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>

		</tr>
		<tr>
			<td>
				<table id="subtree1" style="DISPLAY:" width="100%" border="0"
					cellspacing="0" cellpadding="0">
					<tr>
						<td>
							<form name="fom" id="fom" method="post" action="">
								<table width="95%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<!-- 									<tr>
										<td height="20">
											<span class="newfont07">
												选择：<a href="javascript:void(0);" class="right-font08" onclick="selectAll();">全选</a>
												-<a href="javascript:void(0);" class="right-font08" onclick="unselectAll();">反选</a>
											</span> 
											<input name="Submit" type="button" class="right-button08" value="删除所选新闻" onclick="batchDelete()" /> 
											<input name="Submit2" type="button" class="right-button08" value="添加新闻" onclick="link();" />
										</td>
									</tr> -->
									<tr>
										<td height="40" class="font42">
											<table width="100%" border="0" cellpadding="4"
												cellspacing="1" bgcolor="#464646" >
												<tr class="CTitle">
													<td height="22" colspan="9" align="center"
														style="font-size: 16px">订单详细列表</td>
												</tr>
												<tr bgcolor="#EEEEEE">
												<td width="6%">订单流水</td>
													<td width="6%">用户名</td>
													<td width="8%">用户电话</td>
													<td width="19%">用户地址</td>
													<td width="7%">订单时间</td>
													<td width="4%">订单状态</td>
													<td width="19%">订单留言</td>
													<td width="8%">操作</td>
													<!-- 		<td width="6%">用户邮箱</td>
													<td width="15%">用户简介</td> -->
												</tr>
												<c:forEach items="${pages.list }" var="nl">
													<tr bgcolor="#FFFFFF" id="">
													    <td height="20" id="order_rows${nl.orderid }">${nl.orderid}</td>
														<td height="20">${nl.receipt.pname }</td>
														<td>${nl.receipt.phone }</td>
														<td>${nl.receipt.addressinfo }</td>
														<td><fmt:formatDate value="${nl.ordertime }"
																pattern="yyyy-MM-dd HH:mm:ss" /></td>
														<td id="orderstatus${nl.orderid }">
														<c:choose >
														<c:when test="${nl.orderstatus == 1}">
														<c:out value="未支付"></c:out>
														</c:when>
														<c:when test="${nl.orderstatus == 2}">
														<c:out value="代发货"></c:out>
														</c:when>
														<c:when test="${nl.orderstatus == 3}">
														<c:out value="已发货"></c:out>
														</c:when>
														<c:when test="${nl.orderstatus == 4}">
														<c:out value="已完成"></c:out>
														</c:when>
														</c:choose>
														</td>
														<td>${nl.message }</td>
														<%--<td>${fn:substring(nl.user_desc,0,20) }${fn:length(nl.user_desc)>20?"...":"" } </td>
 --%>
														<td><input type="button" id="checkOrder" onclick="checkOrderf('orderid${nl.orderid}')" value="订单详情" />
															<input type="button" id="sendOrder" onclick="sendOrders('${nl.orderid}')" value="发货" /></td>
													</tr>
												</c:forEach>
											</table>
										</td>
									</tr>
								</table>
							</form>
							<table width="95%" border="0" align="center" cellpadding="0"
								cellspacing="0">
								<tr>
									<td height="6"></td>
								</tr>
								<tr>
									<td height="33"><jsp:include page="split.jsp">
											<jsp:param value="order/showpages" name="myurl" />
										</jsp:include></td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>

	<c:forEach items="${pages.list }" var="ol">
		<div id="orderid${ol.orderid }">
						<table id="detail" width="100%" border="1" cellspacing="0"
					cellpadding="0">
					<tr>
						<td>订单流水</td>
						<td>商品名称</td>
						<td>商品商品图片</td>
						<td>商品数量</td>
						<td>商品总价</td>
					</tr>
			<c:forEach items="${ol.orderItem }" var="oi">
			<tr>
				<td height="20">${ol.orderid}</td>
			 	<td>${oi.goodInfo.goodName }</td>
			 	<td><img src="${oi.goodInfo.goodPicPath }" width="80" height="80"/></td>
			 	<td>${oi.quantity}</td>
			 	<td>${oi.price }</td>
			</tr>
			</c:forEach>
			</table>
		</div>
	</c:forEach>
</body>
</html>
