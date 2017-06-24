<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../../../../util/base.jsp"></jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" rev="stylesheet" href="file/zwj/link/css/style.css" type="text/css" media="all" />
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="file/zwj/link/js/uploadPreview.js"></script>
<script language="JavaScript" type="text/javascript">
	function tishi() {
		var a = confirm('数据库中保存有该人员基本信息，您可以修改或保留该信息。');
		if (a != true)
			return false;
		window.open("冲突页.htm","","depended=0,alwaysRaised=1,width=800,height=400,location=0,menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0");
	}

	function check() {
		document.getElementById("aa").style.display = "";
	}

	function save() {
		var goodName=$("#goodName").val();
		if(goodName==null||goodName.trim()==""){
			alert("商品名不能为空");
			
			$("#goodName").select();
			return;
		}
		var styleId=$("#styleId").val();
		if(styleId==0){
			alert("请选择商品类别");
			return;
		}
		
		var goodOriginalPrice=$("#goodOriginalPrice").val();
		if(goodOriginalPrice==null||goodOriginalPrice.trim()==""){
			alert("请输入商品原价");
			$("#goodOriginalPrice").select();
			return;
		}
		var goodDiscountedPrice=$("#goodDiscountedPrice").val();
		if(goodDiscountedPrice==null||goodDiscountedPrice.trim()==""){
			alert("请输入商品折后价");
			$("#goodDiscountedPrice").select();
			return;
		}
		
		var file=$(".imgfile").val();
		if(file==null||file==""){
			alert("请添加商品图片")
			return;
		}
		
		var specification=$("#specification").val();
		if(specification==null||specification.trim()==""){
			alert("请输入商品单位");
			$("#specification").select();
			return;
		} 
		var desc=$("#goodDesc").val();
		if(desc==null||desc.trim()==""){
			alert("请输入商品描述");
			$("#goodDesc").select();
			return;
		} 
		$("#fom").submit();
	}
	$(function(){
		$("#up").uploadPreview({IMG:"ImgPr"});
	});
	
</script>
<style type="text/css">

.atten {
	font-size: 12px;
	font-weight: normal;
	color: #F00;
}

</style>
</head>
<body class="ContentBody">
	<form action="${type=='编辑'?'gsc/updategood':'gsc/addgood' }" method="post" enctype="multipart/form-data" id="fom" >
		<input type="hidden" name="goodId" value="${good.goodId }"/>
		<div class="MainDiv">
			<table width="99%" border="0" cellpadding="0" cellspacing="0" class="CContent">
				<tr>
					<th class="tablestyle_title">商品${type }页面</th>
				</tr>
				<tr>
					<td class="CPanel">
						<table border="0" cellpadding="0" cellspacing="0" style="width: 100%">
							<tr>
								<td width="100%">
									<fieldset style="height: 100%;">
										<legend>${type }商品</legend>
										<table border="0" cellpadding="2" cellspacing="1" style="width: 100%">
											<tr>
												<td nowrap align="right" width="13%"><span class="red"> *</span>商品名:</td>
												<td width="21%">
													<input id="goodName" name="goodName" class="text" style="width: 250px" type="text" size="40" value="${good.goodName }"/>
												</td>
												<td align="right" width="19%"><span class="red"> *</span>商品类型:</td>
												<td width="37%">
													<select id="styleId" name="styleId">
														<option value="0">----请选择----</option>
														<c:forEach var="n" items="${goodStyle }">
															<option value="${n.styleId }" ${sId==n.styleId?"selected":"" }>${n.styleName }</option>
														</c:forEach>
													</select>
												</td>
											</tr>
											<tr>
												
												<td align="right"><span class="red"> *</span>商品原价:</td>
												<td>
													<input id="goodOriginalPrice" name="goodOriginalPrice" class="text" value="${good.goodOriginalPrice }" style="width: 154px" />&nbsp;&nbsp;&nbsp;&nbsp;<span>如:1830.40</span>
												</td>
												<td align="right"><span class="red"> *</span>商品折后价:</td>
												<td>
													<input id="goodDiscountedPrice" name="goodDiscountedPrice" class="text" value="${good.goodDiscountedPrice }" style="width: 154px" />
												</td>
											</tr>
											<tr>
												<td nowrap align="right"><span class="red"> *</span>上传图片:</td>
												<td>
													<input type="file" name="pic" class="imgfile"/>
													<input type="file" name="pic" class="imgfile"/>
													<input type="file" name="pic" class="imgfile"/>
													<input type="file" name="pic" class="imgfile"/>
													<input type="file" name="pic" class="imgfile"/>
													<%-- <img id="ImgPr" width="60" height="60" src="${good.goodPicPath }"/> --%>
												</td>
												<td align="right">是否包邮:</td>
												<td>
													<input type="radio" name="freeDelivery" value="1" ${good.freeDelivery==1||good.freeDeliver==null?"checked":"" } />是&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<input type="radio" name="freeDelivery" value="0" ${good.freeDelivery==0?"checked":"" }/>不是<br>
												</td>
											</tr>
											<tr>
												<td nowrap align="right"><span class="red"> *</span>商品单位:</td>
												<td>
													<input id="specification" type="text" name="specification" value="${good.specification }">
												</td>
												<td align="right">是否上架:</td>
												<td>
													<input type="radio" name="goodStatus" value="1" ${good.goodStatus==1||good.goodStatus==null?"checked":"" }/>上架&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<input type="radio" name="goodStatus" value="0" ${good.goodStatus==0?"checked":"" }/>下架<br>
								
												</td>
											</tr>
											<tr>
												<td nowrap align="right" height="20px">商品服务:</td>
												<td colspan="3">
													<c:forEach var="s" items="${allService }">
														<input type="checkbox" name="goodService" value="${s.serviceId }" ${s.checkStatus==1?"checked":"" }>${s.serviceName }&nbsp;&nbsp;&nbsp;
													</c:forEach>
												</td>
											</tr>
											<tr>
												<td nowrap align="right" height="120px"><span class="red"> *</span>商品描述:</td>
												<td colspan="3">
													<textarea id="goodDesc" name="goodDesc" rows="5" cols="80" >${good.goodDesc }</textarea>
												</td>
											</tr>
											<tr>
												<td nowrap align="right" height="20px"><a href="gsc/cgi?goodId=${good.goodId }">${good.goodId!=null?"查看图片详情":"" }</a></td>
												
											</tr>
										</table>
										<br />
									</fieldset>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center" height="50px">
						<input type="button" value="保存" class="button" onclick="save()" /> 
						<input type="button" value="返回" class="button" onclick="window.history.go(-1)" />
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>