package model.dao.mapper;

import model.entity.Game;
import model.entity.Team;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Map;

public class TeamMapper implements ObjectMapper<Team> {
    @Override
    public Team extractFromResultSet(ResultSet rs) throws SQLException {
        Team team = new Team();
        team.setId(rs.getInt("id"));
            team.setName(rs.getString("team_name"));
            team.setTottalGamesCount(rs.getInt("tottal_games"));
            team.setTottalWinsCount(rs.getInt("tottal_wins"));

        return team;
    }

    public Game extractFromResultSetGame(ResultSet rs) throws SQLException {
        Game game= new Game();
        game.setId(rs.getInt("id"));
        game.setDateTimeOfGame(rs.getTimestamp("local_date_time").toLocalDateTime());
        game.setWinnerTeam(rs.getString("winner_team_name"));
        game.setLoserTeam(rs.getString("loser_team_name"));
        game.setJudgeLogin(rs.getString("judge_login"));
        return game;

    }

    @Override
    public Team makeUnique(Map<Integer, Team> cache, Team user) {
        return null;
    }
}
