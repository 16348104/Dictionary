package model;


import java.io.Serializable;

public class Word implements Serializable {
    private Integer id;
    private String english;
    private String chinese;

    public Word() {
    }

    public Word(Integer id, String english, String chinese) {
        this.id = id;
        this.english = english;
        this.chinese = chinese;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }
}


