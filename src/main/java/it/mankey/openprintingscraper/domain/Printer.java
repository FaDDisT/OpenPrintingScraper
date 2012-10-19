package it.mankey.openprintingscraper.domain;

import org.apache.commons.lang.StringUtils;

/**
 * @since 08-09-2012 20:12
 */
public final class Printer extends AbstractDomainClass {
    private final String model;
    private final Manufacturer manufacturer;
    private static final int PRIME_NUMBER = 31;

    private Printer(final Manufacturer manufacturer, final String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public static boolean canCreate(final Manufacturer manufacturer, final String model) {
        return (manufacturer != null) && !StringUtils.isBlank(model);
    }

    public static Printer create(final Manufacturer manufacturer, final String model) {
        if (!canCreate(manufacturer, model)) {
            throw new IllegalArgumentException("Invalid parameters. Manifacturer can't be null and model can't be empty");
        }
        return new Printer(manufacturer, model);
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

        if (manufacturer != null ? !manufacturer.equals(printer.manufacturer) : printer.manufacturer != null) {
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
        result = PRIME_NUMBER * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        return result;
    }

    public String getModel() {
        return model;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }
}
