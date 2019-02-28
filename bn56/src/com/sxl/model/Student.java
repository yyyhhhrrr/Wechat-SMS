package com.sxl.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class Student {
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
private String username;
private String password;
private String studentName;
private String xueyuan;
private String zhuanye;
private Long bjId;
private String age;
private String sex;
private String phone;
private String qq;
private String email;
private String zhuzhi;
private String pic;
private String type;
public String getUsername() {return username;}
public void setUsername(String username) {this.username = username;}
public String getPassword() {return password;}
public void setPassword(String password) {this.password = password;}
public String getStudentName() {return studentName;}
public void setStudentName(String studentName) {this.studentName = studentName;}
public Long getBjId() {return bjId;}
public void setBjId(Long bjId) {this.bjId = bjId;}
public String getAge() {return age;}
public void setAge(String age) {this.age = age;}
public String getSex() {return sex;}
public void setSex(String sex) {this.sex = sex;}
public String getPhone() {return phone;}
public void setPhone(String phone) {this.phone = phone;}
public String getQq() {return qq;}
public void setQq(String qq) {this.qq = qq;}
public String getEmail() {return email;}
public void setEmail(String email) {this.email = email;}
public String getPic() {return pic;}
public void setPic(String pic) {this.pic = pic;}
public String getXueyuan() {
	return xueyuan;
}
public void setXueyuan(String xueyuan) {
	this.xueyuan = xueyuan;
}
public String getZhuanye() {
	return zhuanye;
}
public void setZhuanye(String zhuanye) {
	this.zhuanye = zhuanye;
}
public String getZhuzhi() {
	return zhuzhi;
}
public void setZhuzhi(String zhuzhi) {
	this.zhuzhi = zhuzhi;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
}