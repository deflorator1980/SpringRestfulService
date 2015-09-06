package db;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ValueMapperGnome implements RowMapper<ValueGnome>{
    public ValueGnome mapRow(ResultSet rs, int rowNum) throws SQLException{
        ValueGnome valueGnome = new ValueGnome();
        valueGnome.setGnome_id(rs.getString("gnome_id"));
        valueGnome.setGnome_name(rs.getString("gnome_name"));
        valueGnome.setGnome_money(rs.getInt("gnome_money"));
        return valueGnome;
    }

}
