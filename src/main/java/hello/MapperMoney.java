package hello;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MapperMoney implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
//        money.setRubles(resultSet.getInt("gnome_money"));
        Money money = new Money();
        money.setRubles(resultSet.getInt("gnome_money"));
        return money;

    }
}
