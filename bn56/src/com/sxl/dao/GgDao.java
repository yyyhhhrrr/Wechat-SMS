package com.sxl.dao;
import java.util.List;
import com.sxl.model.Gg;
public interface GgDao {
    List<Gg> queryForList(Gg gg);
    int delete(Integer id);
    Gg getById(Integer id);
    int update(Gg gg);
    int insert(Gg gg);
}
