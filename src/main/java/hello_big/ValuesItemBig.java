package hello_big;


public class ValuesItemBig {
    private String item_name;
    private int quantity;

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    @Override
    public String toString() {
        return "ValuesItemBig{" +
                "item_name='" + item_name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValuesItemBig that = (ValuesItemBig) o;

        return quantity==that.quantity && !(item_name != null ? !item_name.equals(that.item_name) : that.item_name != null);
    }

    @Override
    public int hashCode() {
        int result = item_name != null ? item_name.hashCode() : 0;
        result = 31 * result + quantity;
        return result;
    }
}
