package com.jwl.common.sys.common;

import com.jwl.common.sys.annotation.Dosamething;
import org.apache.ibatis.session.RowBounds;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public abstract class BaseServiceImpl<M> implements BaseService<M> {
    @Override
    @Transactional(readOnly = true)
    public M findById(Object key) {
        return mapper().selectByPrimaryKey(key);
    }
    @Transactional(readOnly = true)
    @Override
    public List<M> findByExample(Object example) {
        return mapper().selectByExample(example);
    }

    @Transactional
    @Override
    public int deleteByExample(Object example) {
        return mapper().deleteByExample(example);
    }

    @Override
    @Transactional
    public int deleteById(Object key) {
        return mapper().deleteByPrimaryKey(key);
    }



    @Override
    @Transactional(readOnly = true)
    @Dosamething(value = "分页查询",key = "record")
    public List<M> selectByRowBounds(M record, RowBounds rowBounds) {
        return mapper().selectByRowBounds(record,rowBounds);
    }

    @Override
    @Transactional(readOnly = true)
    public List<M> selectByExampleAndRowBounds(Object example, RowBounds rowBounds) {
        return mapper().selectByExampleAndRowBounds(example,rowBounds);
    }

    @Override
    @Transactional
    public Object update(M record) {
        return  mapper().updateByPrimaryKey(record);
    }

    @Override
    @Transactional
    public Object add(M record) {
        return mapper().insert(record);
    }

    @Override
    @Transactional(readOnly = true)
    public int count(M record) {
        return mapper().selectCount(record);
    }

    @Override
    public abstract  Mapper<M> mapper();
}
