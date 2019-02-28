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


@Controller("teacherLoginController")
@RequestMapping(value = "/teacherLogin")
public class TeacherLoginController extends MyController {
	

	@RequestMapping(value = "/login")
	public String index(Model model, HttpServletRequest request)throws Exception {
		return "/teacher/login";
	}
	
	@RequestMapping(value = "/save")
	public ResponseEntity<String> loginSave(Model model,HttpServletRequest request,String username,String password) throws Exception {
		String sql="select * from t_teacher where username=?";
		List<Map> list = db.queryForList(sql, new Object[]{username});
		String result="1";
		String PASSWORD=MD5Util.MD5(password);
				if(list!=null&&list.size()>0){
			Map map = list.get(0);
			if(StringHelper.get(map, "password").equals(PASSWORD)){
				request.getSession().setMaxInactiveInterval(60*60*24);
				request.getSession().setAttribute("teacherBean", map);
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
		,String username,String password,String teacherName,String age,String sex,String phone,String pic,String xh) throws Exception{
		int result = 0;
		int a = db.queryForInt("select count(1) from t_teacher where xh=? ",new Object[]{xh});
		if(a==0){
			return renderData(false,"操作成功",null);
		}
		int b = db.queryForInt("select count(1) from t_teacher where xh=? and username is not null ",new Object[]{xh});
		if(b>0){
			return renderData(false,"操作成功",null);
		}
		String sql="update t_teacher set username=?,password=? where xh=?";
		result = db.update(sql, new Object[]{username,password,xh});
		sql="select * from t_teacher where xh=? ";
		List<Map> list = db.queryForList(sql,new Object[]{xh});
		request.getSession().setMaxInactiveInterval(60*60*24);
		request.getSession().setAttribute("teacherBean", list.get(0));

			return renderData(true,"操作成功",null);
	}
		
	@RequestMapping(value = "/out")
	public String out(Model model, HttpServletRequest request)throws Exception {
		request.getSession().removeAttribute("teacherBean");
		return "redirect:/adminLogin/login.html";
	}
	
}
