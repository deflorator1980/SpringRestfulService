package hello;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperBaughtItem implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        BaughtItem bi = new BaughtItem();
        bi.setItem(resultSet.getString("item_id"));
        return bi;
    }
}
