package com.dict.dao;

import java.io.Serializable;

/**
 * Created by xdx on 2015/12/30.
 */
public interface GenericDao<T extends Serializable,ID extends Serializable> {
    void add(T t);
    void remove(ID id);
    T query(T t);


}
