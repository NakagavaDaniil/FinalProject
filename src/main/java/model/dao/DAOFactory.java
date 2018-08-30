package model.dao;


import model.dao.impl.JDBCDaoFactory;

import java.sql.SQLException;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDAO createUserDao();
    public abstract PlayerDAO createPlayerDao();


    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = null;
                    try {
                        temp = new JDBCDaoFactory();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
