package com.dict.service.impl;

import com.dict.dao.GenericDao;
import com.dict.service.GenericService;

import java.io.Serializable;

/**
 * Created by xdx on 2015/12/30.
 */
public abstract class GenericServiceImpl<T extends Serializable, ID extends Serializable> implements GenericService
{
    protected GenericDao<T, ID> genericDao;//域
    protected abstract void setGenericDao(GenericDao<T, ID> genericDao);
    @Override
    public void add(T t){
        genericDao.add(t);
    }
    @Override
    public void remove(ID id) {
        genericDao.remove(id);
    }

    @Override
    public T queryOne(T t) {
        return genericDao.query(t);
    }

}

