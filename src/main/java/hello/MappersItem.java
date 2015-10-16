package hello;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class MappersItem implements RowMapper<ValuesItem> {
    @Override
    public ValuesItem mapRow(ResultSet resultSet, int i) throws SQLException {
        ValuesItem vi = new ValuesItem();
        vi.setItem_name(resultSet.getString("item_name"));
        vi.setQuantity(resultSet.getInt("quantity"));
        return vi;
    }
}
