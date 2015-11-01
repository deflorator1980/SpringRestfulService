package hello_big;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MappersBig implements RowMapper<ValuesBig> {
    public ValuesBig mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        ValuesBig values = new ValuesBig();
        values.setGnome_name(resultSet.getString("gnome_name"));
        values.setGnome_money(resultSet.getString("gnome_money"));
        values.setItem_name(resultSet.getString("item_name"));
        values.setQuatity(resultSet.getInt("quantity"));
        return values;
    }
}
