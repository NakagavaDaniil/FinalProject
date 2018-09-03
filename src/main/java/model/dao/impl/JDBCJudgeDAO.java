package model.dao.impl;

import model.dao.JudgeDAO;
import model.entity.Judge;

import java.sql.Connection;

public class JDBCJudgeDAO implements JudgeDAO {

    private Connection connection;

    JDBCJudgeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Judge findById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
    // TODO all
}
