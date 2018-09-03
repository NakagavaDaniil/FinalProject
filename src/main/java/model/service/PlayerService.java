package model.service;


import model.dao.DaoFactory;
import model.dao.PlayerDAO;
import model.entity.Game;
import model.entity.Player;
import model.entity.Team;

import java.util.ArrayList;
import java.util.List;


public class PlayerService {


    private DaoFactory daoFactory = DaoFactory.getInstance();
    private PlayerDAO playerDao = daoFactory.createPlayerDao();


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





}
