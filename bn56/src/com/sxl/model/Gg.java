package com.sxl.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class Gg {
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
private String title;
private String pic;
private String content;
private Date showDate;
public String getTitle() {return title;}
public void setTitle(String title) {this.title = title;}
public String getPic() {return pic;}
public void setPic(String pic) {this.pic = pic;}
public String getContent() {return content;}
public void setContent(String content) {this.content = content;}
public Date getShowDate() {return showDate;}
public void setShowDate(Date showDate) {this.showDate = showDate;}
}