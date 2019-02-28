<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page contentType="text/html;charset=GBK" import="java.sql.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
<head>  
<title>课程表</title>  
</head>  
<center>  
<h1  align="center"><b><em><caption>课程表</caption></em></b></h1>  
  
<table width="1000" height="1000" border="1" align="center">
<%  
try {  
 Class.forName("com.mysql.jdbc.Driver").newInstance();  
 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bn56?user=root&password=960314&useUnicode=true&characterEncoding=GBK");

  
 String sql="select kcName from t_kc where kcxq='星期一' " ;


 PreparedStatement ps =con.prepareStatement(sql);
  
 
 ResultSet rs = ps.executeQuery();  

 
%>
<tr>  
<td width="76"> </td>  
<td width="86" height="50"> </td>  
<td width="100">周一</td>  
<td width="100">周二</td>  
<td width="100">周三</td>  
<td width="100">周四</td>  
<td width="100">周五</td>  
<td width="100">周六</td>  
<td width="108">周日</td>  
</tr>  
<%
 while(rs.next()){
 %>
<tr>  
<td rowspan="4">上午</td>  
<td>1</td>  
<td rowspan="2"><%=rs.getString("kcName") %></td>  
<%
 }
%>
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
</tr>  
<tr>  
  
<td>2</td>  
</tr>  
<tr>  
  
<td>3</td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
</tr>  
<tr>  
  
<td>4</td>  
</tr>  
<tr>  
<td colspan="8" align="center"><b>午休</b></td>  
</tr>  
<tr>  
<td rowspan="4">下午</td>  
<td>5</td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
</tr>  
<tr>  
  
<td>6</td>  
</tr>  
<tr>  
  
<td>7</td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
</tr>  
<tr>  
  
<td>8</td>  
</tr> 
<tr>  
<td rowspan="4">晚上</td>  
<td>9</td> 
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
<td rowspan="2"> </td>  
</tr>   
<tr>  
  
<td>10</td>  
</tr>  
<% rs.close();
 ps.close();
 con.close();
}catch(SQLException sqle){
 out.println("sqle="+sqle); 
}finally{
 
}
%>
</table>  
</center>  
</body>  
</html>  