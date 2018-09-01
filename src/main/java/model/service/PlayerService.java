package model.service;


import model.dao.DaoFactory;
import model.dao.PlayerDAO;
import model.entity.Game;
import model.entity.Player;
import model.entity.Team;

import java.util.ArrayList;
import java.util.List;


public class PlayerService {


    DaoFactory daoFactory = DaoFactory.getInstance();
    PlayerDAO playerDao = daoFactory.createPlayerDao();


    public Player getById(int id){
        Player player;
        player=playerDao.findById(id);
        return player;
    }
    public List<Game> getGameHistory(String teamName){
        List<Game> history;
        history= playerDao.findAllGames(teamName);
        return history;

    }


    public List<Team> getAllTeams(){

        List<Team> allTeams;
        allTeams = playerDao.findAllTeams();
        return allTeams;
    }

    public Team getByNameTeam(String teamName){
        return playerDao.findTeam(teamName);
    }
    public List<Team> getAllMyTeams(int id){

        List<Team> allTeams;
        allTeams = playerDao.getMyTeams(id);
        return allTeams;
    }


}
