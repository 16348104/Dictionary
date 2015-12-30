package com.dict.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WordSentence extends BaseModel {
    private Integer id;
    private String partOfSpeech;
    private String english;
    private String chinese;
    private String audioMale;
    private String audioFemale;
    private String source;
    private Integer wordId;
}
