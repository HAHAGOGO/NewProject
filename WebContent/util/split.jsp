<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="base.jsp"></jsp:include>
<script src="e/jquery-1.8.3.js" type="text/javascript"></script>

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
<script type="text/javascript">
	function gopage(page) {
		if (page < 1) {
			alert("已经是第一页啦！")
		} else if (page > $("input[name=totalpage]").val()) {
			alert("已经是最后一页啦！")
		} else {

			$("input[name=cp]").val(page);
			fom.submit();
		}

	}
	function check() {
		var a = $("input[name=cp]").val();
		if (a >= "1" && a <= $("input[name=totalpage]").val()) {
			return true;
		}
		alert("输入不合法");
		return false;
	}
	
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form name="fom" id="fom" method="get" action="${param.myurl }"
								onsubmit="return check()">
								<input type="hidden" value="view" name="flag"> <input
									type="hidden" value="${ps }" name="ps"> <input
									type="hidden" value="${totalpage }" name="totalpage">
								<table width="95%" border="0" align="center" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="6"><img src="images/spacer.gif" width="1"
											height="1" /></td>
									</tr>
									<tr>
										<td height="33"><table width="100%" border="0"
												align="center" cellpadding="0" cellspacing="0"
												class="right-font08">
												<tr>
													<td width="50%">共 <span class="right-text09">${totalpage }</span>
														页 | 第 <span class="right-text09">${cp }</span> 页
													</td>
													<td width="49%" align="right">[<a
														href="javascript:gopage(1)" class="right-font08">首页</a> |
														<a href="javascript:gopage(${cp-1 })" class="right-font08">上一页</a>
														| <a href="javascript:gopage(${cp+1 })"
														class="right-font08">下一页</a> | <a
														href="javascript:gopage(${totalpage })"
														class="right-font08">末页</a>] 转至：
													</td>
													<td width="1%"><table width="20" border="0"
															cellspacing="0" cellpadding="0">
															<tr>
																<td width="1%"><input name="cp" type="text"
																	class="right-textfield03" size="1" value="${cp }" /></td>
																<td width="87%"><input name="Submit23222"
																	type="submit" class="right-button06" value="go" /></td>
															</tr>
														</table></td>
												</tr>
											</table></td>
									</tr>
								</table>
							</form>
</body>
</html>