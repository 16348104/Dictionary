package com.dict.service;

import com.dict.model.Word;

/**
 * Created by xdx on 2016/1/2.
 */
public interface WordService extends GenericService<Word, Integer> {
    Word queryWordByEnglish(String english);

}
