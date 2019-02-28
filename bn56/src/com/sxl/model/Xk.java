package com.sxl.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

public class Xk {
private Integer id;
public Integer getId() {return id;}
public void setId(Integer id) {this.id = id;}
private Long ckId;
private Long studnetId;

private String cj;
private String status;
public Long getCkId() {return ckId;}
public void setCkId(Long ckId) {this.ckId = ckId;}
public Long getStudnetId() {return studnetId;}
public void setStudnetId(Long studnetId) {this.studnetId = studnetId;}
public String getCj() {return cj;}
public void setCj(String cj) {this.cj = cj;}
public String getStatus() {return status;}
public void setStatus(String status) {this.status = status;}
}