package hello;

import java.util.HashMap;
import java.util.List;

/**
 * Created by deflo_000 on 09-Sep-15.
 */
public class RetrieverMap {
    private String name;
    private String money;
    private HashMap<String, Integer> itemsFull;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public HashMap<String, Integer> getItemsFull() {
        return itemsFull;
    }

    public void setItemsFull(HashMap<String, Integer> itemsFull) {
        this.itemsFull = itemsFull;
    }
}
