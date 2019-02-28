package com.sxl.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class Teacher {
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
private String username;
private String password;
private String teacherName;
private String age;
private String sex;
private String phone;
private String pic;
public String getUsername() {return username;}
public void setUsername(String username) {this.username = username;}
public String getPassword() {return password;}
public void setPassword(String password) {this.password = password;}
public String getTeacherName() {return teacherName;}
public void setTeacherName(String teacherName) {this.teacherName = teacherName;}
public String getAge() {return age;}
public void setAge(String age) {this.age = age;}
public String getSex() {return sex;}
public void setSex(String sex) {this.sex = sex;}
public String getPhone() {return phone;}
public void setPhone(String phone) {this.phone = phone;}
public String getPic() {return pic;}
public void setPic(String pic) {this.pic = pic;}
}