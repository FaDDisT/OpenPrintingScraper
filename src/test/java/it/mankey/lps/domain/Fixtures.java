package it.mankey.lps.domain;

import java.util.Arrays;
import java.util.List;

/**
 * User: xan
 * Date: 10/09/12 23:01
 */
public class Fixtures {

    public static final String MANIFACTURER_NAME = "Printer Manifacturer";

    public static final List<Manifacturer> WELL_KNOWN_MANIFACTURERS = Arrays.asList(
            Manifacturer.create("HP"),
            Manifacturer.create("Dell"),
            Manifacturer.create("Samsung"),
            Manifacturer.create("Xerox"),
            Manifacturer.create("Lexmark"),
            Manifacturer.create("Konica")

    );
}
