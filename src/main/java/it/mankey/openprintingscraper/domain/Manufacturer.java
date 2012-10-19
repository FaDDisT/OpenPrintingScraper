package it.mankey.openprintingscraper.domain;

import static org.apache.commons.lang.StringUtils.isBlank;

/**
 * @since 08-09-2012 10:10
 */
public final class Manufacturer extends AbstractDomainClass {
    private final String name;

    private Manufacturer(final String name) {
        this.name = name;
    }

    public static Manufacturer create(final String name) {
        if (!canCreate(name)) {
            throw new IllegalArgumentException("'name' can't be blank");
        }
        return new Manufacturer(name);
    }

    public static boolean canCreate(final String name) {
        return !isBlank(name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Manufacturer that = (Manufacturer) o;

        if (!name.equals(that.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }
}
