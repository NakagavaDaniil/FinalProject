package model.dao.mapper;

import model.entity.Question;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class QuestionMapper implements ObjectMapper<Question> {
    @Override
    public Question extractFromResultSet(ResultSet rs) throws SQLException {
        Question question = new Question();
        question.setId(rs.getInt("id"));
        question.setQuestion(rs.getString("question"));
        question.setVariantsOfAnswear(splitAndAdd(rs.getString("anwer_variants")));
        question.setAnswear(rs.getString("answer"));
        question.setLanguage(rs.getString("locale"));

        return question;
    }

    private ArrayList<String> splitAndAdd(String list){
        String[] split = list.split(",");
        return new ArrayList<>(Arrays.asList(split));
    }
    @Override
    public Question makeUnique(Map<Integer, Question> cache, Question user) {
        return null;
    }
}
