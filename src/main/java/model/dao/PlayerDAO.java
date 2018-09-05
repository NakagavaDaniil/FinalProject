package model.dao;


import model.entity.Game;
import model.entity.Player;
import model.entity.Team;

import java.util.List;


public interface PlayerDAO extends GenericDao<Player> {



    List<Game> findAllGames(String teamName);




}
