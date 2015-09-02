package hello;

/**
 * Created by deflo_000 on 02-Sep-15.
 */
public class Retriever {
    private String item;
    private int price;

    public Retriever(String item, int price) {
        this.item = item;
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public int getPrice() {
        return price;
    }
}
