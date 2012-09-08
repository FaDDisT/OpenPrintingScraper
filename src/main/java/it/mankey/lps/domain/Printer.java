package it.mankey.lps.domain;

/**
 * @since 08-09-2012 20:12
 */
public class Printer {
    public final String model;

    private Printer(String model) {
        this.model = model;
    }

    public static Printer create(String model) {
        return new Printer(model);
    }

    @Override
    public String toString() {
        return "Printer{" +
                "model='" + model + '\'' +
                '}';
    }
}
