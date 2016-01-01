package com.dict.dao.impl;

import com.dict.dao.WordDao;
import com.dict.model.Word;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * Created by xdx on 2016/1/2.
 */
@Repository
public class WordDaoImpl extends GenericDaoImpl<Word,Integer> implements WordDao {
    @Override
    public Word queryWordByEnglish(String english) {
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        Word word = sqlSession.selectOne("word.queryWordByEnglish", english);
        sqlSession.close();
        return word;
    }
}
