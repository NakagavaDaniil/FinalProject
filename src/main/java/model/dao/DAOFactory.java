package model.dao;

import model.entity.Player;

public class DAOFactory {
    private static DAOFactory factory;

    private DAOFactory() {
    }

    public static synchronized DAOFactory getInstance() {
        if (factory == null) {
            factory = new DAOFactory();
        }
        return factory;
    }
    public UserDAO getUserDAO() {
        return UserDAO.getInstance();
    }
    public PlayerDAO getPlayerDAO(){return PlayerDAO.getInstance();}


}
