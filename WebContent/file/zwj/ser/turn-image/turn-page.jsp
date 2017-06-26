<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../../../util/base.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<style type="text/css">
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
</style>
<link href="file/zwj/link/css/css.css" rel="stylesheet" type="text/css" />
<link href="file/zwj/link/css/style.css" rel="stylesheet" type="text/css" />
<title>轮播图页面</title>
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
		
		<tr>
			<td>
				<table id="subtree1" width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
						
							<!-- 全选部分 -->
							<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td height="20">
										<!-- <span class="newfont07">-->
									</td>
								</tr>
								<tr>
									<td height="40" class="font42">
									
									
										<!-- 表格部分 -->
										<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
											<tr class="CTitle">
												<td height="22" colspan="7" align="center" style="font-size: 16px">轮播图详情列表</td>
											</tr>
											<tr bgcolor="#EEEEEE">
												<td width="4%" align="center">商品ID</td>
												<td width="5%" align="center">商品名</td>
												<td width="5%" align="center">图片路径</td>
												<td width="5%" align="center">跳转路径</td>
												<td width="5%" align="center">操作</td>
											</tr>
											
											
											<c:forEach var="g" items="${images }">
												<tr bgcolor="#FFFFFF">
													<td>${g.goodId }</td>
													<td>${g.turnTitle }</td>
													<td>${base}${g.imagePath }</td>
													<td>${g.imageLink }</td>
													<td>
														<a href="gsc/dti?turnId=${g.turnId }">删除</a>
													</td>
												</tr>
											</c:forEach>
											
										</table>
									</td>
								</tr>
							</table>
							<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td height="6">
										<img src="file/zwj/link/images/spacer.gif" width="1" height="1" />
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>