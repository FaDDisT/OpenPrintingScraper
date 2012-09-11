package it.mankey.openprintingscraper.domain;

import org.apache.commons.lang.StringUtils;

/**
 * @since 08-09-2012 20:12
 */
public final class Printer extends AbstractDomainClass {
    private final String model;
    private final Manifacturer manifacturer;
    private static final int PRIME_NUMBER = 31;

    private Printer(final Manifacturer manifacturer, final String model) {
        this.manifacturer = manifacturer;
        this.model = model;
    }

    public static boolean canCreate(final Manifacturer manifacturer, final String model) {
        return (manifacturer != null) && !StringUtils.isBlank(model);
    }

    public static Printer create(final Manifacturer manifacturer, final String model) {
        if (!canCreate(manifacturer, model)) {
            throw new IllegalArgumentException("Invalid parameters. Manifacturer can't be null and model can't be empty");
        }
        return new Printer(manifacturer, model);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Printer printer = (Printer) o;

        if (manifacturer != null ? !manifacturer.equals(printer.manifacturer) : printer.manifacturer != null) {
            return false;
        }
        if (model != null ? !model.equals(printer.model) : printer.model != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = PRIME_NUMBER * result + (manifacturer != null ? manifacturer.hashCode() : 0);
        return result;
    }

    public String getModel() {
        return model;
    }

    public Manifacturer getManifacturer() {
        return manifacturer;
    }
}
