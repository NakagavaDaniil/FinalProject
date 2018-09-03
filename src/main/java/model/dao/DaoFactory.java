package model.dao;


import model.dao.impl.JDBCDaoFactory;

import java.sql.SQLException;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDAO createUserDao();
    public abstract PlayerDAO createPlayerDao();
    public abstract JudgeDAO createJudgeDao();
    public abstract TeamDAO createTeamDao();


    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    daoFactory = new JDBCDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
