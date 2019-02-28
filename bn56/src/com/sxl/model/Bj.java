package com.sxl.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class Bj {
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
private String bjName;
public String getBjName() {return bjName;}
public void setBjName(String bjName) {this.bjName = bjName;}
public String getBjXueyuan() {
	return bjXueyuan;
}
public void setBjXueyuan(String bjXueyuan) {
	this.bjXueyuan = bjXueyuan;
}
private String bjXueyuan;
}