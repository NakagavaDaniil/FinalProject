package model.dao;

import model.connection.ConnectionPoolHolder;
import model.entity.Player;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerDAO {

    private static PlayerDAO instance;
    private static Player user;
    public static PlayerDAO getInstance() {
        if (instance == null) {
            instance = new PlayerDAO();
        }
        return instance;
    }
    public Player getPlayer(String login) {
        user = null;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPoolHolder.getConnection();
            statement = connection.prepareStatement("SELECT tottal_pints,tottal_games,tottal_wins FROM player" +
                    " WHERE user_login=?");


            statement.setString(1,login);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                user.setTottalPointsCount(rs.getInt(1));
                user.setTottalGamesCount(rs.getInt(2));
                user.setTottalWinsCount(rs.getInt(3));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}
