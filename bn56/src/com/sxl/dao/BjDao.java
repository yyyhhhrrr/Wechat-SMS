package com.sxl.dao;
import java.util.List;
import com.sxl.model.Bj;
public interface BjDao {
    List<Bj> queryForList(Bj bj);
    int delete(Integer id);
    Bj getById(Integer id);
    int update(Bj bj);
    int insert(Bj bj);
}
