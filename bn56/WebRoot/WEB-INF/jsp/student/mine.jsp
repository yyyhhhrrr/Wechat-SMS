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
					<td class="outDetail2"><input type="text" id="studentName"
						value="${map.studentName }" name="studentName" /></td>
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
					<td class="outDetail" style="width: 30%">学院： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" id="xueyuan"
						value="${map.xueyuan }" name="xueyuan" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">专业： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" id="zhuanye"
						value="${map.zhuanye }" name="zhuanye" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						班级：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<select id="bjId" name="bjId">
							<c:forEach items="${bjList }" var="lists">
								<option value="${lists.id }" ${map.bjId==lists.id?'selected':'' }>${lists.bjName
									}</option>
							</c:forEach>
					</select>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">类型： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" id="type"
						value="${map.type }" name="type" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">电话： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" id="phone"
						value="${map.phone }" name="phone" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">QQ： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" id="qq"
						value="${map.qq }" name="qq" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">邮箱： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" id="email"
						value="${map.email }" name="email" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">家庭住址： <label
						style="font-weight: bold; color: red"> * </label></td>
					<td class="outDetail2"><input type="text" id="zhuzhi"
						value="${map.zhuzhi }" name="zhuzhi" /></td>
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
		$.post("${ctx}/student/mineSave.html", $("#form1").serializeArray(),
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
