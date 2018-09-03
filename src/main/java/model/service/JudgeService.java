package model.service;

import model.dao.DaoFactory;
import model.dao.JudgeDAO;
import model.entity.Judge;

public class JudgeService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private JudgeDAO judgeDAO = daoFactory.createJudgeDao();

    public Judge getById(int id){
        Judge judge;
        judge=judgeDAO.findById(id);
        return judge;
    }
}
