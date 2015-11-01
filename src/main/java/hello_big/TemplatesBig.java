package hello_big;

import hello.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by a on 01.11.15.
 */
public class TemplatesBig {
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

    public ValuesGnomeBig showValuesGnome(String gnome_id) {
        String sql = "select gnome_name, gnome_money from gnomes where gnome_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{gnome_id}, new MappersGnome());
    }

    public List<ValuesItem> showValuesItem(String gnome_id) {
        String sql = "select items.item_name, sales.quantity from gnomes, items, sales where" +
                " gnomes.gnome_id = sales.gnome_id  and sales.item_id = items.item_id and gnomes.gnome_id =?";
        return jdbcTemplate.query(sql, new MappersItem(), gnome_id);
    }


    public void buyItemNew(String gnome_id, String item_id, int itemPrice) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {

            String sqlGiveMoney = "UPDATE gnomes SET gnome_money=gnome_money-? WHERE gnome_id=?";
            jdbcTemplate.update(sqlGiveMoney, itemPrice, gnome_id);

            String sqlGetItem = "insert into sales (gnome_id, item_id, quantity) values (?, ?, 1);";
            jdbcTemplate.update(sqlGetItem, gnome_id, item_id);

            transactionManager.commit(status);

        } catch (DataAccessException dae) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw dae;
        }

    }

    public Money getMoney(String gnome_id) {
        String sql = "SELECT gnome_money FROM gnomes WHERE gnome_id = ?";
        return (Money) jdbcTemplate.queryForObject(sql, new Object[]{gnome_id}, new MapperMoney());
    }

    public List<BaughtItem> getBaughtItem(String gnome_id) {
        String sql = "select item_id, quantity from sales where gnome_id=?";
        return jdbcTemplate.query(sql, new MapperBaughtItem(), gnome_id);
    }

    public void buyItemOld(String gnome_id, String item_id, int itemPrice) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            String sqlIncQuantity = "update sales set quantity=quantity+1 where gnome_id=?"
                    + " and item_id=?";
            jdbcTemplate.update(sqlIncQuantity, gnome_id, item_id);

            String sqlGiveMoney = "UPDATE gnomes SET gnome_money=gnome_money-?"
                    + " WHERE gnome_id=?";
            jdbcTemplate.update(sqlGiveMoney, itemPrice, gnome_id);

            transactionManager.commit(status);

        } catch (DataAccessException dae) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw dae;
        }
    }

    public void sellItemLast(String gnome_id, String item_id, int itemPrice) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            String sqlTakeMoney = "update gnomes set gnome_money=gnome_money+?"
                    + " where gnome_id=?";
            jdbcTemplate.update(sqlTakeMoney, itemPrice, gnome_id);

            String sqlDeleteSales = "delete from sales where item_id=? and gnome_id=?";
            jdbcTemplate.update(sqlDeleteSales, item_id, gnome_id);

            transactionManager.commit(status);


        }catch (DataAccessException dae){
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw dae;
        }
    }

    public void sellItemOld(String gnome_id, String item_id, int itemPrice) {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);

        try {
            String sqlDecQuantity = "update sales set quantity=quantity-1 where gnome_id=?"
                    + " and item_id=?";
            jdbcTemplate.update(sqlDecQuantity, gnome_id, item_id);

            String sqlTakeMoney = "update gnomes set gnome_money=gnome_money+?"
                    + " where gnome_id=?";
            jdbcTemplate.update(sqlTakeMoney, itemPrice, gnome_id);

            transactionManager.commit(status);

        } catch (DataAccessException dae) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw dae;
        }
    }

}
