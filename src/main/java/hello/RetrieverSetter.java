package hello;

/**
 * Created by deflo_000 on 08-Sep-15.
 */
public class RetrieverSetter {
    private String item;
    private int price;
    private String name;

//    public RetrieverSetter(String item, int price) {
//        this.item = item;
//        this.price = price;
//    }


    public void setItem(String item) {
        this.item = item;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getItem() {
        return item;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }
}
