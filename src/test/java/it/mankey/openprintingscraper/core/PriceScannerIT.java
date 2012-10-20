package it.mankey.openprintingscraper.core;

import it.mankey.openprintingscraper.domain.Country;
import it.mankey.openprintingscraper.domain.Fixtures;
import it.mankey.openprintingscraper.domain.Quote;
import org.junit.Assert;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @since 08-09-2012 20:45
 */
public class PriceScannerIT {

    private final PriceScanner priceScanner;

    public PriceScannerIT() throws MalformedURLException {
        final URL apiUrl = new URL("https://www.googleapis.com");
        priceScanner = new PriceScanner(apiUrl, "AIzaSyA-HWMPuwbZ4aSpDfw2xjOMn4L_eObiMLM");
    }

    @Test
    public void testGetQuotes() throws Exception {
        final List<Quote> quotations = priceScanner.getQuotes(Fixtures.WELL_KNOWN_PRINTER_INSTANCE, Country.Alpha2.GB);
        Assert.assertTrue(!quotations.isEmpty());
    }
}
