package it.mankey.lps.domain;

import java.math.BigDecimal;

/**
 * User: xan
 * Date: 08/09/12 20:41
 */
public final class Quote {
    private final BigDecimal price;

    private Quote(final BigDecimal price) {
        this.price = price;
    }

    public static Quote create(final BigDecimal price) {
        return new Quote(price);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "price=" + price +
                '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Quote quote = (Quote) o;

        if (price != null ? !price.equals(quote.price) : quote.price != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return price != null ? price.hashCode() : 0;
    }
}
