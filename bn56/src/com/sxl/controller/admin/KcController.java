
package com.sxl.controller.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.WeiXinSQL.MySQLUtil;
import com.sxl.controller.MyController;

/**
*课程
* @author Administratorxxxx
* @date2018-04-17
*/
@Controller("kcController")
@RequestMapping(value = "/admin/kc")
public class KcController extends MyController {
	

/**
* 查询frame
*/
	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
		return "/admin/kc/frame";
	}
	@RequestMapping(value = "/Tj")
	public String frame(Model model, HttpServletRequest request)throws Exception {
		String sql="select a.* from t_kc a where 1=1 ";
	   // String sql2="select * from t_xk left join t_teacher on t_xk.teacherId=t_teacher.id left join t_kc on t_xk.ckId=t_kc.id where teacherId=1";
	    //sql2+=" where teacherId="+getTeacher(request).get("id");
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		
		return "/admin/kc/Tj";
	}
	
	@RequestMapping(value = "/Kb")//课表concroller
	public String Kb(Model model,HttpServletRequest request)throws Exception{
		/*判断周一 12节
		 * 
		 */
		String sql1="select kcName,kcDD,ls  from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期一' and kcjs='一二节'";
		sql1+="and studnetId ="+getStudent(request).get("id");
		if (MySQLUtil.checkCountExecute(sql1)!=false){
		List<Map> list1 = db.queryForList(sql1);
		Map map1 = list1.get(0);
		request.getSession().setAttribute("Kb1", map1);
		}
		else{
			Map map1 = new HashMap();
			map1.put("kcName","");
			request.getSession().setAttribute("Kb1", map1);
		}
		
		
		/*
		 * 判断周二12节
		 */
		String sql2="select kcName ,kcDD,ls from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期二' and kcjs='一二节'";
		sql2+="and studnetId ="+getStudent(request).get("id");
		if (MySQLUtil.checkCountExecute(sql2)!=false){
		List<Map> list2 = db.queryForList(sql2);
		Map map2 = list2.get(0);
		request.getSession().setAttribute("Kb2", map2);
		}
		else{
			Map map2 = new HashMap();
			map2.put("kcName","");
			request.getSession().setAttribute("Kb2", map2);
		}
		
		/*
		 * 判断周三12节
		 */
				String sql3="select kcName ,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期三' and kcjs='一二节'";
				sql3+="and studnetId ="+getStudent(request).get("id");
				if (MySQLUtil.checkCountExecute(sql3)!=false){
				List<Map> list3 = db.queryForList(sql3);
				Map map3 = list3.get(0);
				request.getSession().setAttribute("Kb3", map3);
				}
				else{
					Map map3 = new HashMap();
					map3.put("kcName","");
					request.getSession().setAttribute("Kb3", map3);
				}
				
		/*
		* 判断周四12节
		*/
			String sql4="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期四' and kcjs='一二节'";
		    sql4+="and studnetId ="+getStudent(request).get("id");
			if (MySQLUtil.checkCountExecute(sql4)!=false){
			List<Map> list4 = db.queryForList(sql4);
			Map map4 = list4.get(0);
			request.getSession().setAttribute("Kb4", map4);
			}
			else{
			Map map4 = new HashMap();
			map4.put("kcName","");
			request.getSession().setAttribute("Kb4", map4);
			}
			
			
			/*
			* 判断周五12节
			*/
				String sql5="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期五' and kcjs='一二节'";
			    sql5+="and studnetId ="+getStudent(request).get("id");
				if (MySQLUtil.checkCountExecute(sql5)!=false){
				List<Map> list5 = db.queryForList(sql5);
				Map map5 = list5.get(0);
				request.getSession().setAttribute("Kb5", map5);
				}
				else{
				Map map5 = new HashMap();
				map5.put("kcName","");
				request.getSession().setAttribute("Kb5", map5);
				}
				/*判断周一 34节
				 * 
				 */
				String sql6="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期一' and kcjs='三四节'";
				sql6+="and studnetId ="+getStudent(request).get("id");
				if (MySQLUtil.checkCountExecute(sql6)!=false){
				List<Map> list6 = db.queryForList(sql6);
				Map map6 = list6.get(0);
				request.getSession().setAttribute("Kb6", map6);
				}
				else{
					Map map6 = new HashMap();
					map6.put("kcName","");
					request.getSession().setAttribute("Kb6", map6);
				}
				
				
				/*
				 * 判断周二34节
				 */
				String sql7="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期二' and kcjs='三四节'";
				sql7+="and studnetId ="+getStudent(request).get("id");
				if (MySQLUtil.checkCountExecute(sql7)!=false){
				List<Map> list7 = db.queryForList(sql7);
				Map map7 = list7.get(0);
				request.getSession().setAttribute("Kb7", map7);
				}
				else{
					Map map7 = new HashMap();
					map7.put("kcName","");
					request.getSession().setAttribute("Kb7", map7);
				}
				
				/*
				 * 判断周三34节
				 */
						String sql8="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期三' and kcjs='三四节'";
						sql8+="and studnetId ="+getStudent(request).get("id");
						if (MySQLUtil.checkCountExecute(sql8)!=false){
						List<Map> list8 = db.queryForList(sql8);
						Map map8 = list8.get(0);
						request.getSession().setAttribute("Kb8", map8);
						}
						else{
							Map map8 = new HashMap();
							map8.put("kcName","");
							request.getSession().setAttribute("Kb8", map8);
						}
						
				/*
				* 判断周四34节
				*/
					String sql9="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期四' and kcjs='三四节'";
				    sql9+="and studnetId ="+getStudent(request).get("id");
					if (MySQLUtil.checkCountExecute(sql9)!=false){
					List<Map> list9 = db.queryForList(sql9);
					Map map9 = list9.get(0);
					request.getSession().setAttribute("Kb9", map9);
					}
					else{
					Map map9 = new HashMap();
					map9.put("kcName","");
					request.getSession().setAttribute("Kb9", map9);
					}
					
					
					/*
					* 判断周五34节
					*/
						String sql10="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期五' and kcjs='三四节'";
					    sql10+="and studnetId ="+getStudent(request).get("id");
						if (MySQLUtil.checkCountExecute(sql10)!=false){
						List<Map> list10 = db.queryForList(sql10);
						Map map10 = list10.get(0);
						request.getSession().setAttribute("Kb10", map10);
						}
						else{
						Map map10 = new HashMap();
						map10.put("kcName","");
						request.getSession().setAttribute("Kb10", map10);
						}
						/*判断周一 56节
						 * 
						 */
						String sql11="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期一' and kcjs='五六节'";
						sql11+="and studnetId ="+getStudent(request).get("id");
						if (MySQLUtil.checkCountExecute(sql11)!=false){
						List<Map> list11 = db.queryForList(sql11);
						Map map11 = list11.get(0);
						request.getSession().setAttribute("Kb11", map11);
						}
						else{
							Map map11 = new HashMap();
							map11.put("kcName","");
							request.getSession().setAttribute("Kb11", map11);
						}
						
						
						/*
						 * 判断周二56节
						 */
						String sql12="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期二' and kcjs='五六节'";
						sql12+="and studnetId ="+getStudent(request).get("id");
						if (MySQLUtil.checkCountExecute(sql12)!=false){
						List<Map> list12 = db.queryForList(sql12);
						Map map12 = list12.get(0);
						request.getSession().setAttribute("Kb12", map12);
						}
						else{
							Map map12 = new HashMap();
							map12.put("kcName","");
							request.getSession().setAttribute("Kb12", map12);
						}
						
						/*
						 * 判断周三56节
						 */
								String sql13="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期三' and kcjs='五六节'";
								sql13+="and studnetId ="+getStudent(request).get("id");
								if (MySQLUtil.checkCountExecute(sql13)!=false){
								List<Map> list13 = db.queryForList(sql13);
								Map map13 = list13.get(0);
								request.getSession().setAttribute("Kb13", map13);
								}
								else{
									Map map13 = new HashMap();
									map13.put("kcName","");
									request.getSession().setAttribute("Kb13", map13);
								}
								
						/*
						* 判断周四56节
						*/
							String sql14="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期四' and kcjs='五六节'";
						    sql14+="and studnetId ="+getStudent(request).get("id");
							if (MySQLUtil.checkCountExecute(sql14)!=false){
							List<Map> list14 = db.queryForList(sql14);
							Map map14 = list14.get(0);
							request.getSession().setAttribute("Kb14", map14);
							}
							else{
							Map map14 = new HashMap();
							map14.put("kcName","");
							request.getSession().setAttribute("Kb14", map14);
							}
							
							
							/*
							* 判断周五56节
							*/
								String sql15="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期五' and kcjs='五六节'";
							    sql15+="and studnetId ="+getStudent(request).get("id");
								if (MySQLUtil.checkCountExecute(sql15)!=false){
								List<Map> list15 = db.queryForList(sql15);
								Map map15 = list15.get(0);
								request.getSession().setAttribute("Kb15", map15);
								}
								else{
								Map map15 = new HashMap();
								map15.put("kcName","");
								request.getSession().setAttribute("Kb15", map15);
								}
			
								/*判断周一 78节
								 * 
								 */
								String sql16="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期一' and kcjs='七八节'";
								sql16+="and studnetId ="+getStudent(request).get("id");
								if (MySQLUtil.checkCountExecute(sql16)!=false){
								List<Map> list16 = db.queryForList(sql16);
								Map map16 = list16.get(0);
								request.getSession().setAttribute("Kb16", map16);
								}
								else{
									Map map16 = new HashMap();
									map16.put("kcName","");
									request.getSession().setAttribute("Kb16", map16);
								}
								
								
								/*
								 * 判断周二78节
								 */
								String sql17="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期二' and kcjs='七八节'";
								sql17+="and studnetId ="+getStudent(request).get("id");
								if (MySQLUtil.checkCountExecute(sql17)!=false){
								List<Map> list17 = db.queryForList(sql17);
								Map map17 = list17.get(0);
								request.getSession().setAttribute("Kb17", map17);
								}
								else{
									Map map17 = new HashMap();
									map17.put("kcName","");
									request.getSession().setAttribute("Kb17", map17);
								}
								
								/*
								 * 判断周三78节
								 */
										String sql18="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期三' and kcjs='七八节'";
										sql18+="and studnetId ="+getStudent(request).get("id");
										if (MySQLUtil.checkCountExecute(sql18)!=false){
										List<Map> list18 = db.queryForList(sql18);
										Map map18 = list18.get(0);
										request.getSession().setAttribute("Kb18", map18);
										}
										else{
											Map map18 = new HashMap();
											map18.put("kcName","");
											request.getSession().setAttribute("Kb18", map18);
										}
										
								/*
								* 判断周四78节
								*/
									String sql19="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期四' and kcjs='七八节'";
								    sql19+="and studnetId ="+getStudent(request).get("id");
									if (MySQLUtil.checkCountExecute(sql19)!=false){
									List<Map> list19 = db.queryForList(sql19);
									Map map19 = list19.get(0);
									request.getSession().setAttribute("Kb19", map19);
									}
									else{
									Map map19 = new HashMap();
									map19.put("kcName","");
									request.getSession().setAttribute("Kb19", map19);
									}
									
									
									/*
									* 判断周五78节
									*/
										String sql20="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期五' and kcjs='七八节'";
									    sql20+="and studnetId ="+getStudent(request).get("id");
										if (MySQLUtil.checkCountExecute(sql20)!=false){
										List<Map> list20 = db.queryForList(sql20);
										Map map20 = list20.get(0);
										request.getSession().setAttribute("Kb20", map20);
										}
										else{
										Map map20 = new HashMap();
										map20.put("kcName","");
										request.getSession().setAttribute("Kb20", map20);
										}
					
										/*判断周一 910节
										 * 
										 */
										String sql21="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期一' and kcjs='九十节'";
										sql21+="and studnetId ="+getStudent(request).get("id");
										if (MySQLUtil.checkCountExecute(sql21)!=false){
										List<Map> list21 = db.queryForList(sql21);
										Map map21 = list21.get(0);
										request.getSession().setAttribute("Kb21", map21);
										}
										else{
											Map map21 = new HashMap();
											map21.put("kcName","");
											request.getSession().setAttribute("Kb21", map21);
										}
										
										
										/*
										 * 判断周二910节
										 */
										String sql22="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期二' and kcjs='九十节'";
										sql22+="and studnetId ="+getStudent(request).get("id");
										if (MySQLUtil.checkCountExecute(sql22)!=false){
										List<Map> list22 = db.queryForList(sql22);
										Map map22 = list22.get(0);
										request.getSession().setAttribute("Kb22", map22);
										}
										else{
											Map map22 = new HashMap();
											map22.put("kcName","");
											request.getSession().setAttribute("Kb22", map22);
										}
										
										/*
										 * 判断周三910节
										 */
												String sql23="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期三' and kcjs='九十节'";
												sql23+="and studnetId ="+getStudent(request).get("id");
												if (MySQLUtil.checkCountExecute(sql23)!=false){
												List<Map> list23 = db.queryForList(sql23);
												Map map23 = list23.get(0);
												request.getSession().setAttribute("Kb23", map23);
												}
												else{
													Map map23 = new HashMap();
													map23.put("kcName","");
													request.getSession().setAttribute("Kb23", map23);
												}
												
										/*
										* 判断周四910节
										*/
											String sql24="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期四' and kcjs='九十节'";
										    sql24+="and studnetId ="+getStudent(request).get("id");
											if (MySQLUtil.checkCountExecute(sql24)!=false){
											List<Map> list24 = db.queryForList(sql24);
											Map map24 = list24.get(0);
											request.getSession().setAttribute("Kb24", map24);
											}
											else{
											Map map24 = new HashMap();
											map24.put("kcName","");
											request.getSession().setAttribute("Kb24", map24);
											}
											
											
											/*
											* 判断周五910节
											*/
												String sql25="select kcName,ls,kcDD from t_kc left join t_xk on t_kc.id=t_xk.ckId where kcxq='星期五' and kcjs='九十节'";
											    sql25+="and studnetId ="+getStudent(request).get("id");
												if (MySQLUtil.checkCountExecute(sql25)!=false){
												List<Map> list25 = db.queryForList(sql25);
												Map map25 = list25.get(0);
												request.getSession().setAttribute("Kb25", map25);
												}
												else{
												Map map25 = new HashMap();
												map25.put("kcName","");
												request.getSession().setAttribute("Kb25", map25);
												}
															
										
										
			return "/admin/kc/Kb";
	}
	
