package db;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class ValueGnomeTemplate {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<ValueGnome> listValues(){
        String sql = "select * from gnomes";
        return jdbcTemplate.query(sql, new ValueMapperGnome());
    }
}
