package hello_big;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MappersItemBig implements RowMapper<ValuesItemBig> {
    public ValuesItemBig mapRow(ResultSet resultSet, int i) throws SQLException {
        ValuesItemBig vi = new ValuesItemBig();
        vi.setItem_name(resultSet.getString("item_name"));
        vi.setQuantity(resultSet.getInt("quantity"));
        return vi;
    }

}
