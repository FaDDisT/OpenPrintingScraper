package it.mankey.openprintingscraper.core;

import it.mankey.openprintingscraper.domain.Country;
import it.mankey.openprintingscraper.domain.Printer;
import org.apache.commons.httpclient.NameValuePair;

import static it.mankey.openprintingscraper.util.CollectionUtils.array;
import static org.apache.commons.lang.StringUtils.join;

final class PriceScannerHelper {

    /**
     * Utility classes should not have a public or default constructor.
     */
    private PriceScannerHelper() {
    }

    static NameValuePair[] buildQueryString(final Printer printer, final Country.Alpha2 country, final String apiKey) {
        return array(
                nameValuePair("key", apiKey),
                nameValuePair("country", country.name()),
                nameValuePair("q", join(array(printer.getManufacturer().getName(), printer.getModel(), "printer -cartridge"), " ")),
                nameValuePair("restrictBy",
                              join(array(
                                      "brand:" + printer.getManufacturer().getName(),
                                      "condition:new"
                              ),
                                   ","
                              )
                ),
                nameValuePair("ranking", "relevancy"),
                nameValuePair("crowdBy", "accountId:1")
        );
    }

    static NameValuePair nameValuePair(final String key, final String value) {
        return new NameValuePair(key, value);
    }
}