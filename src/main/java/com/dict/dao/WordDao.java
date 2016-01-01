package com.dict.dao;

import com.dict.model.Word;

/**
 * Created by xdx on 2016/1/2.
 */
public interface WordDao extends GenericDao<Word,Integer> {
Word queryWordByEnglish(String english);
}
