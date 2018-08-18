package model.entity;

import java.util.ArrayList;

public class Player extends User{

   private  int tottalWinsCount;
   private  int tottalGamesCount;
   private  int tottalPointsCount;
   private  ArrayList<Game> gameHistory;

    public Player() {
    }

    public Player(int tottalWinsCount, int tottalGamesCount, int tottalPointsCount, ArrayList gameHistory) {
        this.tottalWinsCount = tottalWinsCount;
        this.tottalGamesCount = tottalGamesCount;
        this.tottalPointsCount = tottalPointsCount;
        this.gameHistory = gameHistory;
    }

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

    public int getTottalPointsCount() {
        return tottalPointsCount;
    }

    public void setTottalPointsCount(int tottalPointsCount) {
        this.tottalPointsCount = tottalPointsCount;
    }

    public ArrayList getGameHistory() {
        return gameHistory;
    }

    public void setGameHistory(ArrayList gameHistory) {
        this.gameHistory = gameHistory;
    }
}
