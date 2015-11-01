package hello_big;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperMoneyBig implements RowMapper{
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        MoneyBig money = new MoneyBig();
        money.setRubles(resultSet.getBigDecimal("gnome_money"));
        return money;
    }
}
