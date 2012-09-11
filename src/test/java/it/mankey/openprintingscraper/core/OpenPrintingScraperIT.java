package it.mankey.openprintingscraper.core;

import it.mankey.openprintingscraper.TestConstants;
import it.mankey.openprintingscraper.domain.Fixtures;
import it.mankey.openprintingscraper.domain.Manifacturer;
import it.mankey.openprintingscraper.domain.Printer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @since 08-09-2012 09:48
 */
public class OpenPrintingScraperIT {

    private final OpenPrintingScraper openPrintingScraper;

    public OpenPrintingScraperIT() throws IOException {
        openPrintingScraper = OpenPrintingScraper.create();
    }

    @Test
    public void scraperShouldFindManifacturers() throws IOException {
        final List<Manifacturer> manifacturers = openPrintingScraper.getManifacturers();
        Assert.assertTrue(!manifacturers.isEmpty());
        Assert.assertTrue(!Fixtures.WELL_KNOWN_MANIFACTURERS.isEmpty());
        Assert.assertTrue(manifacturers.containsAll(Fixtures.WELL_KNOWN_MANIFACTURERS));
    }

    @Test
    public void getPrinterByBrand() throws IOException {
        final List<Printer> printers = openPrintingScraper.getPrinters(Manifacturer.create(TestConstants.WELL_KNOWN_BRAND));
        Assert.assertTrue(!printers.isEmpty());
    }
}
