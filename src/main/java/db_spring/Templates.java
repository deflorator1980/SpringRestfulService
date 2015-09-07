package db_spring;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by deflo_000 on 07-Sep-15.
 */
public class Templates {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Values> showValues(){
        String sql = "select gnomes.gnome_name, gnomes.gnome_money, items.item_name, sales.quantity from gnomes, items, sales where gnomes.gnome_id = sales.gnome_id and sales.item_id = items.item_id;";
        return jdbcTemplate.query(sql, new Mappers());
    }
}
