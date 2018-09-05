package model.dao;




public interface GenericDao<T> extends AutoCloseable {

    T findById(int id);
    void delete(int id);
    void close();
}
