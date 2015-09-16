package db_spring;

import hello.Buy;
import hello.MapperMoney;
import hello.Money;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by deflo_000 on 07-Sep-15.
 */
public class Templates {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private PlatformTransactionManager transactionManager;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public List<Values> showValues(){
        String sql = "select gnomes.gnome_name, gnomes.gnome_money, items.item_name, sales.quantity from gnomes, items, sales where gnomes.gnome_id = sales.gnome_id and sales.item_id = items.item_id;";
        return jdbcTemplate.query(sql, new Mappers());
    }

    public Values showGnome(String gnome_id){
        String sql = "select gnomes.gnome_name, gnomes.gnome_money, items.item_name, sales.quantity from gnomes, items, sales where gnomes.gnome_id = sales.gnome_id and sales.item_id = items.item_id and gnomes.gnome_id = ?;";
        return jdbcTemplate.queryForObject(sql, new Object[]{gnome_id}, new Mappers());
    }

    public List<Values> showGnome2(String gnome_id){
        String sql = "select gnomes.gnome_name, gnomes.gnome_money, items.item_name, sales.quantity from gnomes, items, sales where gnomes.gnome_id = sales.gnome_id and sales.item_id = items.item_id and gnomes.gnome_id = " + gnome_id;
        return jdbcTemplate.query(sql, new Mappers());
    }

    public ValuesGnome showValuesGnome(String gnome_id){
        String sql = "select gnome_name, gnome_money from gnomes where gnome_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{gnome_id}, new MappersGnome());
    }

    public List<ValuesItem> showValuesItem(String gnome_id){
        String sql = "select items.item_name, sales.quantity from gnomes, items, sales where gnomes.gnome_id = sales.gnome_id  and sales.item_id = items.item_id and gnomes.gnome_id =" + gnome_id;
        return jdbcTemplate.query(sql, new MappersItem());
    }


    public void buyItemNew(String gnome_id, String item_id){
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            String sqlGiveMoney = "UPDATE gnomes SET gnome_money=gnome_money-5 WHERE gnome_id=001";
            jdbcTemplate.update(sqlGiveMoney);

            String sqlGetItem = "insert into sales (gnome_id, item_id, quantity) values (?, ?, 2);";
            jdbcTemplate.update(sqlGetItem, gnome_id, item_id);

            transactionManager.commit(status);
        }catch (DataAccessException dae){
            transactionManager.rollback(status);
        }

    }

    public Money getMoney(String gnome_id){
        String sql = "SELECT gnome_money FROM gnomes WHERE gnome_id = ?";
        return (Money) jdbcTemplate.queryForObject(sql, new Object[]{gnome_id}, new MapperMoney());
    }


}
