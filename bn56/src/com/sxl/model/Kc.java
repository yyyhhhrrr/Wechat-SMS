package com.sxl.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class Kc {
private Integer id;
private String kcType;
private Integer score;
private Integer xs;
private String kcTime;
private float kcAvg;
private String kcxq;
private String kcjs;
private Integer kcPeople;
private String kcDD;
private String kcsx;
private Integer kcyx;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
private String kcName;
private String ls;
public String getKcName() {return kcName;}
public void setKcName(String kcName) {this.kcName = kcName;}
public String getLs() {return ls;}
public void setLs(String ls) {this.ls = ls;}
public String getKcType() {
	return kcType;
}
public void setKcType(String kcType) {
	this.kcType = kcType;
}
public Integer getScore() {
	return score;
}
public void setScore(Integer score) {
	this.score = score;
}
public Integer getXs() {
	return xs;
}
public void setXs(Integer xs) {
	this.xs = xs;
}
public String getKcTime() {
	return kcTime;
}
public void setKcTime(String kcTime) {
	this.kcTime = kcTime;
}
public Integer getKcPeople() {
	return kcPeople;
}
public void setKcPeople(Integer kcPeople) {
	this.kcPeople = kcPeople;
}
public String getKcDD() {
	return kcDD;
}
public void setKcDD(String kcDD) {
	this.kcDD = kcDD;
}
public String getKcsx() {
	return kcsx;
}
public void setKcsx(String kcsx) {
	this.kcsx = kcsx;
}
public Integer getKcyx() {
	return kcyx;
}
public void setKcyx(Integer kcyx) {
	this.kcyx = kcyx;
}
public String getKcxq() {
	return kcxq;
}
public void setKcxq(String kcxq) {
	this.kcxq = kcxq;
}
public String getKcjs() {
	return kcjs;
}
public void setKcjs(String kcjs) {
	this.kcjs = kcjs;
}
public float getKcAvg() {
	return kcAvg;
}
public void setKcAvg(float kcAvg) {
	this.kcAvg = kcAvg;
}

}