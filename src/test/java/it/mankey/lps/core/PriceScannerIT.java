package it.mankey.lps.core;

import it.mankey.lps.TestConstants;
import it.mankey.lps.domain.Country;
import it.mankey.lps.domain.Manifacturer;
import it.mankey.lps.domain.Printer;
import it.mankey.lps.domain.Quote;
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
        final Printer testPrinter = Printer.create(Manifacturer.create(TestConstants.WELL_KNOWN_BRAND), "LaserJet 1100");
        final List<Quote> quotations = priceScanner.getQuotes(testPrinter, Country.Alpha2.GB);
        Assert.assertTrue(!quotations.isEmpty());
    }
}
