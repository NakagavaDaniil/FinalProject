package model.dao.mapper;

import model.entity.Team;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.Map;

public class TeamMapper implements ObjectMapper<Team> {
    @Override
    public Team extractFromResultSet(ResultSet rs) throws SQLException {
        Team team = new Team();
            team.setName(rs.getString("team_name"));
            team.setTottalGamesCount(rs.getInt("tottal_games"));
            team.setTottalWinsCount(rs.getInt("tottal_wins"));

        return team;
    }

    @Override
    public Team makeUnique(Map<Integer, Team> cache, Team user) {
        return null;
    }
}
