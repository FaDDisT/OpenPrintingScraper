package it.mankey.lps.domain;

import java.math.BigDecimal;

/**
 * User: xan
 * Date: 08/09/12 20:41
 */
public class Quote {
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
}
