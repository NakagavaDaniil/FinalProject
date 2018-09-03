package model.dao.impl;
import model.dao.PlayerDAO;
import model.dao.mapper.PlayerMapper;
import model.entity.Game;
import model.entity.Player;
import model.entity.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class JDBCPlayerDAO implements PlayerDAO {
    private Connection connection;

    //TODO ALL
    JDBCPlayerDAO(Connection connection) {
        this.connection = connection;
    }



    @Override
    public Player findById(int id) {

        Player result=null;
        try (PreparedStatement ps = connection.prepareCall("SELECT tottal_games,tottal_wins, tottal_pints" +
                " FROM player Where id=?")) {
            ps.setInt(1, id);

            ResultSet rs;
            rs = ps.executeQuery();
            PlayerMapper mapper = new PlayerMapper();
            if (rs.next()) {
                result = mapper.extractFromResultSet(rs);
            }


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }



    @Override
    public void delete(int id) {

    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Game> getGameHistoy(List<Team> teamList) {
        return null;
    }

    @Override
    public List<Game> findLoses(List<String> teamList) {
        return null;
    }

    @Override
    public List<Game> findWins(List<String> teamList) {
        return null;
    }

    @Override
    public List<Game> findAllGames() {
        return null;
    }


    @Override
    public List<Game> findLoses(String teamName) {
        return null;
    }

    @Override
    public List<Game> findWins(String teamName) {
        return null;
    }

    @Override
    public List<Game> findAllGames(String teamName) {
        return null;
    }



}
