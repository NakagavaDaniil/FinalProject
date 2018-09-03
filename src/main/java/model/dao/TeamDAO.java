package model.dao;

import model.entity.Team;

import java.util.List;

public interface TeamDAO extends GenericDao<Team>{
    // TODO: 02.09.2018 all
    List<Team> findAllTeams();
    Team findTeam(String teamName);
    List<Team> getMyTeams(int id);
    Team create(Team entity);
}
