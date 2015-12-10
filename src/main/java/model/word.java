package model;

import java.io.Serializable;

/**
 * Created by xdx on 2015/12/10.
 */
public class word implements Serializable{
    private Integer id;
    private String english;
    private String chinese;

    public word() {
    }

    public word(Integer id, String english, String chinese) {
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

