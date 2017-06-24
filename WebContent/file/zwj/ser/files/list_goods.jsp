<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<jsp:include page="../../../../util/base.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>商品管理系统</title>
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
<script type="text/javascript">
	function sousuo() {
		window.open("gaojisousuo.htm","","depended=0,alwaysRaised=1,width=800,height=510,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}
	//全选商品
	function selectAll() {
		var obj = document.fom.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				obj[i].checked = true;
			}
		}
	}
	//反选商品
	function unselectAll() {
		var obj = document.fom.elements;
		for (var i = 0; i < obj.length; i++) {
			if (obj[i].name == "delid") {
				if (obj[i].checked == true)
					obj[i].checked = false;
				else
					obj[i].checked = true;
			}
		}
	}
	
	//添加商品
	function addgoods(){
		location.href="gsc/sgd?option=add";
		
	}
	//删除单条商品
	function deleteGood(id){
		var bool=confirm("确认删除该商品");
		if(bool==true){
			location.href="gsc/deletegood?goodId="+id;
		}
	}
	
	//批量删除商品
	function deleteAll(){
		var bool=confirm("确认删除选中商品");
		if(bool==true){
			var str="";
			$(".cb:checked").each(function(index,element){
				if(index==0){
					str=str+element.value;
				}else{
					str=str+","+element.value;
				}
			});
			if(str==null||str==""){
				alert("请选择要删除的商品");
				return;
			}
			var ps = $("#ps_hide").val();
			location.href="gsc/deleteall?delId="+str+"&ps="+ps;
		}
	}
	//设置首页轮播图
	function setTurn(goodId){
		var flag=confirm("确定设为首页轮播图？");
		if(flag){
			$.get("gsc/sti?goodId="+goodId,function(data){
				if(data=="ok"){
					alert('设置成功');
				}else{
					alert('设置失败了');
				}
			});
		}
	}
	$(function(){
		$("#sl_day").change(function(){
			var styleId=$(this).val();
			var ps=$("#ps_hide").val();
			location.href="gsc/cag?styleId="+styleId+"&cp="+1+"&ps="+ps;
		})
	})
	
</script>
</head>
<body>
	<input type="hidden" id="sumpage_hide" value="${sumpage }"/>
	<input type="hidden" id="ps_hide" value="${ps }"/>
	<input type="hidden" id="styleId" value="${styleId }"/>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="62" background="file/zwj/link/images/nav04.gif">
							
							
							<!-- 顶部搜索部分 -->
							<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td width="21">
										<img src="file/zwj/link/images/ico07.gif" width="20" height="18" />
									</td>
									<td width="538">
										查看内容：商品分类： 
										<select id="sl_day">
											<option value="0">查看所有</option>
											<c:forEach var="s" items="${goodStyles }">
												<option value="${s.styleId }" ${s.styleId==styleId?"selected":"" }>${s.styleName }</option>
											</c:forEach>
										</select>
									</td>
									<td width="144" align="left">
										
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				<table id="subtree1" width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td>
						
							<!-- 全选部分 -->
							<table width="95%" border="0" align="center" cellpadding="0" cellspacing="0">
								<tr>
									<td height="20">
										<!-- <span class="newfont07">
											选择：<a href="javascript:void(0)" class="right-font08" onclick="selectAll();">全选</a>
											-<a href="javascript:void(0)" class="right-font08" onclick="unselectAll();">反选</a>
										</span> -->
										<!-- <input name="Submit" type="button" class="right-button08" value="删除商品" onclick="deleteAll()"/> -->
										<input name="Submit2" type="button" class="right-button08" value="添加商品" onclick="addgoods()" />
									</td>
								</tr>
								<tr>
									<td height="40" class="font42">
									
									
										<!-- 表格部分 -->
										<table width="100%" border="0" cellpadding="4" cellspacing="1" bgcolor="#464646" class="newfont03">
											<tr class="CTitle">
												<td height="22" colspan="7" align="center" style="font-size: 16px">商品详细列表</td>
											</tr>
											<tr bgcolor="#EEEEEE">
												<!-- <td width="4%" align="center" height="30">选择</td> -->
												<td width="4%" align="center">商品ID</td>
												<td width="5%" align="center">商品名</td>
												<td width="5%" align="center">原价</td>
												<td width="5%" align="center">折后价</td>
												<td width="3%" align="center">单位</td>
												<td width="3%" align="center">是否包邮</td>
												<td width="4%" align="center">已售数量</td>
												<td width="15%" align="center">商品描述</td>
												<td width="3%" align="center">商品状态</td>
												<td width="5%" align="center">操作</td>
											</tr>
											
											
											<c:forEach var="g" items="${goods }">
												<tr bgcolor="#FFFFFF">
													<%-- <td height="20"><input type="checkbox" name="delid" value="${g.goodId }" class="cb"/></td> --%>
													<td>${g.goodId }</td>
													<td><a href="gsc/sgd?goodId=${g.goodId }&option=update">${g.goodName }</a></td>
													<td>${g.goodOriginalPrice }</td>
													<td>${g.goodDiscountedPrice }</td>
													<td>${g.specification }</td>
													<td>${g.freeDelivery==1?"包邮":"不包邮" }</td>
													<td>${g.salsNum}</td>
													<td>${fn:substring(g.goodDesc,0,20)}${fn:length(g.goodDesc)>20?"...":"" }</td>
													<td>${g.goodStatus==1?"上架":"下架" }</td>
													<td>
														<a href="javascript:setTurn('${g.goodId} ')">设为首页轮播图</a>
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
								<tr>
									<td height="33">
										<c:import url="navigationbar.jsp"></c:import>
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
