package hello_big;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MappersGnomeBig implements RowMapper<ValuesGnomeBig>{
    public ValuesGnomeBig mapRow(ResultSet resultSet, int i) throws SQLException {
        ValuesGnomeBig vg = new ValuesGnomeBig();
        vg.setGnome_name(resultSet.getString("gnome_name"));
        vg.setGnome_money(resultSet.getBigDecimal("gnome_money"));
        return vg;
    }

}
