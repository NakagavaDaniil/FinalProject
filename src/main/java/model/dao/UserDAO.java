package model.dao;

import model.connection.ConnectionPoolHolder;
import model.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDAO {

    private static UserDAO instance;
    private static User user;
    private Set<User> allUsers;

    private UserDAO() {
        allUsers = new HashSet<User>();
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            instance = new UserDAO();
        }
        return instance;
    }



    public User getUser(String login, String password) {
        User user = null;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPoolHolder.getConnection();
            statement = connection.prepareStatement("SELECT user_id,first_name, last_name, birth_date,email FROM users" +
                    " WHERE password = ? AND login = ?");

            statement.setString(1,password);
            statement.setString(2,login);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setID(rs.getInt(1));
                user.setUSER_FIRST_NAME(rs.getString(2));
                user.setUSER_LAST_NAME(rs.getString(3));
                user.setBIRTH_DATE(rs.getDate(4));
                user.setEMAIL(rs.getString(5));
                user.setUSER_LOGIN(login);
                user.setUSER_PASSWORD(password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getUserById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPoolHolder.getConnection();
        statement = connection.prepareStatement("SELECT user_id,first_name, last_name, birth_date,email,login,password FROM users" +
                " WHERE user_id = ?");

        statement.setInt(1,id);


        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setID(rs.getInt(1));
            user.setUSER_FIRST_NAME(rs.getString(2));
            user.setUSER_LAST_NAME(rs.getString(3));
            user.setBIRTH_DATE(rs.getDate(4));
            user.setEMAIL(rs.getString(5));
            user.setUSER_LOGIN(rs.getString(6));
            user.setUSER_PASSWORD(rs.getString(7));

        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return user;
    }
    public int addUser(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        int result = 0;

        try {
            connection = ConnectionPoolHolder.getConnection();
            statement = connection.prepareStatement("INSERT INTO users(first_name, last_name, birth_date,login,password,email) VALUES (?,?,?,?,?,?)");

            statement.setString(1, user.getUSER_FIRST_NAME());
            statement.setString(2, user.getUSER_LAST_NAME());
            statement.setDate(3, user.getBIRTH_DATE());
            statement.setString(4,user.getUSER_LOGIN());
            statement.setString(5,user.getUSER_PASSWORD());
            statement.setString(6,user.getEMAIL());


            result = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
