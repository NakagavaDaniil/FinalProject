package model.dao.impl;

import model.dao.JudgeDAO;
import model.dao.mapper.JudgeMapper;
import model.dao.mapper.QuestionMapper;
import model.dao.mapper.TeamMapper;
import model.entity.Game;
import model.entity.Judge;
import model.entity.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCJudgeDAO implements JudgeDAO {

    private Connection connection;

    JDBCJudgeDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Judge findById(int id) {
        Judge judge = new Judge();
        try (PreparedStatement ps = connection.prepareCall("select * from judge where id=?")){
            ps.setInt(1,id);

            ResultSet rs;
            rs = ps.executeQuery();
            JudgeMapper judgeMapper = new JudgeMapper();
            if(rs.next()){
            judge= judgeMapper.extractFromResultSet(rs);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return judge;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Question> getUserQuest(int userId){
        List<Question> result=new ArrayList<>();
        try (PreparedStatement ps = connection.prepareCall("select * from  questtion_judge join questions " +
                "on questtion_judge.id_question = questions.id where id_judge=?")) {
            ps.setInt(1, userId);

            ResultSet rs;
            rs = ps.executeQuery();
            QuestionMapper mapper = new QuestionMapper();
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    result.add(mapper.extractFromResultSet(rs));
                }
            }

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public void createQuesion(Question question)  {


        PreparedStatement ps = null;
        try { connection.setAutoCommit(false); //transaction block start

            String insertTableSQL = "INSERT INTO questions"
                    + "(question, locale,answer,anwer_variants) VALUES"
                    + "(?,?,?,?)";

           ps = connection.prepareStatement(insertTableSQL);
           ps.setString(1,question.getQuestion());
           ps.setString(2, String.valueOf(question.getLanguage()));
           ps.setString(3,question.getAnswear());
           ps.setString(4, String.valueOf(question.getVariantsOfAnswear()));
            ps.execute();
           connection.commit();

        }catch (SQLException e){
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public List<Question> getAllQuest(){
        List<Question> result=new ArrayList<>();
        try (PreparedStatement ps = connection.prepareCall("select * from  questions")) {

            ResultSet rs;
            rs = ps.executeQuery();
            QuestionMapper mapper = new QuestionMapper();
            if (rs.next()) {
                rs.beforeFirst();
                while (rs.next()) {
                    result.add(mapper.extractFromResultSet(rs));
                }
            }


        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }

    @Override
    public  List<Game> getHistory(String userLogin) {
        List<Game> result = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareCall("SELECT * from gamehistory where judge_login=?")){

            ps.setString(1, userLogin);

            ResultSet rs= ps.executeQuery();
            TeamMapper mapper = new TeamMapper();


            if (rs.next()) {
                //back iterator to 0 position
                rs.beforeFirst();
                while (rs.next()){

                    result.add(mapper.extractFromResultSetGame(rs));

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return result;
    }

}
