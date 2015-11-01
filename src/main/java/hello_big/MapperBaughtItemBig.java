package hello_big;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperBaughtItemBig implements RowMapper{
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        BaughtItemBig bi = new BaughtItemBig();
        bi.setItem(resultSet.getString("item_id"));
        bi.setQuantity(resultSet.getInt("quantity"));
        return bi;
    }
}
