
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
*学生选课
* @author Administratorxxxx
* @date2018-04-17
*/
@Controller("xkController")
@RequestMapping(value = "/admin/xk")
public class XkController extends MyController {
	

/**
* 查询frame
*/
	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
		return "/admin/xk/frame";
	}
	
/**
* 查询列表
*/
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String flag,String kcName)throws Exception {
		

		String sql="select a.*,(select kcName from t_kc b where a.ckId=b.id) kcName ,(select score from t_kc b where a.ckId=b.id) score,(select xs from t_kc b where a.ckId=b.id) xs,(select kcsx from t_kc b where a.ckId=b.id)kcsx,(select kcType from t_kc b where a.ckId=b.id) kcType,(select studentName from t_student b where a.studnetId=b.id) studentName  from t_xk a where 1=1 ";
		if("2".equals(flag)){
			sql+=" and studnetId="+getStudent(request).get("id");
		}
		if("1".equals(flag)){
			sql+=" and teacherId="+getTeacher(request).get("id");
		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/xk/list";
	}
	
/**-
* 编辑保存（包含修改和添加）
*/
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id,String flag
		,Integer ckId,Integer studnetId,String cj,String status) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_xk set ckId=?,studnetId=?,cj=? where id=?";
			result = db.update(sql, new Object[]{ckId,studnetId,cj,id});
		}else{
			String sql="insert into t_xk(ckId,studnetId,cj,status) values(?,?,?,?)";
			result = db.update(sql, new Object[]{ckId,studnetId,cj,"待考试"});
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
		
		String sql="delete from t_xk where id=?";
		int result = db.update(sql, new Object[]{id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
		
	}
/**
* 更新字段信息
*/
	@RequestMapping(value = "/updateColumnstatus")
	public ResponseEntity<String> updateColumnstatus(Model model,HttpServletRequest request,Long id,String status,String aaa) throws Exception {
		
		String sql="update t_xk set status=?,cj=?   where id=?";
		int result = db.update(sql, new Object[]{status,aaa,id});//获取输入的成绩（cj）学生id，录入选课表
		if(result==1){                                           //输入成绩后 status变为已完成
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
			String sql="select * from t_xk where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}String sql="";

 sql="select * from t_ck";
model.addAttribute("ckList", db.queryForList(sql));

 sql="select * from t_studnet";
model.addAttribute("studnetList", db.queryForList(sql));

		return "/admin/xk/edit";
	}
	
	
	}
	
	
	
	

