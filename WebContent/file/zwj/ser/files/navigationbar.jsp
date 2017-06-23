<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basepath%>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>翻页导航</title>
<script type="text/javascript">
function changePage(cp,ps){
	var styleId=$("#styleId").val();
	location.href = "gsc/cag?styleId="+styleId+"&cp="+cp+"&ps="+ps;
}
function selectPage(){
	var pageNum=$("#pageInput").val();
	if(pageNum==null||pageNum==""){
		return;
	}
	var sum=$("#sumpage_hide").val();
	var ps=$("#ps_hide").val();
	if(pageNum>='1'&&pageNum<=sum){
		changePage(pageNum,ps);
	}else{
		$("#pageInput").select();
		alert("输入有误,请重新输入");
	}
}
$(function(){
	$("#pg").change(function(e){
		var num = e.target.value;
		var styleId=$("#styleId").val();
		location.href="gsc/cag?styleId="+styleId+"&cp="+1+"&ps="+parseInt(num);
	})
})
</script>
</head>
<body>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0" class="right-font08">
	<tr>
		<td width="50%">
			共<span class="right-text09">${sumpage }</span>
			页 | 第 <span class="right-text09">${cp }</span>页
			每页显示  <select name="ps" id="pg" >
				<option value="5" ${ps==5?"selected":"" }>5</option>
				<option value="10" ${ps==10?"selected":"" }>10</option>
				<option value="15" ${ps==15?"selected":"" }>15</option>
			</select>  条
		</td>
		<td width="49%" align="right">
			[<a href="javascript:changePage('1','${ps }')" class="right-font08">${cp==1?"":"首页 |" }</a>
			 <a href="javascript:changePage('${cp-1 }','${ps }')" class="right-font08">${cp==1?"":"上一页 |" }</a>
			 <a href="javascript:changePage('${cp+1 }','${ps }')" class="right-font08">${cp==sumpage?"":"下一页 |" }</a>
			 <a href="javascript:changePage('${sumpage }','${ps }')" class="right-font08">${cp==sumpage?"":"末页" }</a>] 转至：
		</td>
		<td width="1%">
			<table width="20" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td width="1%">
						<input name="textfield3" type="text" class="right-textfield03" size="1" id="pageInput"/>
					</td>
					<td width="87%">
						<input name="Submit23222" type="button" class="right-button06" onclick="selectPage()"/>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>