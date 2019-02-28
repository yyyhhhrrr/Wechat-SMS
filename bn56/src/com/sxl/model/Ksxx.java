package com.sxl.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class Ksxx {
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
private Long studentId;
private String title;
private String pic;
private String content;
private Date showDate;
private String ksdd;
private Long kcId;
public Long getStudentId() {return studentId;}
public void setStudentId(Long studentId) {this.studentId = studentId;}
public String getTitle() {return title;}
public void setTitle(String title) {this.title = title;}
public String getPic() {return pic;}
public void setPic(String pic) {this.pic = pic;}
public String getContent() {return content;}
public void setContent(String content) {this.content = content;}
public Date getShowDate() {return showDate;}
public void setShowDate(Date showDate) {this.showDate = showDate;}
public String getKsdd() {return ksdd;}
public void setKsdd(String ksdd) {this.ksdd = ksdd;}
public Long getKcId() {
	return kcId;
}
public void setKcId(Long kcId) {
	this.kcId = kcId;
}
}