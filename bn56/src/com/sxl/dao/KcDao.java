package com.sxl.dao;
import java.util.List;
import com.sxl.model.Kc;
public interface KcDao {
    List<Kc> queryForList(Kc kc);
    int delete(Integer id);
    Kc getById(Integer id);
    int update(Kc kc);
    int insert(Kc kc);
}
