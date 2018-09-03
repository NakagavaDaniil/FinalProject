package model.dao.impl;



import model.connection.ConnectionPoolHolder;
import model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPoolHolder.getDataSource();

    public JDBCDaoFactory() {    }



    @Override
    public UserDAO createUserDao() {
        return new JDBCUserDAO(getConnection());
    }

    @Override
    public PlayerDAO createPlayerDao() {
        return new JDBCPlayerDAO(getConnection());
    }

    @Override
    public JudgeDAO createJudgeDao() {
        return new JDBCJudgeDAO(getConnection());
    }

    @Override
    public TeamDAO createTeamDao() {
        return new JDBCTeamDAO(getConnection());
    }


    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
