package com.jwl.common.sys.common;

import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseService<M> {

    M findById(Object key);
    List<M> findByExample(Object example);
    int deleteById(Object key);
    int deleteByExample(Object example);
    List<M> selectByRowBounds(M record, RowBounds rowBounds);
    List<M> selectByExampleAndRowBounds(Object example, RowBounds rowBounds);
    Object update(M record);
    Object add(M record);
    Mapper<M> mapper();
    int count(M record);


}
