package db_spring;

import java.util.HashMap;


public class ValuesMap {
    private String gnome_name;
    private int gnome_money;
    private HashMap<String, Integer> items;

    public String getGnome_name() {
        return gnome_name;
    }

    public void setGnome_name(String gnome_name) {
        this.gnome_name = gnome_name;
    }

    public int getGnome_money() {
        return gnome_money;
    }

    public void setGnome_money(int gnome_money) {
        this.gnome_money = gnome_money;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }


}
