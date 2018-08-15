package model.service;

import model.connection.ConnectionPoolHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOService {

    public boolean checkWithDB(String data , String rowName) {
        try {


            final String SELECT_USER_BY_EMAIL = "SELECT * FROM users WHERE " +rowName+ " = ?";
            PreparedStatement statement = ConnectionPoolHolder.getConnection().prepareStatement(SELECT_USER_BY_EMAIL);
            statement.setString(1, data);
            ResultSet rs = statement.executeQuery();

            return rs.next();
        }catch (Exception e){
            e.printStackTrace();
            ///TODO logger
        }
        return false;
    }



}
