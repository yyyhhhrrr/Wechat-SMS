
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
*考试地点
* @author Administratorxxxx
* @date2018-04-17
*/
@Controller("ksxxController")
@RequestMapping(value = "/admin/ksxx")
public class KsxxController extends MyController {
	

/**
* 查询frame
*/
	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
		return "/admin/ksxx/frame";
	}
	
/**
* 查询列表
*/
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String flag,String title)throws Exception {
		
		String sql="select a.*,(select studentName from t_student b where a.studentId=b.id) studentName,(select kcName from t_kc b where a.kcId=b.id) kcName   from t_ksxx a where 1=1 ";
		if(!"1".equals(flag)){
			sql+=" and studentId="+getStudent(request).get("id");
		}

	if(title!=null&&!"".equals(title)){
			sql+=" and title like '%"+title+"%'";
		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/ksxx/list";
	}
	
/**
* 编辑保存（包含修改和添加）
*/
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id,String flag
			,Long studentId,Long kcId,String title,String pic,String content,String showDate,String ksdd) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_ksxx set studentId=?,kcId=?,title=?,pic=?,content=?,showDate=?,ksdd=? where id=?";
			result = db.update(sql, new Object[]{studentId,kcId,title,pic,content,showDate,ksdd,id});
		}else{
			String sql="insert into t_ksxx(studentId,kcId,title,pic,content,showDate,ksdd) values(?,?,?,?,?,?,?)";
			result = db.update(sql, new Object[]{studentId,kcId,title,pic,content,showDate,ksdd});
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
		
		String sql="delete from t_ksxx where id=?";
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
			String sql="select * from t_ksxx where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}String sql1="";
		String sql2="";

 sql1="select * from t_student";
 sql2="select * from t_kc";
model.addAttribute("studentList", db.queryForList(sql1));
model.addAttribute("kcList", db.queryForList(sql2));
		return "/admin/ksxx/edit";
	}
}
