package com.sxl.dao;
import java.util.List;
import com.sxl.model.Ptadmin;
public interface PtadminDao {
    List<Ptadmin> queryForList(Ptadmin ptadmin);
    int delete(Integer id);
    Ptadmin getById(Integer id);
    int update(Ptadmin ptadmin);
    int insert(Ptadmin ptadmin);
}
