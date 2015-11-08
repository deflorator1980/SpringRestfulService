package hello_big;

import java.math.BigDecimal;


public class ValuesGnomeBig {
    private String gnome_name;
    private BigDecimal gnome_money;

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

    @Override
    public String toString() {
        return "ValuesGnomeBig{" +
                "gnome_name='" + gnome_name + '\'' +
                ", gnome_money=" + gnome_money +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValuesGnomeBig that = (ValuesGnomeBig) o;

        return !(gnome_name != null ? !gnome_name.equals(that.gnome_name) : that.gnome_name != null)
                && !(gnome_money != null ? !gnome_money.equals(that.gnome_money) : that.gnome_money != null);
    }

    @Override
    public int hashCode() {
        int result = gnome_name != null ? gnome_name.hashCode() : 0;
        result = 31 * result + (gnome_money != null ? gnome_money.hashCode() : 0);
        return result;
    }
}
