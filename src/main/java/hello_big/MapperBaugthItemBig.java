package hello_big;

import hello.BaughtItem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperBaugthItemBig implements RowMapper{
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        BaughtItem bi = new BaughtItem();
        bi.setItem(resultSet.getString("item_id"));
        bi.setQuantity(resultSet.getInt("quantity"));
        return bi;
    }
}
