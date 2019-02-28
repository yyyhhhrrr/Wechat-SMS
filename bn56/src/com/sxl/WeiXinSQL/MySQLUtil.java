package com.sxl.WeiXinSQL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sxl.entity.GongGao;
import com.sxl.util.Message;


/**
 * Mysql数据库操作类
 * 
 *
 */
public class MySQLUtil {
	/**
	 * 获取Mysql数据库连接
	 * 
	 * @return Connection
	 */
	private Connection getConn() {
		String url = "jdbc:mysql://localhost:3306/bn56";
		String username = "root";
		String password = "960314";
		Connection conn = null;
		try {
			// 加载MySQL驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接
			conn = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 释放JDBC资源
	 * 
	 * @param conn 数据库连接
	 * @param ps
	 * @param rs 记录集
	 */
	private void releaseResources(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (null != rs)
				rs.close();
			if (null != ps)
				ps.close();
			if (null != conn)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取公告表中所有记录
	 * 
	 * @return List<Knowledge>
	 */
	/*public static List<GongGao> findAllGongGao() {
		List<GongGao> GongGaoList = new ArrayList<GongGao>();
		String sql = "select * from t_gg";
		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				GongGao gg = new GongGao();
				gg.setId(rs.getInt("id"));
				gg.setTitle(rs.getString("title"));
				gg.setContent(rs.getString("content"));
				
				GongGaoList.add(gg);
				System.out.println(gg);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return GongGaoList;
	}
*/
	/**
	 * 获取一个公告
	 * 
	 * @param 
	 * @return
	 */
	public static String getGG1() {
		String GongGao = "";
		String sql = "select *from t_gg where id=1 ";

		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				
				GongGao = "校园公告："+rs.getString("id")+":"+rs.getString("title")+"\n"+rs.getString("content");
				System.out.println(GongGao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return GongGao;
	}

	public static String getGG2() {
		String GongGao = "";
		String sql = "select *from t_gg where id=2 ";

		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				
				GongGao = "校园公告："+rs.getString("id")+":"+rs.getString("title")+"\n"+rs.getString("content");
				System.out.println(GongGao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return GongGao;
	}
	
	public static String getGG3() {
		String GongGao = "";
		String sql = "select *from t_gg where id=3 ";

		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				
				GongGao = "校园公告："+rs.getString("id")+":"+rs.getString("title")+"\n"+rs.getString("content");
				System.out.println(GongGao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return GongGao;
	}
	
	public static String getGG4() {
		String GongGao = "";
		String sql = "select *from t_gg where id=4 ";

		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				
				GongGao = "校园公告："+rs.getString("id")+":"+rs.getString("title")+"\n"+rs.getString("content");
				System.out.println(GongGao);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return GongGao;
	}
	
	public static String getInfo(String toUserName) {
		String Info = "";
		String sql ="select * from t_openid left join t_student on t_openid.username = t_student.username left join t_bj on t_student.bjId = t_bj.id where openid = ?";
        String openid =Message.getOpenid(toUserName);
		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(openid);
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,openid);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Info = "个人信息：\n"+"学号："+rs.getString("username")+"\n"+"姓名："+rs.getString("studentName")+"\n"+"专业："+rs.getString("zhuanye")+"\n"+"学院："+rs.getString("xueyuan")+"\n"+"班级："+rs.getString("bjName")+"\n"+"类型："+rs.getString("type")+"\n"+"年龄："+rs.getString("age")+"\n"+"性别："+rs.getString("sex")+"\n"+"手机号："+rs.getString("phone")+"\n"+"QQ:"+rs.getString("qq")+"\n"+"邮箱："+rs.getString("email")+"\n"+"住址："+rs.getString("zhuzhi");
				System.out.println(Info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return Info;
	}
	
	
	public static String getKc(String toUserName) {//查询所有课程的方法
		String kc = "";
		String KCXX="";
		String sql ="select * from t_openid left join t_student on t_openid.username = t_student.username left join t_bj on t_student.bjId = t_bj.id left join t_xk on t_student.id = t_xk.studnetId left join t_kc on t_xk.ckId = t_kc.id where openid = ? ";
        String openid =Message.getOpenid(toUserName);
        StringBuffer kcxx=new StringBuffer();
		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(openid);
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,openid);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				kc = "本学期课程:\n"+"课程名："+rs.getString("kcName")+"\n"+"学分："+rs.getString("score")+"\n"+"学时："+rs.getString("xs")+"\n"+"属性："+rs.getString("kcsx")+"\n"+"课程类别："+rs.getString("kcType")+"\n"+"授课老师："+rs.getString("ls")+"\n"+"开课周数："+rs.getString("kcTime")+"\n"+"开课时间："+rs.getString("kcxq")+"；"+rs.getString("kcjs")+"\n"+"上课地点："+rs.getString("kcDD");
				kcxx.append(kc);
				kcxx.append("\n\n");
				KCXX=kcxx.toString();
				
			}
			//System.out.println(KCXX);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return KCXX;
	}
	
	public static String getKc2(String toUserName,String kcName) {//查询一个课程的课程信息的方法
		String kc = "";
		String sql ="select * from t_openid left join t_student on t_openid.username = t_student.username left join t_bj on t_student.bjId = t_bj.id left join t_xk on t_student.id = t_xk.studnetId left join t_kc on t_xk.ckId = t_kc.id where openid =? and kcName=? ";
        String openid =Message.getOpenid(toUserName);
		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(openid);
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,openid);
			ps.setString(2,kcName);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				kc = "本学期课程:\n"+"课程名："+rs.getString("kcName")+"\n"+"学分："+rs.getString("score")+"\n"+"学时："+rs.getString("xs")+"\n"+"属性："+rs.getString("kcsx")+"\n"+"课程类别："+rs.getString("kcType")+"\n"+"授课老师："+rs.getString("ls")+"\n"+"开课周数："+rs.getString("kcTime")+"\n"+"开课时间："+rs.getString("kcxq")+"；"+rs.getString("kcjs")+"\n"+"上课地点："+rs.getString("kcDD");
				
				
			}
			//System.out.println(KCXX);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return kc;
	}
	
	
	public static String getCJ(String toUserName,String kcName) {//查询一个课程成绩的方法
		String cj = "";
		String sql ="select * from t_openid left join t_student on t_openid.username = t_student.username left join t_bj on t_student.bjId = t_bj.id left join t_xk on t_student.id = t_xk.studnetId left join t_kc on t_xk.ckId = t_kc.id where openid = ? and  kcName=?";
        String openid =Message.getOpenid(toUserName);
		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(openid);
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,openid);
			ps.setString(2,kcName);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				cj = "学生成绩:\n"+"课程名："+rs.getString("kcName")+"\n"+"学分："+rs.getString("score")+"\n"+"学时："+rs.getString("xs")+"\n"+"属性："+rs.getString("kcsx")+"\n"+"课程类别："+rs.getString("kcType")+"\n"+"考试状态："+rs.getString("status")+"\n"+"成绩："+rs.getString("cj")+"\n"+"平均分："+rs.getString("kcAvg");
				System.out.println(cj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return cj;
	}
	
	public static String getCJ2(String toUserName) {//查询所有课程成绩的方法
		String cj = "";
		String CJ="";
		StringBuffer chengji=new StringBuffer();
		String sql ="select * from t_openid left join t_student on t_openid.username = t_student.username left join t_bj on t_student.bjId = t_bj.id left join t_xk on t_student.id = t_xk.studnetId left join t_kc on t_xk.ckId = t_kc.id where openid = ? ";
        String openid =Message.getOpenid(toUserName);
		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(openid);
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,openid);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				cj = "学生成绩:\n"+"课程名："+rs.getString("kcName")+"\n"+"学分："+rs.getString("score")+"\n"+"学时："+rs.getString("xs")+"\n"+"属性："+rs.getString("kcsx")+"\n"+"课程类别："+rs.getString("kcType")+"\n"+"考试状态："+rs.getString("status")+"\n"+"成绩："+rs.getString("cj")+"\n"+"平均分："+rs.getString("kcAvg");
				chengji.append(cj);
				chengji.append("\n\n");
				CJ=chengji.toString();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return CJ;
	}
	
	public static String getKSXX(String toUserName) {//查询所有考试信息
		String ksxx = "";
		String KSXX="";
		StringBuffer ks=new StringBuffer();
		String sql ="select * from t_openid left join t_student on t_openid.username = t_student.username left join t_ksxx on t_ksxx.studentId = t_student.id left join t_kc on t_kc.id=t_ksxx.kcId where openid =?";
        String openid =Message.getOpenid(toUserName);
		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(openid);
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,openid);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				ksxx = "学生考试信息:\n"+"课程："+rs.getString("kcName")+"\n"+"标题："+rs.getString("title")+"\n"+"考试内容:"+rs.getString("content")+"\n"+"考试地点:"+rs.getString("ksdd")+"\n"+"考试时间："+rs.getString("showDate");
				ks.append(ksxx);
				ks.append("\n\n");
				KSXX=ks.toString();
				
			}
			System.out.println(KSXX);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return KSXX;
	}
	
	public static String getKSXX2(String toUserName,String kcName) {//查询一门考试信息
		String ksxx = "";
		String sql ="select * from t_openid left join t_student on t_openid.username = t_student.username left join t_ksxx on t_ksxx.studentId = t_student.id left join t_kc on t_kc.id=t_ksxx.kcId where openid =? and kcName=?";
        String openid =Message.getOpenid(toUserName);
		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		System.out.println(openid);
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1,openid);
			ps.setString(2,kcName);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				ksxx = "学生考试信息:\n"+"课程："+rs.getString("kcName")+"\n"+"标题："+rs.getString("title")+"\n"+"考试内容:"+rs.getString("content")+"\n"+"考试地点:"+rs.getString("ksdd")+"\n"+"考试时间："+rs.getString("showDate");
			
				
			}
			System.out.println(ksxx);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return ksxx;
	}
	
	
	
	
	public static boolean checkCountExecute(String sql) {//判断结果集是否返回值
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		boolean flag = false;
		MySQLUtil mysqlUtil = new MySQLUtil();
		try {
			conn = mysqlUtil.getConn();
			st = conn.prepareStatement(sql);
			rs = st.executeQuery(sql);
			if (rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
			System.out.println(flag);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			mysqlUtil.releaseResources(conn, st, rs);
		}
		return flag;
		
	}
	
	public static String getKcName() {
		String kcName = "";
		String sql ="select kcName from t_kc";
		StringBuffer kc= new StringBuffer();
		String KC="";
		MySQLUtil mysqlUtil = new MySQLUtil();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = mysqlUtil.getConn();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				kcName=rs.getString("kcName");
				kc.append(kcName);
				KC=kc.toString();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			mysqlUtil.releaseResources(conn, ps, rs);
		}
		return KC;
	}
	public static void main(String args[])throws SQLException{
		MySQLUtil gg = new MySQLUtil();
		//gg. getGG1();
		//gg.getInfo("ogtM91ggDxIkuab70SILmrh8Xxfk");
		//gg.getCJ("ogtM91ggDxIkuab70SILmrh8Xxfk");
		
		//gg.checkCountExecute("select kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期一' and kcjs='一二节' and studnetId=2");
		//gg.getKcName();
		//gg.getCJ("ogtM91ggDxIkuab70SILmrh8Xxfk","计算机组成原理");
		gg.getKSXX2("ogtM91ggDxIkuab70SILmrh8Xxfk","java数据结构");
	}
}
