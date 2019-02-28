<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/taglibs.jsp"%>
<%@taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<style type="text/css">
@import url("${ctx}/resource/admin/displaytag/zdisplaytag.css");
@import url("${ctx}/resource/admin/displaytag/alternative.css");
</style>
<html>
	<body>
	
	<table class= "mobile">
	
		<display:table name="list"
			requestURI="Tj.html" class="list"
			id="row" cellspacing="0" cellpadding="0" pagesize="5">
			<display:column style="width:60px;" media="html" title="编号">
				<c:out value="${row_rowNum}"/>
			</display:column>
			
			
			<display:column title="课程名" property="kcName"/>
			<display:column title="计算平均分" style="width:40px;">
				<img src="${ctx}/resource/admin/images/pencil.png"
					onclick="return avg('${row.id}');" style="cursor:hand;"/>
			</display:column>
			<display:column title="平均分" property="kcAvg"/>
			
						
			
		
		</display:table>
		</table>
		
	</body>
	<script type="text/javascript">
	

	
	
	function avg(id){
		var params={id:id};
		$.post("kcAvg.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('计算成功');
			window.parent.form1.submit();
			}else{
				alert('操作失败');
			}
		});
	}
	
</script>
</html>
