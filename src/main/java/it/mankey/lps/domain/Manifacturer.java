package it.mankey.lps.domain;

import org.apache.commons.lang.StringUtils;

/**
 * @since 08-09-2012 10:10
 */
public final class Manifacturer {
    private final String name;

    private Manifacturer(final String name) {
        this.name = name;
    }

    public static Manifacturer create(final String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("'name' can't be blank");
        }
        return new Manifacturer(name);
    }

    @Override
    public String toString() {
        return "Manifacturer{" +
                "name='" + name + '\'' +
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

        final Manifacturer that = (Manifacturer) o;

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
