package model.service;

import model.dao.DaoFactory;
import model.dao.TeamDAO;
import model.entity.Game;
import model.entity.Team;

import java.util.ArrayList;
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

    public List<Game> getTeamHistory(String name) {
        List<Game> gameHistory;
        gameHistory = teamDao.getTeamHistory(name);
        return gameHistory;
    }

    public void joinTeam(int id , int teamId){
        teamDao.joinTeam(id,teamId);
    }

    public Team findById(int id){

            return teamDao.findById(id);
    }

    public List<String> getTeamPLayer(int name) {
        List<String> playerLog = new ArrayList<>();
        playerLog=teamDao.getTeamPlayers(name);
        return playerLog;
    }
}
