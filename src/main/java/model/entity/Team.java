package model.entity;

import java.util.ArrayList;

public class Team {

    private int id;
   private ArrayList<Player> team;
   private String name;
   private int tottalWinsCount;
   private int tottalGamesCount;
   private ArrayList<Game> gameHistory;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public String toString() {
        return getName()+",";
    }
}
