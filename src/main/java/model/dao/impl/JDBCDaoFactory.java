package model.dao.impl;



import model.connection.ConnectionPoolHolder;
import model.dao.DaoFactory;
import model.dao.PlayerDAO;
import model.dao.UserDAO;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    public JDBCDaoFactory() throws SQLException {    }

//    private Connection getConnection(){ return connection;    }

    @Override
    public UserDAO createUserDao() {
        return new JDBCUserDAO(getConnection());
    }

    @Override
    public PlayerDAO createPlayerDao() {
        return new JDBCPlayerDAO(getConnection());
    }


    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
