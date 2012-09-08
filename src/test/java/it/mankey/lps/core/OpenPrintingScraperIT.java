package it.mankey.lps.core;

import it.mankey.lps.domain.Manifacturer;
import it.mankey.lps.domain.Printer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @since 08-09-2012 09:48
 */
public class OpenPrintingScraperIT {

    private final OpenPrintingScraper openPrintingScraper;
    private static final String WELL_KNOWN_BRAND = "HP";

    public OpenPrintingScraperIT() throws IOException {
        openPrintingScraper = OpenPrintingScraper.create();
    }

    @Test
    public void scraperShouldFindManifacturers() throws IOException {
        List<Manifacturer> manifacturers = openPrintingScraper.getManifacturers();
        Assert.assertTrue(!manifacturers.isEmpty());
    }

    @Test
    public void getPrinterByBrand() throws IOException {
        List<Printer> printers = openPrintingScraper.getPrinters(Manifacturer.create(WELL_KNOWN_BRAND));
        Assert.assertTrue(!printers.isEmpty());
    }
}
