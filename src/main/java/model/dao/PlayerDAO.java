package model.dao;


import model.entity.Game;
import model.entity.Player;
import model.entity.Team;

import java.util.List;


public interface PlayerDAO extends GenericDao<Player> {
//TODO maybe add something

    List<Game> getGameHistoy(List<Team> teamList);
    List<Game> findLoses(List<String> teamList);
    List<Game>  findWins(List<String> teamList);
    List<Game>  findAllGames();
    List<Game>  findLoses(String teamName);
    List<Game>  findWins(String teamName);
    List<Game> findAllGames(String teamName);




}
