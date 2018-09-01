package model.service;

import model.dao.DaoFactory;
import model.dao.UserDAO;
import model.entity.User;

import java.util.Optional;

public class UserService {
    DaoFactory daoFactory = DaoFactory.getInstance();
    UserDAO userDao = daoFactory.createUserDao();

    public Optional<User> login(String name, String password){
        Optional<User> result; //= Optional.empty();

            result = userDao.getUser(name,password);

        return result;
    }

    public User getById(int id){
        User user;
            user=userDao.findById(id);
        System.out.println(user);
        return user;
    }

    public boolean register(User entity){

        UserDAO userDAO = daoFactory.createUserDao();
         return   userDAO.create(entity);

    }
}
