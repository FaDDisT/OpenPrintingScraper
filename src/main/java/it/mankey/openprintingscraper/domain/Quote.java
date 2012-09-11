package it.mankey.openprintingscraper.domain;

import java.math.BigDecimal;

/**
 * User: xan
 * Date: 08/09/12 20:41
 */
public final class Quote extends AbstractDomainClass {
    private final BigDecimal price;

    private Quote(final BigDecimal price) {
        this.price = price;
    }

    public static boolean canCreate(final BigDecimal price) {
        return price != null;
    }

    public static Quote create(final BigDecimal price) {
        if (!canCreate(price)) {
            throw new IllegalArgumentException("Price can't be null");
        }
        return new Quote(price);
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

    public BigDecimal getPrice() {
        return price;
    }
}
