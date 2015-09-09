package db_spring;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by deflo_000 on 09-Sep-15.
 */
public class MappersGnome implements RowMapper<ValuesGnome>{

    @Override
    public ValuesGnome mapRow(ResultSet resultSet, int i) throws SQLException {
        ValuesGnome vg = new ValuesGnome();
        vg.setGnome_name(resultSet.getString("gnome_name"));
        vg.setGnome_money(resultSet.getInt("gnome_money"));
        return vg;
    }
}
