<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html;charset=utf-8"%>
<%@ include file="/taglibs.jsp"%>
<script type="text/javascript" src="${ctx}/js/easy_validator.pack.js"></script>
<script type="text/javascript" src="${ctx}/js/jquery.bgiframe.min.js"></script>
<script type="text/javascript"
	src="${ctx }/resource/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript"
	src="${ctx}/resource/admin/js/ajaxfileupload.js"></script>
<link href="${ctx}/css/validate.css" rel="stylesheet" type="text/css" />
<html>
<head>
<title>信息内容功能</title>
</head>
<body>
	<form id="form1" name="form1" action="" method="post">
		<input type="hidden" value="${map.id }" name="id" id="id" />
		<center>
			<table class="mobile" style="width: 95%;">
				<tr class="pageheader">
					<td colspan="2"><strong>个人信息</strong></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">姓名： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" id="teacherName"
						value="${map.teacherName }" name="teacherName" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">年龄： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" id="age"
						value="${map.age }" name="age" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">性别： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><select id="sex" name="sex">
							<option value="男" ${map.sex=='男'?'selected':'' }>男</option>
							<option value="女" ${map.sex=='女'?'selected':'' }>女</option>
					</select></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">电话： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" id="phone"
						value="${map.phone }" name="phone" /></td>
				</tr>
				
				
			</table>
		</center>
		<p align="center">
			<br> <input type="button" class="btn" value="保  存"
				onclick="save(this);" />
		</p>
	</form>
</body>
<script type="text/javascript">
	function save(src) {
		$.post("${ctx}/teacher/mineSave.html", $("#form1").serializeArray(),
				function(result) {
					result = eval("(" + result + ")");
					if (result.status == "true" || result.status == true) {
						alert('成功');
						window.location.reload();
					} else {
						alert('保存失败，请重试');
					}
				});
	}
	function triggerUploadImg0(src) {
		$
				.ajaxFileUpload({
					url : '${ctx}/file/upload.html',
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
						$("#bbbbbImg0")
								.after(
										"<img  id=\"aaaaaImg0\" style='width:100px;' src='${ctx}/"+data.data.filepath+"' />");
					},
					error : function(data, status, e) {
						alert('文件上传失败');
					}
				});
	}
	function triggerUpload(src) {
		$.ajaxFileUpload({
			url : '${ctx}/file/upload.html',
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
			error : function(data, status, e) {
				alert('文件上传失败');
			}
		});
	}
</script>
</html>
