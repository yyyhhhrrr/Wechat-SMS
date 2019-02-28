<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/taglibs.jsp"%>
<%@taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<style type="text/css">
@import url("${ctx}/resource/admin/displaytag/zdisplaytag.css");
@import url("${ctx}/resource/admin/displaytag/alternative.css");
</style>
<html>
	<body>
		<display:table name="wxlist"
			requestURI="wxlist.html" class="list"
			id="row" cellspacing="0" cellpadding="0" pagesize="10">
			<display:column style="width:60px;" media="html" title="编号">
				<c:out value="${row_rowNum}"/>
			</display:column>
			
			<display:column title="openId" property="openid"/>
			<display:column title="学生姓名" property="studentName"/>
			<display:column title="微信昵称 " property="wxname"/>
			<display:column title="性别" property="sex"/>
			<display:column title="国家" property="country"/>
			<display:column title="省份" property="province"/>
			<display:column title="城市" property="city"/>
			<display:column title="头像">
				<img style="width:100px;" src="${ctx}/${row.headimgurl}"/>
			</display:column>
			<display:column title="删除" style="width:40px;">
				<img src="${ctx}/resource/admin/images/delete.png"
					onclick="return deleteOne('${row.id}');" style="cursor:hand;"/>
			</display:column>
			
		
		</display:table>
	</body>
	<script type="text/javascript">
	
	
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

</script>
</html>
