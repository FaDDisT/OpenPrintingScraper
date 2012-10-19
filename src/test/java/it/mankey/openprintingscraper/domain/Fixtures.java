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

    public static final Manufacturer WELL_KNOWN_MANUFACTURER_A = Manufacturer.create("Canon");
    public static final Manufacturer WELL_KNOWN_MANUFACTURER_B = Manufacturer.create("Epson");

    public static final List<Manufacturer> WELL_KNOWN_MANUFACTURERs = Arrays.asList(
            Manufacturer.create("Canon"),
            Manufacturer.create("Dell"),
            Manufacturer.create("Epson"),
            Manufacturer.create("HP"),
            Manufacturer.create("IBM"),
            Manufacturer.create("Lexmark"),
            Manufacturer.create("Ricoh"),
            Manufacturer.create("Samsung"),
            Manufacturer.create("Xerox")
    );

    public static final String PRINTER_MODEL = "Color Laser Printer 2000";

    public static final BigDecimal A_QUOTE_PRICE = BigDecimal.ONE;
}
