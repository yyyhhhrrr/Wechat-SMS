package com.sxl.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Regex1{
	public static void main(String args[]) {
	String str="java数据结构线性代数（1）大学体育（1）表演的艺术大学英语（1）中国近代史it工程师培养编译原理计算机组成原理";

    String regEx="java数据结构"; //表示a或f 
	Pattern p=Pattern.compile(regEx);
    Matcher m=p.matcher(str);
	boolean result=m.find();
	System.out.println(result);
	}
	}
