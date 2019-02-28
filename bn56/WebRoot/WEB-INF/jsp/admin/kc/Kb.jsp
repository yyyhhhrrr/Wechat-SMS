<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@   page   import= "com.sxl.WeiXinSQL.MySQLUtil "%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page contentType="text/html;charset=GBK" import="java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  

<head>  
<title>${studentBean.studentName }</title>  
</head>  
<center>  
<h1  align="center"><b><em><caption>课程表</caption></em></b></h1>  
  
<table width="1000" height="1000" border="1" align="center">

<tr>  
<td width="76"> </td>  
<td width="85" height="50"> </td>  
<td width="100">周一</td>  
<td width="100">周二</td>  
<td width="100">周三</td>  
<td width="100">周四</td>  
<td width="100">周五</td>  
<td width="100">周六</td>  
<td width="108">周日</td>  
</tr>  

<tr>  
<td rowspan="4">上午</td>  
<td>第一节（8:00~8:45）</td>   <%--获取课程名、授课老师、上课地点 --%> 
<td rowspan="2">${Kb1.kcName }-${Kb1.ls }-${Kb1.kcDD }</td>   
<td rowspan="2">${Kb2.kcName }-${Kb2.ls }-${Kb2.kcDD }</td>  
<td rowspan="2">${Kb3.kcName }-${Kb3.ls }-${Kb3.kcDD }</td>  
<td rowspan="2">${Kb4.kcName }-${Kb4.ls }-${Kb4.kcDD }</td>  
<td rowspan="2">${Kb5.kcName }-${Kb5.ls }-${Kb5.kcDD }</td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
</tr>  
<tr>  
  
<td>第二节（8：50~9:35）</td>  
</tr>  
<tr>  
  
<td>第三节（9:50~10:35）</td>  
<td rowspan="2">${Kb6.kcName }-${Kb6.ls }-${Kb6.kcDD }</td>   
<td rowspan="2">${Kb7.kcName }-${Kb7.ls }-${Kb7.kcDD }</td>  
<td rowspan="2">${Kb8.kcName }-${Kb8.ls }-${Kb8.kcDD }</td>  
<td rowspan="2">${Kb9.kcName }-${Kb9.ls }-${Kb9.kcDD }</td>  
<td rowspan="2">${Kb10.kcName }-${Kb10.ls }-${Kb10.kcDD }</td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
</tr>  
<tr>  
  
<td>第四节（10:40~11:25）</td>  
</tr>  
<tr>  
<td colspan="8" align="center"><b>午休</b></td>  
</tr>  
<tr>  
<td rowspan="4">下午</td>  
<td>第五节（13:30~14:15）</td>  
<td rowspan="2">${Kb11.kcName }-${Kb11.ls }-${Kb11.kcDD }</td>   
<td rowspan="2">${Kb12.kcName }-${Kb12.ls }-${Kb12.kcDD }</td>  
<td rowspan="2">${Kb13.kcName }-${Kb13.ls }-${Kb13.kcDD }</td>  
<td rowspan="2">${Kb14.kcName }-${Kb14.ls }-${Kb14.kcDD }</td>  
<td rowspan="2">${Kb15.kcName }-${Kb15.ls }-${Kb15.kcDD }</td>    
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
</tr>  
<tr>  
  
<td>第六节（14:20~15:05）</td>  
</tr>  
<tr>  
  
<td>第七节（15:20~16:05）</td>  
<td rowspan="2">${Kb16.kcName }-${Kb16.ls }-${Kb16.kcDD }</td>   
<td rowspan="2">${Kb17.kcName }-${Kb17.ls }-${Kb17.kcDD }</td>  
<td rowspan="2">${Kb18.kcName }-${Kb18.ls }-${Kb18.kcDD }</td>  
<td rowspan="2">${Kb19.kcName }-${Kb19.ls }-${Kb19.kcDD }</td>  
<td rowspan="2">${Kb20.kcName }-${Kb20.ls }-${Kb20.kcDD }</td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
</tr>  
<tr>  
  
<td>第八节（16:10~16:55）</td>  
</tr> 
<tr>  
<td rowspan="4">晚上</td>  
<td>第九节（18:30~19:15）</td> 
<td rowspan="2">${Kb21.kcName }-${Kb21.ls }-${Kb21.kcDD }</td>   
<td rowspan="2">${Kb22.kcName }-${Kb22.ls }-${Kb22.kcDD }</td>  
<td rowspan="2">${Kb23.kcName }-${Kb23.ls }-${Kb23.kcDD }</td>  
<td rowspan="2">${Kb24.kcName }-${Kb24.ls }-${Kb24.kcDD }</td>  
<td rowspan="2">${Kb25.kcName }-${Kb25.ls }-${Kb25.kcDD }</td>    
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
</tr>   
<tr>  
  
<td>第十节（19:20~20:05）</td>  
</tr>  

</table>  
</center>  
</body>  
</html>  