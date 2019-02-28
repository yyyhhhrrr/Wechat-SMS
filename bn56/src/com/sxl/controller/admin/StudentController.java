
package com.sxl.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;
import com.sxl.util.MD5Util;

@Controller("studentController")
@RequestMapping(value = "/student")
public class StudentController extends MyController {
	

	@RequestMapping(value = "/index")
	public String frame(Model model, HttpServletRequest request)throws Exception {
		return "/student/index";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model, HttpServletRequest request)throws Exception {
		return "/student/main";
	}
	
	
	@RequestMapping(value = "/password")
	public String password(Model model, HttpServletRequest request)throws Exception {
		return "/student/password";
	}
	
	
	@RequestMapping(value = "/changePassword")
	public ResponseEntity<String> loginSave(Model model,HttpServletRequest request,String oldPassword,String newPassword) throws Exception {
		Map student = getStudent(request);
		String NEWPASSWORD=MD5Util.MD5(newPassword);//对新旧密码进行MD5加密
		String OLDPASSWORD=MD5Util.MD5(oldPassword);
		if(OLDPASSWORD.equals(student.get("password").toString())){
			String sql="update t_student set password=? where id=?";
			db.update(sql, new Object[]{NEWPASSWORD,student.get("id")});//获取从当前网页studentmap中的学生id替换到sql语句中执行
			return renderData(true,"1",null);
		}else{
			return renderData(false,"1",null);
		}
	}
	@RequestMapping(value = "/mine")
	public String mine(Model model, HttpServletRequest request)throws Exception {
Map student =getStudent(request);Map map = db.queryForMap("select * from t_student where id=?",new Object[]{student.get("id")});model.addAttribute("map", map);		
String sql="";
sql="select * from t_bj";
model.addAttribute("bjList", db.queryForList(sql));
return "/student/mine";
	}
	
	

	@RequestMapping(value = "/mineSave")
	public ResponseEntity<String> mineSave(Model model,HttpServletRequest request,Long id
		,String username,String password,String studentName,String xueyuan,String zhuanye,Integer bjId,String age,String sex,String phone,String qq,String email,String type,String pic,String xh,String zhuzhi) throws Exception{
		int result = 0;
			String sql="update t_student set studentName=?,xueyuan=?,zhuanye=?,bjId=?,zhuzhi=?,type=?,age=?,sex=?,phone=?,qq=?,email=?,pic=? where id=?";
			result = db.update(sql, new Object[]{studentName,xueyuan,zhuanye,bjId,zhuzhi,type,age,sex,phone,qq,email,pic,id});
			
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	}
