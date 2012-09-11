package it.mankey.openprintingscraper.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * User: xan
 * Date: 10/09/12 23:01
 */
public class Fixtures {

    public static final String MANIFACTURER_NAME = "Printer Manifacturer";

    public static final List<Manifacturer> WELL_KNOWN_MANIFACTURERS = Arrays.asList(
            Manifacturer.create("Canon"),
            Manifacturer.create("Dell"),
            Manifacturer.create("Epson"),
            Manifacturer.create("HP"),
            Manifacturer.create("IBM"),
            Manifacturer.create("Lexmark"),
            Manifacturer.create("Ricoh"),
            Manifacturer.create("Samsung"),
            Manifacturer.create("Xerox")
    );
    public static final String PRINTER_MODEL = "Color Laser Printer 2000";

    public static final BigDecimal A_QUOTE_PRICE = BigDecimal.ONE;
}
