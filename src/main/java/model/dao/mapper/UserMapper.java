package model.dao.mapper;

import model.entity.User;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;


public class UserMapper implements ObjectMapper<User> {

    @Override
    public User extractFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setID(rs.getInt("user_id"));
        user.setUSER_FIRST_NAME(rs.getString("first_name"));
        user.setUSER_LAST_NAME(rs.getString("last_name"));
        user.setBIRTH_DATE(rs.getDate("birth_date"));
        user.setEMAIL(rs.getString("email"));
        user.setUSER_LOGIN(rs.getString("login"));
        user.setUSER_PASSWORD(rs.getString("password"));

        return user;
    }

    public User makeUnique(Map<Integer, User> cache,
                           User user) {
        cache.putIfAbsent(user.getID(), user);
        return cache.get(user.getID());
    }
}
