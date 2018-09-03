package model.dao.mapper;

import model.entity.Judge;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class JudgeMapper implements ObjectMapper<Judge> {
    @Override
    public Judge extractFromResultSet(ResultSet rs) throws SQLException {
        Judge judge = new Judge();
        judge.setTottalGamesCount(rs.getInt("number_of_games"));
        judge.setTottalHintsGivenCount(rs.getInt("tottal_hints_given"));
        return judge;
    }

    @Override
    public Judge makeUnique(Map<Integer, Judge> cache, Judge user) {
        return null;
    }
}
