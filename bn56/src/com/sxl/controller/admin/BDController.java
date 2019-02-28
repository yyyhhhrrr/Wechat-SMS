package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;
import com.sxl.util.MD5Util;
@Controller("BDController")//绑定账号控制器
@RequestMapping(value = "/BDLogin")
public class BDController extends MyController {
	@RequestMapping(value = "/BDSave")
	public ResponseEntity<String> mineSave(Model model,HttpServletRequest request,Long id
		,String openid,String username,String password) throws Exception{
		int result = 0;
		 
		int a = db.queryForInt("select count(1) from t_openid where openid=? ",new Object[]{openid});
		if(a==0){
			return renderData(false,"操作成功",null);
		}
		int b = db.queryForInt("select count(1) from t_openid where openid=? and username is not null ",new Object[]{openid});
		if(b>0){
			return renderData(false,"操作成功",null);
		}
		
     String PASSWORD =MD5Util.MD5(password);
		String sql="update t_openid set username=?,password=?  where openid=?";
		result = db.update(sql, new Object[]{username,PASSWORD,openid});
		sql="select * from t_openid where openid=? ";
		List<Map> list = db.queryForList(sql,new Object[]{openid});
		request.getSession().setMaxInactiveInterval(60*60*24);
		request.getSession().setAttribute("studentBean", list.get(0));

			return renderData(true,"操作成功",null);
	}
		
}
