package model.entity;

import java.time.LocalDateTime;

public class Game {
    private int id;
        private String judgeLogin;
        private String loserTeam;
        private String winnerTeam;
        private LocalDateTime dateTimeOfGame;

    public Game() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudgeLogin() {
        return judgeLogin;
    }

    public void setJudgeLogin(String judgeLogin) {
        this.judgeLogin = judgeLogin;
    }

    public String getLoserTeam() {
        return loserTeam;
    }

    public void setLoserTeam(String loserTeam) {
        this.loserTeam = loserTeam;
    }

    public String getWinnerTeam() {
        return winnerTeam;
    }

    public void setWinnerTeam(String winnerTeam) {
        this.winnerTeam = winnerTeam;
    }

    public LocalDateTime getDateTimeOfGame() {
        return dateTimeOfGame;
    }

    public void setDateTimeOfGame(LocalDateTime dateTimeOfGame) {
        this.dateTimeOfGame = dateTimeOfGame;
    }
}
