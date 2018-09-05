package model.dao;

import model.entity.Game;
import model.entity.Team;

import java.util.List;

public interface TeamDAO extends GenericDao<Team>{

    // TODO: leave team
    List<Team> findAllTeams();
    Team findTeam(String teamName);
    List<Team> getMyTeams(int id);
    Team create(Team entity);

    List<Game> getTeamHistory(String name);

    List<String> getTeamPlayers(int id);

    void joinTeam(int id, int teamId);
}
