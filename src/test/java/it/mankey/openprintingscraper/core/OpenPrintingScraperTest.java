package it.mankey.openprintingscraper.core;

import com.sun.net.httpserver.HttpServer;
import it.mankey.openprintingscraper._testutils.OpenPrintingWebsiteMockHandler;
import it.mankey.openprintingscraper.domain.Fixtures;
import it.mankey.openprintingscraper.domain.Manufacturer;
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

import static it.mankey.openprintingscraper.TestConstants.*;

/**
 * @since 08-09-2012 09:48
 */
public class OpenPrintingScraperTest {

    private final OpenPrintingScraper openPrintingScraper;

    private static HttpServer testHttpServer;

    @BeforeClass
    public static void setupTestHttpServer() throws IOException {
        testHttpServer = HttpServer.create(new InetSocketAddress(TEST_HTTP_SERVER_PORT), 0);
        testHttpServer.createContext("/", new OpenPrintingWebsiteMockHandler());
        testHttpServer.start();
    }

    @AfterClass
    public static void tearDownTestHttpServer() throws IOException {
        testHttpServer.stop(SERVER_SHUTDOWN_TIMELIMIT_IN_SEC);
    }

    public OpenPrintingScraperTest() throws IOException {
        openPrintingScraper = OpenPrintingScraperImpl.create(OPEN_PRINTING_TEST_HOST);
    }

    @Test
    public void scraperShouldFindManifacturers() throws IOException {
        final List<Manufacturer> manufacturers = openPrintingScraper.getManifacturers();
        Assert.assertTrue(!manufacturers.isEmpty());
        Assert.assertTrue(!Fixtures.WELL_KNOWN_MANUFACTURERs.isEmpty());
        Assert.assertTrue(manufacturers.containsAll(Fixtures.WELL_KNOWN_MANUFACTURERs));
    }

    @Test
    public void getPrinterByBrand() throws IOException {
        final List<Printer> printers = openPrintingScraper.getPerfectlySupportedPrinters(Manufacturer.create(Fixtures.WELL_KNOWN_BRAND));
        Assert.assertTrue(!printers.isEmpty());
    }

    @Test
    public void testHttpServer() throws IOException {
        final String urlString = "http://localhost:" + TEST_HTTP_SERVER_PORT + "/printers";
        final URL url = new URL(urlString);
        System.out.println(IOUtils.toString(url.openStream()));
    }


}
