package com.sxl.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxl.weixinLoign.GlobalParams;




@WebServlet("/GuideServlet")
public class GuideServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
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
		//String redirect_uri = "http://yhr.65zkf7.cn/WeiXinJW/servlet/WeixinWebServlet";// 目标访问地址
		String redirect_uri = URLEncoder.encode(
				"http://yhr.65zkf7.cn/WeiXinJW/servlet/WeixinWebServlet", "UTF-8");// 授权后重定向的回调链接地址，请使用urlencode对链接进行处理（文档要求）
		// 按照文档要求拼接访问地址
		String url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid="
				+ GlobalParams.APPID
				+ "&redirect_uri="
				+ redirect_uri
				+ "&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
		resp.sendRedirect(url);// 跳转到要访问的地址

	}
}
