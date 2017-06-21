<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
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
</style>

<link href="houtai_xiangmu/css/css.css" rel="stylesheet" type="text/css" />
<link href="houtai_xiangmu/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
function gopage(mypage){
	var cp = $("#cp").val();
	var totalpage = $("#totalpage").val();
	if(parseInt(mypage)<=1&&cp==1){
		alert("已经是第一页了");
	}else if(parseInt(mypage)>=parseInt(totalpage)&&parseInt(cp)==parseInt(totalpage)){
		alert("已经是最后一页了");
	}else if(parseInt(mypage)>=1&&parseInt(mypage)<=parseInt(totalpage)){
		splitform.cp.value = mypage;
		splitform.submit();
	}else{
		alert("网络异常，请刷新页面后重试");
	}
}

$(function(){
	$("#cp").keyup(checkcp);
});

function checkcp(){
	var totalpage = $("#totalpage").val();
	var cp = $("#cp").val();
	if(cp>='1'&&cp<=totalpage){
		return true;
	}
	alert("您输入的页码不合法，请重新输入");
	$("#cp").select();
	return false;
	
	
}


</script>
</head>
<body>
	<form id="splitform" name="splitform" action="${param.myurl }" method="post" onsubmit="return checkcp();">
		<input type="hidden" value="${pages.pagesize }" name="rows" id="ps" /> 
		<input type="hidden" value="${pages.totalsRecord }" name="count" id="count" /> 
		<input type="hidden" value="${pages.totalPages }" name="totalpage" id="totalpage" />
		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
			<tr>
				<td width="50%">
					共 <span class="right-text09">${pages.totalPages }</span>
					页 | 第 <span class="right-text09">${pages.currentPage }</span> 页
				</td>
				<td width="49%" align="right">
					[<a href="javascript:gopage('1');" class="right-font08">首页</a> 
					| <a href="javascript:gopage('${pages.currentPage-1 }');" class="right-font08">上一页</a>
					| <a href="javascript:gopage('${pages.currentPage+1 }');" class="right-font08">下一页</a>
					| <a href="javascript:gopage('${pages.totalPages }');" class="right-font08">末页</a>] 转至：
				</td>
				<td width="1%">
					<table width="20" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="1%">
								<input name="cp" value="${pages.currentPage }" id="cp" type="text" class="right-textfield03" size="1" />
							</td>
							<td width="87%">
								<input name="Submit23222" type="submit" class="right-button06" value=" " />
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>