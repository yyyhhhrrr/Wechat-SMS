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
							<strong>信息处理</strong>
						</td>
					</tr>
					<tr height="25">
					<td class="outDetail" style="width: 30%">
						课程属性：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="kcsx" value="${map.kcsx }" name="kcsx"/>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						课程类别：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="kcType" value="${map.kcType }" name="kcType"/>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						学分：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="score" value="${map.score }" name="score"/>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						学时：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="xs" value="${map.xs }" name="xs"/>
					</td>
				</tr>
				
			
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						任课老师：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="ls" value="${map.ls }" name="ls"/>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						课程名称：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="kcName" value="${map.kcName }" name="kcName"/>
					</td>
				</tr>
				
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						上课周数：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="kcTime" value="${map.kcTime }" name="kcTime"/>
					</td>
                    </tr>
                    <tr height="25">
					<td class="outDetail" style="width: 30%">
						上课星期：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="kcxq" value="${map.kcxq }" name="kcxq"/>
					</td>
                    </tr>
                    <tr height="25">
					<td class="outDetail" style="width: 30%">
						上课节次：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="kcjs" value="${map.kcjs }" name="kcjs"/>
					</td>
                    </tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						上课地点：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="kcDD" value="${map.kcDD }" name="kcDD"/>
					</td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">
						最大人数：
						<label style="font-weight: bold; color: red">
						</label>
					</td>
					<td class="outDetail2">
						<input type="text" id="kcPeople" value="${map.kcPeople }" name="kcPeople"/>
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
