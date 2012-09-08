package it.mankey.lps.core;

import it.mankey.lps.domain.Manifacturer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: guest-Pru6zv
 * Date: 08/09/12
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 */
public class OpenPrintingScraper {

    private final String LPS_URL;
    private static final String MANIFACTURER_SELECTOR = "select#showby_manufacturer > option";

    public OpenPrintingScraper() throws IOException {
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("OpenPrintingScraper.properties"));
        LPS_URL = properties.getProperty("openprinting.url");
    }

    protected List<Manifacturer> getManifacturers() throws IOException {
        final Document doc = Jsoup.connect(LPS_URL).get();
        final Elements manifacturerNodes = doc.select(MANIFACTURER_SELECTOR);
        final List<Manifacturer> manifacturers = new ArrayList<Manifacturer>(manifacturerNodes.size());
        for (final Element manifacturer : manifacturerNodes) {
            final String manifacturerName = manifacturer.attr("value");
            manifacturers.add(new Manifacturer(manifacturerName));
        }
        return manifacturers;
    }
}
