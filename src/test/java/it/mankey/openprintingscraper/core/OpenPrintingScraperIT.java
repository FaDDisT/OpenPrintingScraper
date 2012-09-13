package it.mankey.openprintingscraper.core;

import com.sun.net.httpserver.HttpServer;
import it.mankey.openprintingscraper.TestConstants;
import it.mankey.openprintingscraper._testutils.OpenPrintingWebsite;
import it.mankey.openprintingscraper.domain.Fixtures;
import it.mankey.openprintingscraper.domain.Manifacturer;
import it.mankey.openprintingscraper.domain.Printer;
import org.apache.commons.io.IOUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.List;

/**
 * @since 08-09-2012 09:48
 */
public class OpenPrintingScraperIT {

    public static final int TEST_HTTP_SERVER_PORT = 9888;
    private final OpenPrintingScraper openPrintingScraper;

    private static HttpServer testHttpServer;

    @BeforeClass
    public static void setupTestHttpServer() throws IOException {
        testHttpServer = HttpServer.create(new InetSocketAddress(TEST_HTTP_SERVER_PORT), 0);
        testHttpServer.createContext("/", new OpenPrintingWebsite());
        testHttpServer.start();
    }

    @AfterClass
    public static void tearDownTestHttpServer() throws IOException {
        testHttpServer.stop(30);
    }

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

    @Test
    public void testHttpServer() throws IOException {
        final String urlString = "http://localhost:" + TEST_HTTP_SERVER_PORT + "/printers";
        final URL url = new URL(urlString);
        System.out.println(IOUtils.toString(url.openStream()));
    }


}
