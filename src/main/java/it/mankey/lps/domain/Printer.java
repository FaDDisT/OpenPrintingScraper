package it.mankey.lps.domain;

/**
 * @since 08-09-2012 20:12
 */
public class Printer {
    public final String model;
    public final Manifacturer manifacturer;

    private Printer(final Manifacturer manifacturer, final String model) {
        this.manifacturer = manifacturer;
        this.model = model;
    }

    public static Printer create(final Manifacturer manifacturer, final String model) {
        return new Printer(manifacturer, model);
    }

    @Override
    public String toString() {
        return "Printer{" +
                manifacturer +
                ", model='" + model + '\'' +
                '}';
    }
}
