package model.entity;

import java.util.ArrayList;

public class Team {


   private ArrayList<Player> team;
   private int tottalWinsCount;
   private int tottalGamesCount;
   private ArrayList<Game> gameHistory;

    public int getTottalWinsCount() {
        return tottalWinsCount;
    }

    public void setTottalWinsCount(int tottalWinsCount) {
        this.tottalWinsCount = tottalWinsCount;
    }

    public int getTottalGamesCount() {
        return tottalGamesCount;
    }

    public void setTottalGamesCount(int tottalGamesCount) {
        this.tottalGamesCount = tottalGamesCount;
    }

    public ArrayList<Game> getGameHistory() {
        return gameHistory;
    }

    public void setGameHistory(ArrayList<Game> gameHistory) {
        this.gameHistory = gameHistory;
    }

    public Team() {
    }

    public Team(ArrayList<Player> team) {
        this.team = team;
    }

    public ArrayList<Player> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<Player> team) {
        this.team = team;
    }
}
