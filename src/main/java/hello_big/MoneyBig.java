package hello_big;


import java.math.BigDecimal;

public class MoneyBig {
   private BigDecimal rubles;

    public BigDecimal getRubles() {
        return rubles;
    }

    public void setRubles(BigDecimal rubles) {
        this.rubles = rubles;
    }

    @Override
    public String toString() {
        return "MoneyBig{" +
                "rubles=" + rubles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoneyBig moneyBig = (MoneyBig) o;

        return !(rubles != null ? !rubles.equals(moneyBig.rubles) : moneyBig.rubles != null);

    }

    @Override
    public int hashCode() {
        return rubles != null ? rubles.hashCode() : 0;
    }
}
