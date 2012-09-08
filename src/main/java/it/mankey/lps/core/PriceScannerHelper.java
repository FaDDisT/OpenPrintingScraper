package it.mankey.lps.core;

import it.mankey.lps.domain.Country;
import it.mankey.lps.domain.Printer;
import org.apache.commons.httpclient.NameValuePair;

import static it.mankey.lps.util.CollectionUtils.array;
import static org.apache.commons.lang.StringUtils.join;

public class PriceScannerHelper {

    public static NameValuePair[] buildQueryString(final Printer printer, final Country.Alpha2 country, final String apiKey) {
        return array(
                nameValuePair("key", apiKey),
                nameValuePair("country", country.name()),
                nameValuePair("q", join(array(printer.manifacturer.name, printer.model, "printer -cartridge"), " ")),
                nameValuePair("restrictBy",
                        join(array(
                                "brand:" + printer.manifacturer.name,
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