package db_spring;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mappers implements RowMapper<Values> {

    public Values mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Values values = new Values();
        values.setGnome_name(resultSet.getString("gnome_name"));
        values.setGnome_money(resultSet.getString("gnome_money"));
        values.setItem_name(resultSet.getString("item_name"));
        values.setQuatity(resultSet.getInt("quantity"));
        return values;
    }
}
