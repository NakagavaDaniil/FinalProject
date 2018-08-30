package model.dao;

import model.entity.User;

import java.util.Optional;


public interface UserDAO extends GenericDao<User> {
    boolean create(User entity);

    boolean update(User entity);

    Optional<User> getUser(String name, String password );
}
