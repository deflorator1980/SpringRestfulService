package hello_big;


public class BuyBig {
    String item_name;
    String error_code;

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    @Override
    public String toString() {
        return "BuyBig{" +
                "item_name='" + item_name + '\'' +
                ", error_code='" + error_code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BuyBig buyBig = (BuyBig) o;

        return !(item_name != null ? !item_name.equals(buyBig.item_name) : buyBig.item_name != null)
                && !(error_code != null ? !error_code.equals(buyBig.error_code) : buyBig.error_code != null);
    }

    @Override
    public int hashCode() {
        int result = item_name != null ? item_name.hashCode() : 0;
        result = 31 * result + (error_code != null ? error_code.hashCode() : 0);
        return result;
    }
}
