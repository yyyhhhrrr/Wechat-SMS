package com.sxl.util;

import java.io.IOException;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;

import org.dom4j.DocumentException;

import org.dom4j.Element;

import org.dom4j.io.SAXReader;

import com.sxl.entity.News;
import com.sxl.entity.NewsMessage;
import com.sxl.entity.TextMessage;


import com.thoughtworks.xstream.XStream;

public class Message {

public static final String MESSAGE_TEXT = "text";//文本消息

public static final String MESSAGE_IMAGE = "image";//图片消息

public static final String MESSAGE_VOICE = "voice";//声音消息

public static final String MESSAGE_VIDEO = "video";//视频消息

public static final String MESSAGE_SHORTVIDEO = "shortvideo";//短视频消息

public static final String MESSAGE_LINK = "link";//链接消息

public static final String MESSAGE_LOCATION = "location";//地理位置消息

public static final String MESSAGE_EVENT = "event";//事件消息

public static final String MESSAGE_SUBSCRIBE = "subscribe";//被关注消息

public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";//取消关注消息

public static final String MESSAGE_CLICK = "CLICK";//点击菜单消息

public static final String MESSAGE_VIEW = "VIEW";//菜单链接消息

public static final String MESSAGE_SCAN = "SCAN";//扫一扫类型

public static final String MESSAGE_NEWS = "news";//新闻类型

/**

 * 将XML转为MAP集合

 * @param request

 * @return

 * @throws IOException

 * @throws DocumentException

 */

public static Map<String , String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{

Map<String , String> map = new HashMap<String, String>();

SAXReader reader = new SAXReader();

//从request对象中获取输入流

InputStream ins = request.getInputStream();

//使用reader对象读取输入流,解析为XML文档

Document doc = reader.read(ins);

//获取XML根元素

Element root = doc.getRootElement();

//将根元素的所有节点，放入列表中

List<Element> list = root.elements();

//遍历list对象，并保存到集合中

for (Element element : list) {

map.put(element.getName(), element.getText());

}

ins.close();

return map;

}

/**

 * 将文本消息对象转成XML

 * @param text

 * @return

 */

public static String textMessageToXml(TextMessage textMessage){

XStream xstream = new XStream();

//将xml的根节点替换成<xml>  默认为TextMessage的包名

xstream.alias("xml", textMessage.getClass());

return xstream.toXML(textMessage);

}

/**

 * 拼接关注主菜单

 */

public static String menuText(){

StringBuffer sb = new StringBuffer();

sb.append("欢迎关注教务管理系统，请选择您要的操作回复:\n\n");

sb.append("1、本教务系统介绍。\n\n");

sb.append("2、关于作者。\n\n");

sb.append("3、进入教务系统。\n\n");

sb.append("4、查询所有课程信息。\n\n");

sb.append("5、查询所有课程成绩。\n\n");

sb.append("6、查询所有课程考试信息。\n\n");

sb.append("回复？调出主菜单。\n\n");

return sb.toString();

}

/**

 * 初始化回复消息

 */

public static String initText(String toUSerName,String fromUserName,String content){

TextMessage text = new TextMessage();

text.setFromUserName(toUSerName);//将消息发送的目标作为消息的发送者

text.setToUserName(fromUserName);//将消息的发送者作为消息的发送目标

text.setMsgType(MESSAGE_TEXT);//设置消息类型为文本消息

text.setCreateTime(new Date().getTime()+"");//获取当前时间戳

text.setContent(content);//输入文本内容

return Message.textMessageToXml(text);//将消息封装为xml格式数据

}
public static String getOpenid(String toUserName){
	return toUserName;
}

/**
 * 将图文消息对象转成XML
 * @param 
 * @return
 */
public static String newsMessageToXml(NewsMessage newsMessage){
    XStream xstream = new XStream();
    //将xml的根节点替换成<xml>  默认为NewsMessage的包名
    xstream.alias("xml", newsMessage.getClass());
    //同理，将每条图文消息News类的报名，替换为<item>标签
    xstream.alias("item", new News().getClass());
    return xstream.toXML(newsMessage);
}


/**
 * 初始化图文消息
 */
public static String initNewsMessage(String toUSerName,String fromUserName){
    List<News> newsList = new ArrayList<News>();
    NewsMessage newsMessage = new NewsMessage();
    //组建一条图文↓ ↓ ↓
    News newsItem = new News();
    newsItem.setTitle("欢迎来到教务管理系统");
    newsItem.setDescription("点击进入微信教务管理系统");
    newsItem.setPicUrl("http://pic.baike.soso.com/p/20120715/bki-20120715143127-270492826.jpg");
    newsItem.setUrl("http://yhr.65zkf7.cn/WeiXinJW/adminLogin/login.html");
    newsList.add(newsItem);
    
    //组装图文消息相关信息
    newsMessage.setToUserName(fromUserName);
    newsMessage.setFromUserName(toUSerName);
    newsMessage.setCreateTime(new Date().getTime()+"");
    newsMessage.setMsgType(MESSAGE_NEWS);
    newsMessage.setArticle(newsList);
    newsMessage.setArticleCount(newsList.size());
    
    //调用newsMessageToXml将图文消息转化为XML结构并返回
    return Message.newsMessageToXml(newsMessage);
}


/**
 * 初始化图文消息
 */
public static String initNewsMessage2(String toUSerName,String fromUserName){
    List<News> newsList = new ArrayList<News>();
    NewsMessage newsMessage = new NewsMessage();
    //组建一条图文↓ ↓ ↓
    News newsItem = new News();
    newsItem.setTitle("个人用户绑定");
    newsItem.setDescription("点击此处进行绑定学号");
    newsItem.setPicUrl("http://photocdn.sohu.com/20120918/Img353466898.jpg");
    newsItem.setUrl("http://yhr.65zkf7.cn/WeiXinJW/servlet/GuideServlet");
    newsList.add(newsItem);
    
    //组装图文消息相关信息
    newsMessage.setToUserName(fromUserName);
    newsMessage.setFromUserName(toUSerName);
    newsMessage.setCreateTime(new Date().getTime()+"");
    newsMessage.setMsgType(MESSAGE_NEWS);
    newsMessage.setArticle(newsList);
    newsMessage.setArticleCount(newsList.size());
    
    //调用newsMessageToXml将图文消息转化为XML结构并返回
    return Message.newsMessageToXml(newsMessage);
}




}

