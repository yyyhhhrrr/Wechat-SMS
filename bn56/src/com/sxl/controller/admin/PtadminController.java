
package com.sxl.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

@Controller("ptadminController")
@RequestMapping(value = "/ptadmin")
public class PtadminController extends MyController {
	

	@RequestMapping(value = "/index")
	public String frame(Model model, HttpServletRequest request)throws Exception {
		return "/ptadmin/index";
	}
	
	@RequestMapping(value = "/main")
	public String main(Model model, HttpServletRequest request)throws Exception {
		return "/ptadmin/main";
	}
	
	
	@RequestMapping(value = "/password")
	public String password(Model model, HttpServletRequest request)throws Exception {
		return "/ptadmin/password";
	}
	
	
	@RequestMapping(value = "/changePassword")
	public ResponseEntity<String> loginSave(Model model,HttpServletRequest request,String oldPassword,String newPassword) throws Exception {
		Map ptadmin = getPtadmin(request);
		if(oldPassword.equals(ptadmin.get("password").toString())){
			String sql="update t_ptadmin set password=? where id=?";
			db.update(sql, new Object[]{newPassword,ptadmin.get("id")});
			return renderData(true,"1",null);
		}else{
			return renderData(false,"1",null);
		}
	}
	@RequestMapping(value = "/mine")
	public String mine(Model model, HttpServletRequest request)throws Exception {
Map ptadmin =getPtadmin(request);Map map = db.queryForMap("select * from t_ptadmin where id=?",new Object[]{ptadmin.get("id")});model.addAttribute("map", map);		return "/ptadmin/mine";
	}
	
	

	@RequestMapping(value = "/mineSave")
	public ResponseEntity<String> mineSave(Model model,HttpServletRequest request,Long id
		,String username,String password,String ptadminName,String age,String sex,String phone) throws Exception{
		int result = 0;
			String sql="update t_ptadmin set ptadminName=?,age=?,sex=?,phone=? where id=?";
			result = db.update(sql, new Object[]{ptadminName,age,sex,phone,id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	}
