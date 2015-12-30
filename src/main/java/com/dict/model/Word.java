package com.dict.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Word extends BaseModel{
    private Integer id;
    private String english;
    private String phoneticUk;
    private String phoneticUs;
    private String audioUkMale;
    private String audioUkFemale;
    private String audioUsMale;
    private String audioUsFemale;
    private String extension;
    private String etymologyCn;
    private String level;
    private List<WordDefinition> wordDefinitions = new ArrayList<>();
    private List<WordSentence> wordSentences = new ArrayList<>();


}
