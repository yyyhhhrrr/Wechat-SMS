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
			<c:if test="${param.flag==1 }">
			<display:column title="账号" property="username"/>
			<display:column title="密码 " property="password"/></c:if>
			<display:column title="姓名" property="studentName"/>
			<display:column title="学院" property="xueyuan"/>
			<display:column title="专业" property="zhuanye"/>
			<display:column title="班级" property="bjName"/>
			<display:column title="年龄" property="age"/>
			<display:column title="性别" property="sex"/>
			<display:column title="类型" property="type"/>
			<display:column title="电话" property="phone"/>
			<display:column title="QQ" property="qq"/>
			<display:column title="邮箱" property="email"/>
			<display:column title="家庭住址" property="zhuzhi"/>
					<display:column title="学号" property="xh"/>
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
	
		//更新字段内容
	function updateColumnbjId(bjId,id){
		if(!confirm("确定要更新为"+bjId+"吗?")){
			return false;
		}
		//var aaa = prompt("请输入操作意见或说明：","");
		var params={id:id,bjId:bjId};
		$.post("updateColumnbjId.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
		//更新字段内容
	function updateColumnsex(sex,id){
		if(!confirm("确定要更新为"+sex+"吗?")){
			return false;
		}
		//var aaa = prompt("请输入操作意见或说明：","");
		var params={id:id,sex:sex};
		$.post("updateColumnsex.html",params,function(
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
