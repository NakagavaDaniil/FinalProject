package model.dao;

import model.entity.Game;
import model.entity.Judge;
import model.entity.Question;

import java.util.List;

public interface JudgeDAO extends GenericDao<Judge>{
    void createQuesion(Question question);

    List<Question> getUserQuest(int userId);
    List<Question> getAllQuest();

    List<Game> getHistory(String userId);

}
