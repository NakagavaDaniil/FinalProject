package model.dao.mapper;


import model.entity.Game;
import model.entity.Player;
import model.entity.Team;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerMapper implements ObjectMapper<Player> {


    @Override
    public Player extractFromResultSet(ResultSet rs) throws SQLException {
        Player player = new Player();
        player.setTottalGamesCount(rs.getInt("tottal_pints"));
        player.setTottalWinsCount(rs.getInt("tottal_wins"));
        player.setTottalPointsCount(rs.getInt("tottal_pints"));
        return player;
    }

    public List<Team> extractFromResultSetTeam(ResultSet rs) throws SQLException {
        List<Team> result = new ArrayList<>();
        while (rs.next()) {
            Team team = new Team();
            team.setName(rs.getString("team_name"));
            //TODO
            System.out.println(rs.getString("team_name"));
            team.setTottalGamesCount(rs.getInt("tottal_games"));
            team.setTottalWinsCount(rs.getInt("tottal_wins"));
            result.add(team);
        }

        return result;
    }

    public Game extractPlayerGames(ResultSet rs){
        Game game = new Game();
        try {
                game.setId(rs.getInt("id"));
                game.setJudgeLogin(rs.getString("judge_login"));
                game.setLoserTeam(rs.getString("loser_team_name"));
                game.setWinnerTeam(rs.getString("loser_team_name"));
                game.setDateTimeOfGame(getLocalDateTimeFromDB(rs,"local_date_time"));

        }catch (SQLException e){
            e.printStackTrace();
        }

        return game;
    }

    @Override
    public Player makeUnique(Map<Integer, Player> cache,
                             Player player) {
        cache.putIfAbsent(player.getID(), player);
        return cache.get(player.getID());
    }
    public  LocalDateTime getLocalDateTimeFromDB(ResultSet rs, String column)
            throws SQLException {
        String date = rs.getString(column);
        if (date != null) {
            return LocalDateTime.parse(date, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        } else {
            return null;
        }
    }
}
