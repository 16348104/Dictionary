package com.dict.service;

import java.io.Serializable;

/**
 * Created by xdx on 2015/12/30.
 */
public interface GenericService <T extends Serializable , ID extends Serializable>{
    void add(T t);
    void remove(ID id);
    T query(T t);
}
