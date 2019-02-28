package com.sxl.WeiXinSQL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegString {//分割字符串与数字
public static String RegexInt(String s){

String regex = "\\d*";
String a="";

Pattern p = Pattern.compile(regex);

Matcher m = p.matcher(s);

while (m.find()) {
if (!"".equals(m.group()))
	a=m.group();
}
System.out.println(a);//分割出的数字

return a;
}
public static String RegexString(String s){
	
	String b=s.replaceAll("[0-9]", "");
	System.out.println(b);
return b;
}
public static void main(String args[]){
	RegexInt("2java数据结构");
	RegexString("2java数据结构");
}
}