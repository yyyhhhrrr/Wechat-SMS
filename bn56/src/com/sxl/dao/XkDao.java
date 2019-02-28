package com.sxl.dao;
import java.util.List;
import com.sxl.model.Xk;
public interface XkDao {
    List<Xk> queryForList(Xk xk);
    int delete(Integer id);
    Xk getById(Integer id);
    int update(Xk xk);
    int insert(Xk xk);
}
