package model.entity;

import java.time.LocalDateTime;

public class Game {

    private Judge judge;
    private Team teamA;
    private Team teamB;
    private String teamWinnerName;
    private LocalDateTime localDateTimeOfGame;
    private int numberOfQuestions;

    public Game() {
    }

    public Game(Judge judge, Team teamA, Team teamB, String teamWinnerName, LocalDateTime localDateTimeOfGame, int numberOfQuestions) {
        this.judge = judge;
        this.teamA = teamA;
        this.teamB = teamB;
        this.teamWinnerName = teamWinnerName;
        this.localDateTimeOfGame = localDateTimeOfGame;
        this.numberOfQuestions = numberOfQuestions;
    }

    public Judge getJudge() {
        return judge;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }

    public Team getTeamA() {
        return teamA;
    }

    public void setTeamA(Team teamA) {
        this.teamA = teamA;
    }

    public Team getTeamB() {
        return teamB;
    }

    public void setTeamB(Team teamB) {
        this.teamB = teamB;
    }

    public String getTeamWinnerName() {
        return teamWinnerName;
    }

    public void setTeamWinnerName(String teamWinnerName) {
        this.teamWinnerName = teamWinnerName;
    }

    public LocalDateTime getLocalDateTimeOfGame() {
        return localDateTimeOfGame;
    }

    public void setLocalDateTimeOfGame(LocalDateTime localDateTimeOfGame) {
        this.localDateTimeOfGame = localDateTimeOfGame;
    }

    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    public void setNumberOfQuestions(int numberOfQuestions) {
        this.numberOfQuestions = numberOfQuestions;
    }
}
