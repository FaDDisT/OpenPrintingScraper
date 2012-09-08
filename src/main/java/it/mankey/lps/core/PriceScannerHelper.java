package it.mankey.lps.core;

import it.mankey.lps.domain.Country;
import it.mankey.lps.domain.Printer;
import org.apache.commons.httpclient.NameValuePair;

public class PriceScannerHelper {

    public static NameValuePair[] buildQueryString(final Printer printer, final Country.Alpha2 country, final String apiKey) {
        return CollectionUtils.array(
                nameValuePair("key", apiKey),
                nameValuePair("country", country.name()),
                nameValuePair("q", "printer+" + printer.model)
        );
    }

    static NameValuePair nameValuePair(final String key, final String value) {
        return new NameValuePair(key, value);
    }
}