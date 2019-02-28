package com.sxl.dao;

import java.util.List;

import com.sxl.model.Admin;

public interface AdminDao {
    List<Admin> isAdminExists(Admin admin);
    
    Admin getById(Integer id);
}