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
			id="row" cellspacing="0" cellpadding="0" pagesize="10">
			<display:column style="width:60px;" media="html" title="编号">
				<c:out value="${row_rowNum}"/>
			</display:column>
			<c:if test="${param.flag==2 }">
			<display:column title="选课" style="width:40px;">
				<img src="${ctx}/resource/admin/images/pencil.png"
					onclick="return xk('${row.id}');" style="cursor:hand;"/>
			</display:column></c:if>
			<display:column title="课程属性" property="kcsx"/>
			<display:column title="课程类别" property="kcType"/>
			<display:column title="学分" property="score"/>
			<display:column title="学时" property="xs"/>
			<display:column title="任课老师" property="ls"/>
			<display:column title="课程名" property="kcName"/>
			<display:column title="上课周数" property="kcTime"/>
			<display:column title="上课星期" property="kcxq"/>
			<display:column title="上课节次" property="kcjs"/>
			<display:column title="上课地点" property="kcDD"/>
		    <display:column title="最大人数" property="kcPeople"/>
		    <display:column title="已选人数" property="kcyx"/>
						<c:choose>
							<c:when test="${param.flag==1 }"><display:column title="查看" style="width:40px;">
				<img src="${ctx}/resource/admin/images/pencil.png"
					onclick="return modifyOne('${row.id}','show');" style="cursor:hand;"/>
			</display:column>
			<display:column title="修改" style="width:40px;">
				<img src="${ctx}/resource/admin/images/pencil.png"
					onclick="return modifyOne('${row.id}','modify');" style="cursor:hand;"/>
			</display:column>
			<display:column title="删除" style="width:40px;">
				<img src="${ctx}/resource/admin/images/delete.png"
					onclick="return deleteOne('${row.id}');" style="cursor:hand;"/>
			</display:column></c:when>
							<c:when test="${param.flag==2 }"></c:when>
							<c:when test="${param.flag==3 }"></c:when>
							<c:otherwise>
							
							</c:otherwise>
						</c:choose>
			
		
		</display:table>
	</body>
	<script type="text/javascript">
	

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
	
	function xk(id){
		var params={id:id};
		$.post("xkSave.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}else{
				alert('该课程已经选择过了，不能重复选择');
			}
		});
	}
	//修改信息
	function modifyOne(id,method){
			MyWindow.OpenCenterWindow('edit.html?id='+id+'&flag=${param.flag}&method='+method,'modify',800,800);
	}
</script>
</html>