/**
* 查询列表
*/
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String flag,String kcName,String kcxq,String kcsx,String kcjs)throws Exception {
		

		String sql="select a.* from t_kc a where 1=1 ";


	if(kcName!=null&&!"".equals(kcName)){
			sql+=" and kcName like '%"+kcName+"%'";
		}
	if(kcxq!=null&&!"".equals(kcxq)){
		sql+=" and kcxq like '%"+kcxq+"%'";
	}
	if(kcsx!=null&&!"".equals(kcsx)){
		sql+=" and kcsx like '%"+kcsx+"%'";
	}
	if(kcjs!=null&&!"".equals(kcjs)){
		sql+=" and kcjs like '%"+kcjs+"%'";
	}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/kc/list";
	}
	
/**
* 编辑保存（包含修改和添加）
*/
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id,String flag
		,String kcName,String ls,Integer xs,String kcsx,String kcType,Long score,Long kcPeople,String kcTime,String kcDD,String kcjs,String kcxq) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_kc set kcName=?,ls=? ,kcType=?,score=?,kcPeople=?,kcTime=?,kcxq=?,kcjs=?,kcDD=?,xs=?,kcsx=?where id=?";
			result = db.update(sql, new Object[]{kcName,ls,kcType,score,kcPeople,kcTime,kcxq,kcjs,kcDD,xs,kcsx,id});
		}else{
			String sql="insert into t_kc(kcName,ls,kcType,score,kcPeople,kcTime,kcxq,kcjs,kcDD,xs,kcsx) values(?,?,?,?,?,?,?,?,?,?,?)";
			result = db.update(sql, new Object[]{kcName,ls,kcType,score,kcPeople,kcTime,kcxq,kcjs,kcDD,xs,kcsx});
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	
	
	@RequestMapping(value = "/xkSave")
	public ResponseEntity<String> xkSave(Model model,HttpServletRequest request,Long id,String flag
		,Integer ckId,Integer studnetId,String cj,String status) throws Exception{
		int result = 0;
		int result2 =0;
		int a = db.queryForInt("select count(1) from t_xk where ckId=? and studnetId=?", new Object[]{id,getStudent(request).get("id")});
		if(a>0){
			return renderData(false,"操作成功",null);
		}
		String sql="insert into t_xk(ckId,studnetId,cj,status) values(?,?,?,?)";
		result = db.update(sql, new Object[]{id,getStudent(request).get("id"),null,"待考试"});
		String sql2="update t_kc set kcyx=(select count(1) from t_xk where ckId=?) where id=? ";//已选人数更新
		result2=db.update(sql2,new Object[]{id,id});
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
		
		String sql="delete from t_kc where id=?";
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
			String sql="select * from t_kc where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}String sql="";

		return "/admin/kc/edit";
	}
	
	
	
	@RequestMapping(value = "/kcAvg")
	public ResponseEntity<String> kcAvg(Model model,HttpServletRequest request,Long id,String flag
			) throws Exception{
			int result = 0;
			result = db.update(" update t_kc set kcAvg=(select avg(cj) from t_xk  where ckId=?) where id=?", new Object[]{id,id});
			
			
			if(result==1){
				return renderData(true,"操作成功",null);
			}else{
				return renderData(false,"操作失败",null);
			}
		}
}
