package model.dao.impl;

import model.dao.TeamDAO;
import model.dao.mapper.TeamMapper;
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
    public Team findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
