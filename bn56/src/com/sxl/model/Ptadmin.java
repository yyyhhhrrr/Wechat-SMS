package com.sxl.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class Ptadmin {
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
private String username;
private String password;
private String ptadminName;
private String age;
private String sex;
private String phone;
public String getUsername() {return username;}
public void setUsername(String username) {this.username = username;}
public String getPassword() {return password;}
public void setPassword(String password) {this.password = password;}
public String getPtadminName() {return ptadminName;}
public void setPtadminName(String ptadminName) {this.ptadminName = ptadminName;}
public String getAge() {return age;}
public void setAge(String age) {this.age = age;}
public String getSex() {return sex;}
public void setSex(String sex) {this.sex = sex;}
public String getPhone() {return phone;}
public void setPhone(String phone) {this.phone = phone;}
}