package com.sxl.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import org.dom4j.DocumentException;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import com.sxl.WeiXinSQL.MySQLUtil;
import com.sxl.WeiXinSQL.RegString;
import com.sxl.util.*;


public class WXservlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		
		PrintWriter out = response.getWriter();
		if(CheckUtil.checkSignature(signature,timestamp,nonce)){
		//如果反回的值效验成功，则将得到的随机字符串原路返回	
		out.print(echostr);
		}
		}
		
		
		
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

			request.setCharacterEncoding("UTF-8");

			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();


			
			try {

			Map<String , String> map = Message.xmlToMap(request);

			String ToUserName = map.get("ToUserName");

			String FromUserName = map.get("FromUserName");

			String CreateTime = map.get("CreateTime");

			String MsgType = map.get("MsgType");

			String Content = map.get("Content");

			String MsgId  = map.get("MsgId ");

            
			String message = null;
			
			//模式匹配字符串
			String kcName=null;
			kcName=MySQLUtil.getKcName();
			
			
			
			if (MsgType.equals(Message.MESSAGE_TEXT)) {//判断是否为文本消息类型

			if (Content.equals("1")) {

			message = Message.initText(ToUserName, FromUserName,

			   "本教务系统基于SSM架构、微信开发者模式的一个原型系统，是本人的毕业设计，学生通过关注“yhr教务管理系统”微信公众号，回复关键字，点击进入系统，进行操作");

			} 
			else if(Content.equals("2")){

			message = Message.initText(ToUserName, FromUserName,

			   "软工1402 2014011236 杨浩然");

			} 
			
			else if(Content.equals("3")){

				message = Message.initNewsMessage(ToUserName, FromUserName);

				}
			else if(Content.equals("4")){//查询所有课程信息
				
				String content = MySQLUtil.getKc(FromUserName);
				message = Message.initText(ToUserName, FromUserName,content);

				}
            else if(Content.equals("5")){//查询所有课程成绩
				
				String content = MySQLUtil.getCJ2(FromUserName);
				message = Message.initText(ToUserName, FromUserName,content);

				}
            else if(Content.equals("6")){//查询所有考试信息
				
				String content = MySQLUtil.getKSXX(FromUserName);
				message = Message.initText(ToUserName, FromUserName,content);

				}
			else if(Content.equals("?") || Content.equals("？")){

			message = Message.initText(ToUserName, FromUserName,

			   Message.menuText());

			} 
			else {
				  String a=RegString.RegexInt(Content);//分割为数字
			      String b=RegString.RegexString(Content);//分割为字符串
			    if(a.equals("3")){//考试信息单独查询
						
				Pattern p=Pattern.compile(b);
			    Matcher m=p.matcher(kcName);
			    boolean result=m.find();
			    if(result == true){
							
							String content = MySQLUtil.getKSXX2(FromUserName,b);
							//System.out.println(content);
							message = Message.initText(ToUserName, FromUserName,

									  content);}
			            }
			      
			    else  if(a.equals("2")){//成绩单独查询
				
				Pattern p=Pattern.compile(b);
			    Matcher m=p.matcher(kcName);
				boolean result=m.find();
	            if(result == true){
					
					String content = MySQLUtil.getCJ(FromUserName,b);
					//System.out.println(content);
					message = Message.initText(ToUserName, FromUserName,

							  content);}
	            }
			    
			    else if(a.equals("1")){//课程单独查询
					
					Pattern p=Pattern.compile(b);
				    Matcher m=p.matcher(kcName);
					boolean result=m.find();
		            if(result == true){
						
						String content = MySQLUtil.getKc2(FromUserName,b);
						//System.out.println(content);
						message = Message.initText(ToUserName, FromUserName,

								  content);}
		            }
				    
			    
			    
	            else{

			message = Message.initText(ToUserName, FromUserName,

			   "发送内容未匹配功能或请输入正确内容");}

			}

			 

			}
			
			else if(MsgType.equals(Message.MESSAGE_EVENT)){//判断是否为事件类型

			//从集合中，或许是哪一种事件传入

			String eventType = map.get("Event");
			String eventKey = map.get("EventKey"); 
			
			
            //自定义菜单点击事件
			if(eventType.equals(Message.MESSAGE_CLICK)){
				if (eventKey.equals("11")) { 
					String content = MySQLUtil.getInfo(FromUserName);
					//System.out.println(content);
					message = Message.initText(ToUserName, FromUserName,

							  content);
                }
				if (eventKey.equals("12")) { 
					
					message = Message.initText(ToUserName, FromUserName,

							   "请回复您要进行的课程查询操作：\n\n（1）回复“4”可以查询已选所有课程\n\n（2）回复“1+课程名称”（例如：1java数据结构）可查看该课程信息");
					
				}
				if (eventKey.equals("13")) { 
					message = Message.initText(ToUserName, FromUserName,

							   "请回复您要进行的成绩查询操作：\n\n（1）回复“5”可以查询已选课程所有成绩\n\n（2）回复“2+课程名称”（例如：2java数据结构）可查看该课程成绩");
					
				}
			if (eventKey.equals("14")) { 
				message = Message.initText(ToUserName, FromUserName,

						  "请回复您要进行的考试信息查询操作：\n\n（1）回复“6”可以查询所有考试信息\n\n（2）回复“3+课程名称”（例如：3java数据结构）可查看该课程考试信息");
            }
			}
			if(eventType.equals(Message.MESSAGE_CLICK)){
				if (eventKey.equals("15")) {  
					
					message = Message.initNewsMessage2(ToUserName, FromUserName);
                }
			}
			if(eventType.equals(Message.MESSAGE_CLICK)){
				if (eventKey.equals("21")) {  
					message = Message.initText(ToUserName, FromUserName,

							  MySQLUtil.getGG1());
                }
			}
			if(eventType.equals(Message.MESSAGE_CLICK)){
				if (eventKey.equals("22")) {  
					message = Message.initText(ToUserName, FromUserName,

							  MySQLUtil.getGG2());
                }
			}
			if(eventType.equals(Message.MESSAGE_CLICK)){
				if (eventKey.equals("23")) {  
					message = Message.initText(ToUserName, FromUserName,

							  MySQLUtil.getGG3());
                }
			}
			if(eventType.equals(Message.MESSAGE_CLICK)){
				if (eventKey.equals("24")) {  
					message = Message.initText(ToUserName, FromUserName,

							  MySQLUtil.getGG4());
                }
			}
			
			if(eventType.equals(Message.MESSAGE_CLICK)){
				if (eventKey.equals("31")) {  
					message = Message.initText(ToUserName, FromUserName,

							 "本教务系统基于SSM架构、微信开发者模式的一个原型系统，是本人的毕业设计，学生通过关注“yhr教务管理系统”微信公众号，回复关键字，点击进入系统，进行操作");
                }
			}
			//关注事件

			if (eventType.equals(Message.MESSAGE_SUBSCRIBE)) {

			message = Message.initText(ToUserName, FromUserName,

			   Message.menuText());

			}

			}

			 

			System.out.println(message);

			out.print(message);

			 

			} catch (DocumentException e) {

			e.printStackTrace();

			}finally{

			out.close();

			}

     }
}