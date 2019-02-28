
package com.sxl.controller.admin;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;
import com.sxl.dao.Book2Dao;
import com.sxl.model.Book2;

@Controller("testController")
@RequestMapping(value = "/admin/book")
public class TestController extends MyController {
	
	@Autowired
	public Book2Dao bookDao2;

	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
//		List<Book> list = db.queryForObject(Book.class, "select * from t_book");
//		System.out.println("one==================="+list.get(0).getBookName());
//		List<Map> out = db.queryForList("select * from t_book",new Object[]{});
//		int aa = db.queryForInt("select count(1) stringval from t_book where id=?",new Object[]{2});
//		System.out.println(aa);
//		String bb = db.queryForString("select bookName stringval from t_book where id=?",new Object[]{1});
//		System.out.println("bb==="+bb);
//		db.update("update t_book set bookName='哇哈哈' where id=?", new Object[]{2});
//		Book book = new Book();
//		book.setBookName("狸花猫");
//		book.setNum(22);
//		book.setPrice(12d);
//		book.setShowDate(new Date());
//		book.setId(19l);
//		List<Book> bookList = bookDao.queryForList(book);
////		bookDao.delete(19);
//		System.out.println(bookList.get(0).getShowDate());
		
		
		List<Map> list = db.queryForList("select * from t_book");
		System.out.println("**jdbctemplate***"+list);
		Book2 book2 = new Book2();
		book2.setAllfee(12.55f);
		book2.setBookName("王大大11");
		book2.setInsertDate(new Date());
		book2.setNum(12);
		book2.setPrice(12.2d);
		book2.setVALSS("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊111");
		bookDao2.insert(book2);
		
		Book2 book22 = new Book2();
//		book2.setBookName("大");
		List<Book2> list2 = bookDao2.queryForList(book22);
		for (int i = 0; i < list2.size(); i++) {
			System.out.println(list2.get(i).getBookName());
			System.out.println(list2.get(i).getVALSS());
			System.out.println(list2.get(i).getInsertDate());
		}
//		Book2 book2 = bookDao2.getById(1);
//		System.out.println(book2.getBookName());
//		System.out.println(book2.getVALSS());
//		System.out.println(book2.getInsertDate());
		
		return "/admin/book/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String flag,String testName)throws Exception {
		String sql="select * from t_book";
	if(testName!=null&&!"".equals(testName)){
			sql+=" and testName like '%"+testName+"%'";
		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/book/list";
	}
	
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id,String flag
		,Integer customerId,String bookName,Double price,String testSex,String testDay,String testPic,String insertDate) throws Exception{
		int result = 0;
		String sql="insert into t_book(bookName,price) values(?,?)";
		result = db.update(sql, new Object[]{bookName,price });
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model,HttpServletRequest request,Long id,String flag) throws Exception {
		
		String sql="delete from t_test where id=?";
		int result = db.update(sql, new Object[]{id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
		
	}
	
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request,Long id,String flag)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_test where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}String sql="";

		return "/admin/book/edit";
	}
}
