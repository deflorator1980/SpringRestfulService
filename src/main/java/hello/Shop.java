package hello;

/**
 * Created by a on 15.10.15.
 */
public class Shop {
    String item_name;
    int item_price;

    public Shop(String item_name, int item_price) {
        this.item_name = item_name;
        this.item_price = item_price;
    }

    public String getItem_name() {
        return item_name;
    }

    public int getItem_price() {
        return item_price;
    }
}
