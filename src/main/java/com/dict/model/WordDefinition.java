package com.dict.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class WordDefinition extends BaseModel {
    private Integer id;
    private String partOfSpeech;
    private String chinese;
    private Integer wordId;
}
