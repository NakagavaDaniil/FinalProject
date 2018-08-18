package model.entity;

import java.util.ArrayList;

public class Judge extends  User{

   private int tottalHintsGivenCount;
   private int tottalGamesCount;
   private ArrayList<Question> questions;


    public Judge() {
    }

    public int getTottalHintsGivenCount() {
        return tottalHintsGivenCount;
    }

    public void setTottalHintsGivenCount(int tottalHintsGivenCount) {
        this.tottalHintsGivenCount = tottalHintsGivenCount;
    }

    public int getTottalGamesCount() {
        return tottalGamesCount;
    }

    public void setTottalGamesCount(int tottalGamesCount) {
        this.tottalGamesCount = tottalGamesCount;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
