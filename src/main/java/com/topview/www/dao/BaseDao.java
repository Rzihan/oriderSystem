package com.topview.www.dao;

import java.util.List;

public interface BaseDao<T> {

    int addData(T t);

    int removeData(T t);

    int updateData(T t);

    T selectOne(T t);

    List<T> selectList(T t);
}
