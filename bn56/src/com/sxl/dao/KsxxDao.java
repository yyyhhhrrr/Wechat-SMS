package com.sxl.dao;
import java.util.List;
import com.sxl.model.Ksxx;
public interface KsxxDao {
    List<Ksxx> queryForList(Ksxx ksxx);
    int delete(Integer id);
    Ksxx getById(Integer id);
    int update(Ksxx ksxx);
    int insert(Ksxx ksxx);
}
