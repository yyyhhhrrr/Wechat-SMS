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
		<title>信息内容功能</title>
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
							<strong>考试信息发布</strong>
						</td>
					</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						学生：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<select id="studentId" name="studentId">
							<c:forEach items="${studentList }" var="lists">
								<option value="${lists.id }" ${map.studentId==lists.id?'selected':'' }>${lists.studentName
									}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						课程：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<select id="kcId" name="kcId">
							<c:forEach items="${kcList }" var="lists">
								<option value="${lists.id }" ${map.kcId==lists.id?'selected':'' }>${lists.kcName
									}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						标题：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="title" value="${map.title }" name="title"/>
					</td>
				</tr>
				
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						内容：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<textarea rows="5"  id="content" cols="50" name="content">${map.content }</textarea>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						考试日期：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input  readonly="readonly" name="showDate" id="showDate" value="<fmt:formatDate value="${map.showDate }" type="date" pattern="yyyy-MM-dd HH：mm：ss"/>" type="text" onClick="WdatePicker({ dateFmt: 'yyyy-MM-dd HH:mm:ss' })"/>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						考试地点：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="ksdd" value="${map.ksdd }" name="ksdd"/>
					</td>
				</tr>
		<c:if test="${1==1 }"></c:if>

				</table>
			</center>
			<p align="center">
				<br>
<c:if test="${param.method!='show' }">					<input type="button" class="btn" value="保  存" onclick="save(this);" /></c:if>
				<input type="button" class="btn" value="关  闭"
					onclick="window.close();" />
			</p>
		</form>
	</body>
	<script type="text/javascript">
	
	
	function save(src) {
		$.post("editSave.html",$("#form1").serializeArray(),
		       function(result){
		        	result = eval("("+result+")");
		    		if(result.status == "true" || result.status == true){
		    			alert('成功');
		    			saveAnd();
		    		}else{
		    			alert('保存失败，请重试');
		    		}
		        }
			);
	}
	function triggerUploadImg0(src) {
		$.ajaxFileUpload({
			url : '${ctx}/file/upload.json',
			secureuri : false,
			fileElementId : 'f_fileImg0',
			dataType : 'json',
			data : {
				fileloc : 'upload/',
				dir : 'temp'
			},
			success : function(data, status) {
				$("#bbbbbImg0").val(data.data.filepath);
				$("#aaaaaImg0").remove();
				$("#bbbbbImg0").after("<img  id='aaaaaImg0' style='width:100px;' src='${ctx}/"+data.data.filepath+"' />");
			},
			error : function(data, status, e) {alert('文件上传失败');}
		});
	}
	function triggerUpload(src) {
		$.ajaxFileUpload({
			url : '${ctx}/file/upload.json',
			secureuri : false,
			fileElementId : 'f_file',
			dataType : 'json',
			data : {
				fileloc : 'upload/',
				dir : 'temp'
			},
			success : function(data, status) {
				$("input[name='img']").val(data.data.filepath);
				$("#imgUrlShow").attr("src",
						"${ctx}/" + data.data.filepath + "");
			},
			error : function(data, status, e) {alert('文件上传失败');}
		});
	}
</script>
</html>
