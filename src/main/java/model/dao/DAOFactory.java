package model.dao;

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

}
