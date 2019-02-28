package com.sxl.weixinLoign;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;


/*
 * 该工具封装一些请求http的一些常用方法。
 */
public class MyHttpUtils {
	static String TAG = "MyHttpUtils";// 确定我们打印的数据属于哪个方法

	/*
	 * 我们封装一个http请求方法，该方法需要传递一个请求的url和一个json数据。返回值是一个json字符串。
	 */
	public static String getReturnJson(String url, String osrJson) {
		String reslut = "";// 返回的结果json
		try {
			// 创建一个url
			URL reqURL = new URL(url);
			// 拿取链接
			HttpsURLConnection httpsConn = (HttpsURLConnection) reqURL
					.openConnection();
			// 当需要参数传递时，才执行该方法
			if (osrJson != null) {
				httpsConn.setDoOutput(true);
				// 取得该连接的输出流，以读取响应内容
				OutputStreamWriter osr = new OutputStreamWriter(
						httpsConn.getOutputStream());
				osr.write(osrJson);// 写请求数据
				osr.close();
			}


			// 返回结果
			InputStreamReader isr = new InputStreamReader(
					httpsConn.getInputStream());
			char[] chars = new char[1024];
			int len;
			while ((len = isr.read(chars)) != -1) {
				reslut += new String(chars, 0, len);
			}
			isr.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reslut;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out
.println(URLEncoder.encode(
				"http://wx.yanghaoran.xyz/WeiXinJW/servlet/WeixinWebServlet", "UTF-8"));
	}
}
