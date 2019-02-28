package com.sxl.entity;

public class BaseMessage {
	
		public String ToUserName;
		public String FromUserName;
		public String CreateTime;
		public String MsgType;
		
		public String getToUserName() {

			return ToUserName;

			}

			public void setToUserName(String toUserName) {

			ToUserName = toUserName;

			}

			public String getFromUserName() {

			return FromUserName;

			}

			public void setFromUserName(String fromUserName) {

			FromUserName = fromUserName;

			}

			public String getCreateTime() {

			return CreateTime;

			}

			public void setCreateTime(String createtime) {

			CreateTime = createtime;

			}

			public String getMsgType() {

			return MsgType;

			}

			public void setMsgType(String msgType) {

			MsgType = msgType;

			}

}
