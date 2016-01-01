package com.dict.dao.impl;

import com.dict.dao.GenericDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

/**
 * Created by xdx on 2015/12/30.
 */
public class GenericDaoImpl<T extends Serializable, ID extends Serializable> implements GenericDao<T, ID> {
    private String namespace;
    @Autowired
    protected SqlSessionFactory sqlSessionFactory;

    public GenericDaoImpl() {//java反射
        ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
        Class<T> modelClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        namespace = modelClass.getSimpleName().toLowerCase().concat(".");
    }

    @Override
    public void add(T t) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.insert(namespace.concat("add"), t);
        sqlSession.close();
    }

    @Override
    public void remove(ID id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sqlSession.delete(namespace.concat("remove"),id);
        sqlSession.close();
    }

    @Override
    public T query(T t) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        t = sqlSession.selectOne(namespace.concat("query"), t);
        sqlSession.close();
        return t;
    }
}
