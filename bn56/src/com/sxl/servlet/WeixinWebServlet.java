
package com.sxl.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.google.gson.Gson;

import com.sxl.weixinLoign.AutoWebParams;
import com.sxl.weixinLoign.CommonUtil;
import com.sxl.weixinLoign.GlobalParams;
import com.sxl.weixinLoign.MyHttpUtils;

import com.sxl.weixinLoign.SNSUserInfo;




@WebServlet("/WeixinWebServlet")
public class WeixinWebServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException,IOException {
		// 设置编码
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("utf-8");
		PrintWriter writer = resp.getWriter();
		/**
		 * 第一步：用户同意授权，获取code:https://open.weixin.qq.com/connect/oauth2/authorize
		 * ?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=SCOPE
		 * &state=STATE#wechat_redirect
		 */
		// 已经在GuideServlet进行了处理

		/**
		 * 第二步：通过code换取网页授权access_token
		 */
		String code = req.getParameter("code");// 获取返回码
		// 同意授权
		if (code != null) {
			// 拼接请求地址
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token?"
					+ "appid=" + GlobalParams.APPID + "&secret="
					+ GlobalParams.SECERT
					+ "&code=" + code
					+ "&grant_type=authorization_code";
			String json = MyHttpUtils.getReturnJson(url, null);// 拿去返回值
			AutoWebParams autoWebParams = new AutoWebParams();
			Gson gson = new Gson();
			autoWebParams = gson.fromJson(json, new AutoWebParams().getClass());

			/**
			 * 第三步：刷新access_token（如果需要）
			 */
			String url2 = "https://api.weixin.qq.com/sns/oauth2/refresh_token?"
					+ "appid=" + GlobalParams.APPID
					+ "&grant_type=refresh_token&refresh_token="
					+ autoWebParams.getRefresh_token();
			String json2 = MyHttpUtils.getReturnJson(url2, null);// 拿去返回值
			AutoWebParams autoWebParams2 = new AutoWebParams();
			Gson gson2 = new Gson();
			autoWebParams2 = gson2
					.fromJson(json2, new AutoWebParams().getClass());

			/**
			 * 第四步：拉取用户信息(需scope为 snsapi_userinfo)  获取openid
			 */
			 
			String url3 = "https://api.weixin.qq.com/sns/userinfo?access_token="
					+ autoWebParams2.getAccess_token()
					+ "&openid="
					+ autoWebParams2.getOpenid()+"&lang=zh_CN";
;
		    JSONObject jsonObject = CommonUtil.httpsRequest(url3, "GET", null);
		  SNSUserInfo snsUserInfo = null;
		    if (null != jsonObject) {  
                try {  
                    snsUserInfo = new SNSUserInfo();  
                    // 用户的标识  
                    snsUserInfo.setOpenId(jsonObject.getString("openid"));  
                    // 昵称  
                    snsUserInfo.setNickname(jsonObject.getString("nickname"));  
                    // 性别（1是男性，2是女性，0是未知）  
                    snsUserInfo.setSex(jsonObject.getInt("sex"));  
                    // 用户所在国家  
                    snsUserInfo.setCountry(jsonObject.getString("country"));  
                    // 用户所在省份  
                    snsUserInfo.setProvince(jsonObject.getString("province"));  
                    // 用户所在城市  
                    snsUserInfo.setCity(jsonObject.getString("city"));  
                    // 用户头像  
                    snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));  
                    // 用户特权信息  
                    snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));  
                } catch (Exception e) {  
                    snsUserInfo = null;  
                    int errorCode = jsonObject.getInt("errcode");  
                    String errorMsg = jsonObject.getString("errmsg");  
                    System.err.printf("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);  
                }  
            }  
		    String urll = "jdbc:mysql://localhost:3306/bn56";
			String username = "root";
			String password = "960314";
			String openid=snsUserInfo.getOpenId();
			String wxname=snsUserInfo.getNickname();
			Integer sex=snsUserInfo.getSex();
			String country=snsUserInfo.getCountry();
			String province=snsUserInfo.getProvince();
			String city=snsUserInfo.getCity();
			String headimgurl=snsUserInfo.getHeadImgUrl();
			System.out.println(openid);
			Connection conn =null;
			PreparedStatement pre;
		    try {  
		    	Class.forName("com.mysql.jdbc.Driver");  
		    	conn =  DriverManager.getConnection(urll, username, password);
	            pre =  conn.prepareStatement("insert into t_openid(openid,wxname,sex,country,province,city,headimgurl) values(?,?,?,?,?,?,?)");  
	              
	           
	              pre.setString(1,openid); 
	              pre.setString(2,wxname);
	              pre.setInt(3,sex);
	              pre.setString(4,country);
	              pre.setString(5,province);
	              pre.setString(6,city);
	              pre.setString(7,headimgurl);
	              
	              int i=pre.executeUpdate();
	              if(i==1){
	                System.out.print("添加成功");	              }
	              else{
	                System.out.print("添加不成功");	              }
	               

	            //也可以使用setObject方法，避免判断参数的麻烦  
	             
	       
	            pre.close();  
	            conn.close();  
	              
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	          
		    
		    
		    System.out.println("OpenID:"+snsUserInfo.getOpenId());
		    System.out.println("昵称:"+snsUserInfo.getNickname());
		    System.out.println("性别:"+snsUserInfo.getSex());
		    System.out.println("国家:"+snsUserInfo.getCountry());
		    System.out.println("省份:"+snsUserInfo.getProvince());
		    System.out.println("城市:"+snsUserInfo.getCity());
		    System.out.println("头像地址:"+snsUserInfo. getHeadImgUrl());
		    
		    
		    //System.out.println("openid:"+jsonObject.getString("openid"));
		  // System.out.println("昵称:"+jsonObject.getString("nickname"));
		    //String json3 = MyHttpUtils.getReturnJson(url3, null);// 拿去返回值
			//UserInfo userInfo = new UserInfo();
		  // System.out.println(new String(json3.getBytes(),"utf-8"));
		
	
			// -----------------------操作结束-------------------------

			// 显示用户信息
		    req.setAttribute("userInfo", snsUserInfo);
			req.getRequestDispatcher("/WXLogin.jsp").forward(req, resp);
		   // resp.sendRedirect("http://yhr.65zkf7.cn/WeiXinJW/WXLogin.jsp");
		} else {
			writer.print("用户禁止授权，这里处理禁止之后的操作");
			writer.close();
		}
	}

}
