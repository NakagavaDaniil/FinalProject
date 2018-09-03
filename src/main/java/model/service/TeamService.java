package model.service;

import model.dao.DaoFactory;
import model.dao.TeamDAO;
import model.entity.Team;

import java.util.List;

public class TeamService  {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private TeamDAO teamDao = daoFactory.createTeamDao();
    public List<Team> getAllTeams(){

        List<Team> allTeams;
        allTeams = teamDao.findAllTeams();
        return allTeams;
    }

    public Team createTeam(Team entity){
        return teamDao.create(entity);
    }

    public Team getByNameTeam(String teamName){
        return teamDao.findTeam(teamName);
    }
    public List<Team> getAllMyTeams(int id){

        List<Team> allTeams;
        allTeams = teamDao.getMyTeams(id);
        return allTeams;
    }
}
