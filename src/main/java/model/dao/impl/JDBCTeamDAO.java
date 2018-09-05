package model.dao.impl;

import model.dao.TeamDAO;
import model.dao.mapper.TeamMapper;
import model.entity.Game;
import model.entity.Team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTeamDAO implements TeamDAO {
    private Connection connection;

    JDBCTeamDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Team> findAllTeams() {
        List<Team> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareCall("SELECT *" +
                " FROM teamname")) {

            ResultSet rs;
            rs = ps.executeQuery();
           TeamMapper mapper = new TeamMapper();

            if (rs.next()) {
                //back iterator to 0 position
                rs.beforeFirst();
                while (rs.next()){

                    result.add(mapper.extractFromResultSet(rs));

                }
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;

    }

    @Override
    public Team findTeam(String teamName) {
        Team team = null;
        try(PreparedStatement ps = connection.prepareCall("SELECT *" +
                " FROM teamname where team_name = ?")) {
            ps.setString(1,teamName);
            ResultSet rs;
            rs = ps.executeQuery();
           TeamMapper mapper = new TeamMapper();

            if (rs.next()) {
                team  = mapper.extractFromResultSet(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return team;
    }

    @Override
    public List<Team> getMyTeams(int id) {

        List<Team> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareCall("SELECT id, team_name,tottal_games,tottal_wins FROM teamname LEFT JOIN team_player tp on teamname.id = tp.team_id  WHERE player_id =?")) {
            ps.setInt(1,id);
            ResultSet rs;
            rs = ps.executeQuery();
           TeamMapper mapper = new TeamMapper();

            if (rs.next()) {
                //back iterator to 0 position
                rs.beforeFirst();
                while (rs.next()){

                        result.add(mapper.extractFromResultSet(rs));

                }

            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public Team create(Team entity) {

        try (PreparedStatement ps = connection.prepareCall("INSERT INTO teamname(team_name, tottal_wins, tottal_games) VALUES (?,?,?)")){

            ps.setString(1, entity.getName());
            ps.setInt(2,0);
            ps.setInt(3,0);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return entity;
    }

    @Override
    public List<Game> getTeamHistory(String name) {
        List<Game> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareCall("SELECT * from gamehistory where winner_team_name=? or loser_team_name=?")){

            ps.setString(1, name);
            ps.setString(2, name);
            ResultSet rs= ps.executeQuery();
            TeamMapper mapper = new TeamMapper();


            if (rs.next()) {
                //back iterator to 0 position
                rs.beforeFirst();
                while (rs.next()){

                    result.add(mapper.extractFromResultSetGame(rs));

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;
    }

    @Override
    public List<String> getTeamPlayers(int id) {

        List<String> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareCall("SELECT user_login from team_player join player p on team_player.player_id = p.id where team_id=?;")) {
            ps.setInt(1,id);
            ResultSet rs;
            rs = ps.executeQuery();

            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()){
                result.add(rs.getString(1));
                }

            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;


    }


    @Override
    public void joinTeam(int id, int teamId) {
        try (PreparedStatement ps = connection.prepareCall("INSERT INTO projectdb.team_player (player_id, team_id) VALUES (?, ?)")) {
            ps.setInt(1, id);
            ps.setInt(2,teamId);
             ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Team findById(int id) {
        Team team = null;
        try(PreparedStatement ps = connection.prepareCall("SELECT *" +
                " FROM teamname where id = ?")) {
            ps.setInt(1,id);
            ResultSet rs;
            rs = ps.executeQuery();
            TeamMapper mapper = new TeamMapper();

            if (rs.next()) {
                team  = mapper.extractFromResultSet(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return team;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
