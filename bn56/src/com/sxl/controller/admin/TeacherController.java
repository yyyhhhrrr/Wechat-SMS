
package com.sxl.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;
import com.sxl.util.MD5Util;

@Controller("teacherController")
@RequestMapping(value = "/teacher")
public class TeacherController extends MyController {
	

	@RequestMapping(value = "/index")
	public String frame(Model model, HttpServletRequest request)throws Exception {
		return "/teacher/index";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model, HttpServletRequest request)throws Exception {
		return "/teacher/main";
	}
	
	
	@RequestMapping(value = "/password")
	public String password(Model model, HttpServletRequest request)throws Exception {
		return "/teacher/password";
	}
	
	
	@RequestMapping(value = "/changePassword")
	public ResponseEntity<String> loginSave(Model model,HttpServletRequest request,String oldPassword,String newPassword) throws Exception {
		Map teacher = getTeacher(request);
		String NEWPASSWORD=MD5Util.MD5(newPassword);
		String OLDPASSWORD=MD5Util.MD5(oldPassword);
		if(OLDPASSWORD.equals(teacher.get("password").toString())){
			String sql="update t_teacher set password=? where id=?";
			db.update(sql, new Object[]{NEWPASSWORD,teacher.get("id")});
			return renderData(true,"1",null);
		}else{
			return renderData(false,"1",null);
		}
	}
	@RequestMapping(value = "/mine")
	public String mine(Model model, HttpServletRequest request)throws Exception {
Map teacher =getTeacher(request);Map map = db.queryForMap("select * from t_teacher where id=?",new Object[]{teacher.get("id")});model.addAttribute("map", map);		return "/teacher/mine";
	}
	
	

	@RequestMapping(value = "/mineSave")
	public ResponseEntity<String> mineSave(Model model,HttpServletRequest request,Long id
		,String username,String password,String teacherName,String age,String sex,String phone,String pic,String xh) throws Exception{
		int result = 0;
			String sql="update t_teacher set teacherName=?,age=?,sex=?,phone=?,pic=? where id=?";
			result = db.update(sql, new Object[]{teacherName,age,sex,phone,pic,id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	}
