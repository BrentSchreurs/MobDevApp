package com.brent.school.koreanapp.Model;

import java.io.Serializable;

/**
 * Created by Brent on 10-10-2017.
 */

public class Translation implements Serializable {

    public Translation(int id, String korean, String english) {
        this.id = id;
        this.korean = korean;
        this.english = english;
    }

    public Translation(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKorean() {
        return korean;
    }

    public void setKorean(String korean) {
        this.korean = korean;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    private int id;
    private String korean;
    private String english;


}
