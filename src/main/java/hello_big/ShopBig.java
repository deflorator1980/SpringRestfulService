package hello_big;

import java.math.BigDecimal;


public class ShopBig {
    private String id;
    private String name;
    private BigDecimal price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShopBig{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ShopBig)){
            return false;
        }
        ShopBig that = (ShopBig) obj;
        return this.id.equals(that.id)
                && this.name.equals(that.name)
                && this.price.equals(that.price);

    }
}
