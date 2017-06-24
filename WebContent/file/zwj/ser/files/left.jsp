<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<html>
<head>
<base href="<%=basepath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>项目管理系统</title>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-image: url(file/zwj/link/images/left.gif);
}
</style>
<link href="file/zwj/link/css/css.css" rel="stylesheet" type="text/css" />
</head>
<SCRIPT language=JavaScript>
	function tupian(idt) {
		var nametu = "xiaotu" + idt;
		var tp = document.getElementById(nametu);
		tp.src = "file/zwj/link/images/ico05.gif";//图片ico04为白色的正方形

		for (var i = 1; i < 30; i++) {

			var nametu2 = "xiaotu" + i;
			if (i != idt * 1) {
				var tp2 = document.getElementById('xiaotu' + i);
				if (tp2 != undefined) {
					tp2.src = "file/zwj/link/images/ico06.gif";
				}//图片ico06为蓝色的正方形
			}
		}
	}

	function list(idstr) {
		var name1 = "subtree" + idstr;
		var name2 = "img" + idstr;
		var objectobj = document.all(name1);
		var imgobj = document.all(name2);

		//alert(imgobj);
		if (objectobj.style.display == "none") {
			for (i = 1; i < 10; i++) {
				var name3 = "img" + i;
				var name = "subtree" + i;
				var o = document.all(name);
				if (o != undefined) {
					o.style.display = "none";
					var image = document.all(name3);
					//alert(image);
					image.src = "file/zwj/link/images/ico04.gif";
				}
			}
			objectobj.style.display = "";
			imgobj.src = "file/zwj/link/images/ico03.gif";
		} else {
			objectobj.style.display = "none";
			imgobj.src = "file/zwj/link/images/ico04.gif";
		}
	}
</SCRIPT>
<script type="text/javascript">
	function exit() {
		parent.location.href = "uc/exit";
	}
</script>

<body>
	<table width="198" border="0" cellpadding="0" cellspacing="0" class="left-table01">
		<tr>
			<td>
				<table width="100%" border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td width="207" height="55" background="file/zwj/link/images/nav01.gif">
							<table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td width="25%" rowspan="2">
										<img src="file/zwj/link/images/ico02.gif" width="35" height="35" />
									</td>
									<td width="75%" height="22" class="left-font01">
										您好，<span class="left-font02">${user.realname }</span>
									</td>
								</tr>
								<tr>
									<td height="22" class="left-font01">
										[&nbsp;<a href="javascript:exit()" target="_top" class="left-font01">退出</a>&nbsp;]
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table> 

				<!--  商品系统开始    -->
				<table width="100%" border="0" cellpadding="0" cellspacing="0" class="left-table03">
					<tr>
						<td height="29">
							<table width="85%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td width="8%">
										<img name="img7" id="img7" src="file/zwj/link/images/ico04.gif" width="8" height="11" />
									</td>
									<td width="92%">
										<a href="javascript:" target="mainFrame" class="left-font03" onClick="list('7');">商品管理</a>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table id="subtree7" style="display: none" width="80%" border="0" align="center" cellpadding="0" cellspacing="0" class="left-table02">
					<tr>
						<td width="9%" height="20">
							<img id="xiaotu17" src="file/zwj/link/images/ico06.gif" width="8" height="12" />
						</td>
						<td width="91%">
							<a href="gsc/cag" target="mainFrame" class="left-font03">查看所有商品</a>
						</td>
					</tr>
					<tr>
						<td width="9%" height="20">
							<img id="xiaotu18" src="file/zwj/link/images/ico06.gif" width="8" height="12" />
						</td>
						<td width="91%">
							<a href="gsc/gai" target="mainFrame" class="left-font03" >查看首页轮播图</a>
						</td>
					</tr>
					<tr>
						<td width="9%" height="20">
							<img id="xiaotu18" src="file/zwj/link/images/ico06.gif" width="8" height="12" />
						</td>
						<td width="91%">
							<a href="gsc/cgs" target="mainFrame" class="left-font03" >商品服务管理</a>
						</td>
					</tr>
					<tr>
						<td width="9%" height="20">
							<img id="xiaotu18" src="file/zwj/link/images/ico06.gif" width="8" height="12" />
						</td>
						<td width="91%">
							<a href="gsc/gags" target="mainFrame" class="left-font03" >商品分类管理</a>
						</td>
					</tr>
				</table> 
				
				<!--  商品系统结束    -->



				
			</td>
		</tr>
	</table>
</body>
</html>
