package it.mankey.lps.core;

import it.mankey.lps.domain.Manifacturer;
import it.mankey.lps.domain.Printer;
import it.mankey.lps.util.CollectionUtils;
import it.mankey.lps.util.Mapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @since 08-09-2012 10:37
 */
public final class OpenPrintingScraper {

    private final String lpsUrl;
    private static final String MANIFACTURER_SELECTOR = "select#showby_manufacturer > option";

    private OpenPrintingScraper() throws IOException {
        final Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("OpenPrintingScraper.properties"));
        lpsUrl = properties.getProperty("openprinting.url");
    }

    public static OpenPrintingScraper create() throws IOException {
        return new OpenPrintingScraper();
    }

    protected List<Manifacturer> getManifacturers() throws IOException {
        final Document doc = Jsoup.connect(lpsUrl).get();
        final Elements manifacturerNodes = doc.select(MANIFACTURER_SELECTOR);
        final List<Manifacturer> manifacturers = new ArrayList<Manifacturer>(manifacturerNodes.size());
        for (final Element manifacturer : manifacturerNodes) {
            final String manifacturerName = manifacturer.attr("value");
            manifacturers.add(Manifacturer.create(manifacturerName));
        }
        return manifacturers;
    }

    protected List<Printer> getPrinters(final Manifacturer manifacturer) throws IOException {
        final Document doc = Jsoup.connect(lpsUrl + "/manufacturer/" + manifacturer.getName()).get();
        final Elements contents = doc.select("#content > div#two_col_col_1");
        final Elements printerNodes = contents.select("h3:contains(Perfectly), h3:contains(Mostly), a:gt(4)");
        final List<Element> perfectPrinterNodes = printerNodes.subList(1, printerNodes.indexOf(printerNodes.select("h3:contains(Mostly)").first()));
        return CollectionUtils.map(perfectPrinterNodes, new Mapper<Element, Printer>() {
            @Override
            public Printer map(final Element element) {
                return Printer.create(manifacturer, element.ownText());
            }
        });
    }
}
