
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

/**
*教务人员
* @author Administratorxxxx
* @date2018-04-17
*/
@Controller("adminPtadminController")
@RequestMapping(value = "/admin/ptadmin")
public class AdminPtadminController extends MyController {
	

/**
* 查询frame
*/
	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
		return "/admin/ptadmin/frame";
	}
	
/**
* 查询列表
*/
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String flag,String username,String ptadminName)throws Exception {
		//select date_format(insertDate, '%Y-%m-%d %H:%i:%s')
		//CONVERT(varchar, insertDate, 120 )
		//to_char(insertDate,'yyyy-mm-dd,hh24:mi:ss') 

		String sql="select a.* from t_ptadmin a where 1=1 ";


	if(username!=null&&!"".equals(username)){
			sql+=" and username like '%"+username+"%'";
		}
	if(ptadminName!=null&&!"".equals(ptadminName)){
			sql+=" and ptadminName like '%"+ptadminName+"%'";
		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/ptadmin/list";
	}
	
/**
* 编辑保存（包含修改和添加）
*/
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id,String flag
		,String username,String password,String ptadminName,String age,String sex,String phone) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_ptadmin set username=?,password=?,ptadminName=?,age=?,sex=?,phone=? where id=?";
			result = db.update(sql, new Object[]{username,password,ptadminName,age,sex,phone,id});
		}else{
			String sql="insert into t_ptadmin(username,password,ptadminName,age,sex,phone) values(?,?,?,?,?,?)";
			result = db.update(sql, new Object[]{username,password,ptadminName,age,sex,phone});
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
/**
* 删除信息
*/
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model,HttpServletRequest request,Long id,String flag) throws Exception {
		
		String sql="delete from t_ptadmin where id=?";
		int result = db.update(sql, new Object[]{id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
		
	}
	
/**
* 跳转到编辑页面
*/
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request,Long id,String flag)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_ptadmin where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}String sql="";

		return "/admin/ptadmin/edit";
	}
}
