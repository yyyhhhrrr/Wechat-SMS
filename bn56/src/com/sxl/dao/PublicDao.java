package com.sxl.dao;

import java.util.List;
import java.util.Map;

public interface PublicDao {
    List<Map> queryForList(String sql);
    int update(String sql);
    Map queryForMap(String sql);
}