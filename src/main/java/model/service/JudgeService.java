package model.service;

import model.dao.DaoFactory;
import model.dao.JudgeDAO;
import model.entity.Game;
import model.entity.Judge;
import model.entity.Question;
import model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class JudgeService implements JudgeDAO {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private JudgeDAO judgeDAO = daoFactory.createJudgeDao();


    public void add(String queston , String answear , ArrayList<String> variants) {
        Question question = new Question();

        question.setAnswear(answear);
        question.setQuestion(queston);
        question.setVariantsOfAnswear(variants);

        judgeDAO.createQuesion(question);

    }

    @Override
    public Judge findById(int id) {

        Judge judge;
        judge=judgeDAO.findById(id);
        return judge;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }

    @Override
    public void createQuesion(Question question) {
        judgeDAO.createQuesion(question);
    }

    @Override
    public List<Question> getUserQuest(int userId) {
        return judgeDAO.getUserQuest(userId);
    }


    public List<Question> getAllQuest() {
        return judgeDAO.getAllQuest();
    }

    @Override
    public List<Game> getHistory(String userLogin) {
        return judgeDAO.getHistory(userLogin);
    }
}
