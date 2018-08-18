package model.entity;

import java.util.ArrayList;

public class Question {

    private String question;
    private ArrayList<String> answear;
    private ArrayList<String> variantsOfAnswear;

    public Question() {
    }

    public Question(String question, ArrayList<String> answear, ArrayList<String> variantsOfAnswear) {
        this.question = question;
        this.answear = answear;
        this.variantsOfAnswear = variantsOfAnswear;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswear() {
        return answear;
    }

    public void setAnswear(ArrayList<String> answear) {
        this.answear = answear;
    }

    public ArrayList<String> getVariantsOfAnswear() {
        return variantsOfAnswear;
    }

    public void setVariantsOfAnswear(ArrayList<String> variantsOfAnswear) {
        this.variantsOfAnswear = variantsOfAnswear;
    }
}
