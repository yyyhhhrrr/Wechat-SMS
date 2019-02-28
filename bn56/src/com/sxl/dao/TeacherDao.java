package com.sxl.dao;
import java.util.List;
import com.sxl.model.Teacher;
public interface TeacherDao {
    List<Teacher> queryForList(Teacher teacher);
    int delete(Integer id);
    Teacher getById(Integer id);
    int update(Teacher teacher);
    int insert(Teacher teacher);
}
