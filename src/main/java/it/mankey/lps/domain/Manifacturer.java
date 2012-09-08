package it.mankey.lps.domain;

/**
 * @since 08-09-2012 10:10
 */
public class Manifacturer {
    public final String name;

    private Manifacturer(String name) {
        this.name = name;
    }

    public static Manifacturer create(String name) {
        return new Manifacturer(name);
    }
}
