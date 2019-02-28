<%@ page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ include file="/taglibs.jsp"%>
<script type="text/javascript" src="${ctx}/js/easy_validator.pack.js"></script>
<%@taglib prefix="ckeditor" uri="http://ckeditor.com"%>
<script type="text/javascript" src="${ctx}/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript" src="${ctx }/resource/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctx}/resource/admin/js/ajaxfileupload.js"></script>
<link href="${ctx}/css/validate.css" rel="stylesheet" type="text/css" />
<html>
	<head>
		<title>公告信息</title>
	</head>
	<body>
		<form id="form1" name="form1" action=""
			method="post">
<input type="hidden" value="${param.flag }" name="flag"/>
			<input type="hidden" value="${map.id }" name="id" id="id" />
			<center>
				<table class="mobile" style="width: 95%;">
					<tr class="pageheader">
						<td colspan="2">
							<strong>公告信息</strong>
						</td>
					</tr>
				
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						公告标题：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						${map.title }
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						公告内容：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						${map.content }
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						发布日期：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						${map.showDate }
					</td>
				</tr>
		<c:if test="${1==1 }"></c:if>

				</table>
			</center>
			
		</form>
	</body>