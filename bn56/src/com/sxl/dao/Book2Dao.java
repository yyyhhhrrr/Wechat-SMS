package com.sxl.dao;
import java.util.List;
import com.sxl.model.Book2;
public interface Book2Dao {
    List<Book2> queryForList(Book2 book2);
    int delete(Integer id);
    Book2 getById(Integer id);
    int update(Book2 book2);
    int insert(Book2 book2);
}