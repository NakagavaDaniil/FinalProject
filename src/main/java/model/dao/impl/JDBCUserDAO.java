package model.dao.impl;

import model.connection.ConnectionPoolHolder;
import model.dao.UserDAO;
import model.dao.mapper.UserMapper;
import model.entity.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class JDBCUserDAO implements UserDAO {
    private Connection connection;


    public JDBCUserDAO(Connection connection) {
        this.connection = connection;
    }


    @Override
    public boolean create(User entity) {


        try (PreparedStatement ps = connection.prepareCall("INSERT INTO users(first_name, last_name, birth_date,login,password,email) VALUES (?,?,?,?,?,?)")){

            ps.setString(1, entity.getUSER_FIRST_NAME());
            ps.setString(2, entity.getUSER_LAST_NAME());
            ps.setDate(3, entity.getBIRTH_DATE());
            ps.setString(4,entity.getUSER_LOGIN());
            ps.setString(5,entity.getUSER_PASSWORD());
            ps.setString(6,entity.getEMAIL());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

return true;
    }

    @Override
    public User findById(int id) {

       User result=null;
        try (PreparedStatement ps = connection.prepareCall("SELECT user_id,first_name, last_name, birth_date,email,login,password" +
                " FROM users Where user_id=?")) {
            ps.setInt(1, id);

            ResultSet rs;
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if (rs.next()) {
                result = mapper.extractFromResultSet(rs);
            }


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }


    @Override
    public boolean update(User entity) {
return true;
    }

    @Override
    public Optional<User> getUser(String name, String password) {

        Optional<User> result = Optional.empty();
        try (PreparedStatement ps = connection.prepareCall("SELECT user_id,first_name, last_name, birth_date,email,login,password" +
                " FROM users Where password = ? AND login = ?")) {
            ps.setString(2, name);
            ps.setString(1, password);
            ResultSet rs;
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if (rs.next()) {
                result = Optional.of(mapper.extractFromResultSet(rs));
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
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}