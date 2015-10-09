package hello;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperBaughtItem implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        BaughtItem il = new BaughtItem();
        il.setItem(resultSet.getString("item_id"));
        return il;
    }
}
