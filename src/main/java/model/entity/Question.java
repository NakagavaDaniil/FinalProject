package model.entity;

import java.util.ArrayList;
import java.util.Locale;


public class Question {

    private int id;
    private String question;
    private String answear;
    private String  language;
    private ArrayList<String> variantsOfAnswear;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswear() {
        return answear;
    }

    public void setAnswear(String answear) {
        this.answear = answear;
    }

    public ArrayList<String> getVariantsOfAnswear() {
        return variantsOfAnswear;
    }

    public void setVariantsOfAnswear(ArrayList<String> variantsOfAnswear) {
        this.variantsOfAnswear = variantsOfAnswear;
    }
}
