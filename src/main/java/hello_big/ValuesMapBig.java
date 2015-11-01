package hello_big;

import java.math.BigDecimal;
import java.util.HashMap;


public class ValuesMapBig {
    private String gnome_name;
    private BigDecimal gnome_money;
    private HashMap<String, Integer> items;

    public String getGnome_name() {
        return gnome_name;
    }

    public void setGnome_name(String gnome_name) {
        this.gnome_name = gnome_name;
    }

    public BigDecimal getGnome_money() {
        return gnome_money;
    }

    public void setGnome_money(BigDecimal gnome_money) {
        this.gnome_money = gnome_money;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }
}
