package it.mankey.openprintingscraper.core;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import it.mankey.openprintingscraper.domain.Manufacturer;
import it.mankey.openprintingscraper.domain.Printer;
import org.apache.commons.httpclient.HttpHost;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class OpenPrintingScraperImpl implements OpenPrintingScraper {

    private static final Logger LOGGER = LoggerFactory.getLogger(OpenPrintingScraperImpl.class);

    private static final String MANIFACTURER_SELECTOR = "select#showby_manufacturer > option";
    private final HttpHost openPrintingHost;
    private static final String BASE_PATH = "printers";

    public OpenPrintingScraperImpl(final HttpHost openPrintingHost) {
        this.openPrintingHost = openPrintingHost;
    }

    public static OpenPrintingScraper create(final HttpHost openPrintingTestHost) {
        return new OpenPrintingScraperImpl(openPrintingTestHost);
    }

    @Override
    public List<Manufacturer> getManifacturers() throws IOException {
        final Document doc = Jsoup.connect(getIndexPath()).get();
        final Elements manifacturerNodes = doc.select(MANIFACTURER_SELECTOR);
        final List<Manufacturer> manufacturers = new ArrayList<Manufacturer>(manifacturerNodes.size());
        for (final Element manifacturer : manifacturerNodes) {
            final String manifacturerName = manifacturer.attr("value");
            if (Manufacturer.canCreate(manifacturerName)) {
                manufacturers.add(Manufacturer.create(manifacturerName));
            }
            else {
                LOGGER.warn("Invalid manufacturer {}", manifacturerName);
            }
        }
        return manufacturers;
    }

    @Override
    public List<Printer> getPerfectlySupportedPrinters(final Manufacturer manufacturer) throws IOException {
        final String manifacturerPath = getManifacturerPath(manufacturer);
        final Document doc = Jsoup.connect(manifacturerPath).get();
        final Elements contents = doc.select("#content > div#two_col_col_1");
        final Elements printerNodes = contents.select("h3:contains(Perfectly), h3:contains(Mostly), a:gt(4)");
        final List<Element> perfectPrinterNodes = printerNodes.subList(1, printerNodes.indexOf(printerNodes.select("h3:contains(Mostly)").first()));
        return Lists.transform(perfectPrinterNodes, new Function<Element, Printer>() {
            @Override
            public Printer apply(final Element el) {
                return Printer.create(manufacturer, el.ownText());
            }
        });
    }

    private String getManifacturerPath(final Manufacturer manufacturer) {
        return Joiner.on("/").join(
                openPrintingHost.toURI(),
                BASE_PATH,
                "manufacturer",
                manufacturer.getName());
    }

    private String getIndexPath() {
        return Joiner.on("/").join(
                openPrintingHost.toURI(),
                BASE_PATH
        );
    }
}
