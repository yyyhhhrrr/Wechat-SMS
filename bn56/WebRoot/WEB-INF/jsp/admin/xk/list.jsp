<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/taglibs.jsp"%>
<%@taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<style type="text/css">
@import url("${ctx}/resource/admin/displaytag/zdisplaytag.css");
@import url("${ctx}/resource/admin/displaytag/alternative.css");
</style>
<html>
	<body>
		<display:table name="list"
			requestURI="list.html" class="list"
			id="row" cellspacing="0" cellpadding="0" pagesize="5">
			<display:column style="width:60px;" media="html" title="编号">
				<c:out value="${row_rowNum}"/>
			</display:column>
			
			<display:column title="课程" property="kcName"/>
			<display:column title="学生" property="studentName"/>
			<display:column title="成绩" property="cj"/>
			<display:column title="学分" property="score"/>
			<display:column title="学时" property="xs"/>
			<display:column title="属性" property="kcsx"/>
			<display:column title="课程类别" property="kcType"/>
			<display:column title="状态" property="status"/>
						<c:choose>
							<c:when test="${param.flag==1 }">
							<display:column title="删除" style="width:40px;">
				<img src="${ctx}/resource/admin/images/delete.png"
					onclick="return deleteOne('${row.id}');" style="cursor:hand;"/>
			</display:column>
			<display:column title="操作">
<c:if test="${row.status=='待考试' }"><a href="javascript:updateColumnstatus('完成','${row.id}');">录入成绩</a><br/>				</c:if>
			</display:column>
							</c:when>
							<c:when test="${param.flag==2 }">
							<display:column title="退选" style="width:40px;">
				<img src="${ctx}/resource/admin/images/delete.png"
					onclick="return deleteOne('${row.id}');" style="cursor:hand;"/>
			</display:column></c:when>
							<c:when test="${param.flag==3 }"></c:when>
							<c:otherwise>
							
							</c:otherwise>
						</c:choose>
			
		<c:if test="${1==1 }"></c:if>
		</display:table>
	</body>
	<script type="text/javascript">
		
		
		//更新字段内容
	function updateColumnckId(ckId,id){
		if(!confirm("确定要更新为"+ckId+"吗?")){
			return false;
		}
		//var aaa = prompt("请输入操作意见或说明：","");
		var params={id:id,ckId:ckId};
		$.post("updateColumnckId.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
		//更新字段内容
	function updateColumnstudnetId(studnetId,id){
		if(!confirm("确定要更新为"+studnetId+"吗?")){
			return false;
		}
		//var aaa = prompt("请输入操作意见或说明：","");
		var params={id:id,studnetId:studnetId};
		$.post("updateColumnstudnetId.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
		//更新字段内容
	function updateColumnstatus(status,id){
		
		var aaa = prompt("请输入成绩：","");
		var params={id:id,status:status,aaa:aaa};
		$.post("updateColumnstatus.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
	//删除确定
	function deleteOne(id){
		if(!confirm("确定要删除吗?")){
			return false;
		}
  //var aaa = prompt("请输入操作意见或说明：","");
		var params={id:id};
		$.post("editDelete.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
	//修改信息
	function modifyOne(id,method){
			MyWindow.OpenCenterWindow('edit.html?id='+id+'&flag=${param.flag}&method='+method,'modify',800,800);
	}
</script>
</html>
