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
import com.sxl.util.StringHelper;


@Controller("studentLoginController")
@RequestMapping(value = "/studentLogin")
public class StudentLoginController extends MyController {
	

	@RequestMapping(value = "/login")
	public String index(Model model, HttpServletRequest request)throws Exception {
		return "/student/login";
	}
	
	@RequestMapping(value = "/save")
	public ResponseEntity<String> loginSave(Model model,HttpServletRequest request,String username,String password) throws Exception {
		String sql="select * from t_student where username=?";
		List<Map> list = db.queryForList(sql, new Object[]{username});
		String result="1";
		String PASSWORD=MD5Util.MD5(password);//将输入的密码进行MD5加密
		if(list!=null&&list.size()>0){
			Map map = list.get(0);//构造map对象里查找用户名对应的面
			if(StringHelper.get(map, "password").equals(PASSWORD)){
				request.getSession().setMaxInactiveInterval(60*60*24);
				request.getSession().setAttribute("studentBean", map);
				result="1";
			}else{
				result="0";
			}
		}else{
			result="0";
		}
		return renderData(true,result,null);
	}

	@RequestMapping(value = "/registerSave")
	public ResponseEntity<String> mineSave(Model model,HttpServletRequest request,Long id
		,String username,String password,String studentName,Integer bjId,String age,String sex,String phone,String qq,String email,String pic,String xh) throws Exception{
		int result = 0;//设置返回result的缺省值
		 
		int a = db.queryForInt("select count(1) from t_student where xh=? ",new Object[]{xh});//判断学号是否先存在
		if(a==0){
			return renderData(false,"操作成功",null);
		}
		int b = db.queryForInt("select count(1) from t_student where xh=? and username is not null ",new Object[]{xh});
		if(b>0){
			return renderData(false,"操作成功",null);
		}
		
        String PASSWORD=MD5Util.MD5(password);//对注册的密码存入数据库进行MD5加密
		
		String sql="update t_student set username=?,password=? where xh=?";
		result = db.update(sql, new Object[]{username,PASSWORD,xh});
		sql="select * from t_student where xh=? ";
		List<Map> list = db.queryForList(sql,new Object[]{xh});
		request.getSession().setMaxInactiveInterval(60*60*24);
		request.getSession().setAttribute("studentBean", list.get(0));//将student的信息list对象放入request请求session中
		                                                           //存入session中，用于在页面显示当前使用系统的用户

			return renderData(true,"操作成功",null);
	}
		
	@RequestMapping(value = "/out")
	public String out(Model model, HttpServletRequest request)throws Exception {
		request.getSession().removeAttribute("studentBean");
		return "redirect:/adminLogin/login.html";
	}
	
}
