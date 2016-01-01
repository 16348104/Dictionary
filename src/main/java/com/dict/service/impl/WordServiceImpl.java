package com.dict.service.impl;

import com.dict.dao.GenericDao;
import com.dict.dao.WordDao;
import com.dict.model.Word;
import com.dict.service.WordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by xdx on 2016/1/2.
 */
@Service
public class WordServiceImpl extends GenericServiceImpl<Word,Integer>implements WordService
{
    @Override
    @Autowired
    @Qualifier("wordDaoImpl")

    protected void setGenericDao(GenericDao<Word, Integer> genericDao) {
        super.genericDao = genericDao;

    }

    @Override
    public Word queryWordByEnglish(String english) {
        return ((WordDao)genericDao).queryWordByEnglish(english);
    }
}
