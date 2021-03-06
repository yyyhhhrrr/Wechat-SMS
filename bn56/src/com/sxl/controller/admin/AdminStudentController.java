
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
*学生
* @author Administratorxxxx
* @date2018-04-17
*/
@Controller("adminStudentController")
@RequestMapping(value = "/admin/student")
public class AdminStudentController extends MyController {
	

/**
* 查询frame
*/
	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
		return "/admin/student/frame";
	}
	
/**
* 查询列表
*/
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String flag,String username,String studentName,String bjName)throws Exception {
		

		String sql="select a.*,(select bjName from t_bj b where a.bjId=b.id) bjName  from t_student a where 1=1 ";


		
		
	if(username!=null&&!"".equals(username)){
			sql+=" and username like '%"+username+"%'";
		}
	if(studentName!=null&&!"".equals(studentName)){
			sql+=" and studentName like '%"+studentName+"%'";
		}
	if(bjName!=null&&!"".equals(bjName)){
		sql+=" and bjName like '%"+bjName+"%'";
	}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/student/list";
	}
	
	/*微信用户信息列表
	 * 
	 */
	
	
	
	@RequestMapping(value = "/wxlist")
	public String frame(Model model, HttpServletRequest request)throws Exception {
		String sql="select a.* ,(select studentName from t_student b where a.username=b.username) studentName,(select sex from t_student b where a.username=b.username) sex from t_openid a where 1=1 ";
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("wxlist", list);
		
		return "/admin/student/wxlist";
	}
/**
* 编辑保存（包含修改和添加）
*/
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id,String flag
		,String username,String password,String studentName,Integer bjId,String age,String sex,String phone,String qq,String email,String pic,String xh) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_student set studentName=?,bjId=?,age=?,sex=?,phone=?,qq=?,email=?,pic=?,xh=? where id=?";
			result = db.update(sql, new Object[]{studentName,bjId,age,sex,phone,qq,email,pic,xh,id});
		}else{
			String sql="insert into t_student(username,password,studentName,bjId,age,sex,phone,qq,email,pic,xh) values(?,?,?,?,?,?,?,?,?,?,?)";
			result = db.update(sql, new Object[]{username,password,studentName,bjId,age,sex,phone,qq,email,pic,xh});
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
		
		String sql="delete from t_student where id=?";
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
			String sql="select * from t_student where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}String sql="";

 sql="select * from t_bj";
model.addAttribute("bjList", db.queryForList(sql));

		return "/admin/student/edit";
	}
}
