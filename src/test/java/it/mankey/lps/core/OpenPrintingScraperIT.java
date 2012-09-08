package it.mankey.lps.core;

import it.mankey.lps.core.OpenPrintingScraper;
import it.mankey.lps.domain.Manifacturer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: guest-Pru6zv
 * Date: 08/09/12
 * Time: 09:48
 * To change this template use File | Settings | File Templates.
 */
public class OpenPrintingScraperIT {

    private final OpenPrintingScraper openPrintingScraper;

    public OpenPrintingScraperIT() throws IOException {
        openPrintingScraper = new OpenPrintingScraper();
    }

    @Test
    public void scraperShouldFindManifacturers() throws IOException {
        List<Manifacturer> manifacturers = openPrintingScraper.getManifacturers();
        Assert.assertTrue(!manifacturers.isEmpty());
    }
}
