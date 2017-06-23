<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basepath%>"/>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>项目管理系统</title>
<link href="file/zwj/link/css/css.css" rel="stylesheet" type="text/css" />
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
</style>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="59" background="file/zwj/link/images/top.gif">
	    <table width="99%" border="0" cellspacing="0" cellpadding="0">
	      <tr>
	        <td width="1%">
	        	<a href="http://www.mycodes.net/admin-templates/" target="_blank">
	        		<img src="file/zwj/link/images/logo.gif" width="557" height="59" border="0" />
	        	</a>
	        </td>
	        <td width="64%" align="right" style="font-size:12px;vertical-align:bottom;">
	        	&copy; 2009 
	        	<a href="http://www.mycodes.net/admin-templates/" style="color:#0099FF;text-decoration:none;">www.mycodes.net</a> 
	        	QQ:123456 Email:123456@qq.com
	        </td>
	      </tr>
	    </table>
    </td>
  </tr>
</table>
</body>
</html>
