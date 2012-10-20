package it.mankey.openprintingscraper.core;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.mankey.openprintingscraper.domain.Country;
import it.mankey.openprintingscraper.domain.Printer;
import it.mankey.openprintingscraper.domain.Quote;
import it.mankey.openprintingscraper.util.CollectionUtils;
import it.mankey.openprintingscraper.util.Mapper;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;

import static it.mankey.openprintingscraper.core.PriceScannerHelper.buildQueryString;

/**
 * @since 08-09-2012 20:40
 */
public final class PriceScanner {

    public static final String SHOPPING_SEARCH_V1_PUBLIC_PRODUCTS_PATH = "/shopping/search/v1/public/products";
    public static final int INVENTORY_INDEX = 0;

    private final String apiKey;
    private final HttpClient httpClient;
    private final URL apiUrl;
    private final ObjectMapper jsonMapper = new ObjectMapper();

    public PriceScanner(final URL apiURL, final String apiKey) {
        this.apiKey = apiKey;
        httpClient = new HttpClient();
        apiUrl = apiURL;
    }

    public List<Quote> getQuotes(final Printer printer, final Country.Alpha2 country) throws IOException {
        final GetMethod httpGetProducts = new GetMethod(apiUrl.toString());
        httpGetProducts.setPath(SHOPPING_SEARCH_V1_PUBLIC_PRODUCTS_PATH);
        httpGetProducts.setQueryString(buildQueryString(printer, country, apiKey));
        httpClient.executeMethod(httpGetProducts);
        final JsonNode response = jsonMapper.readValue(httpGetProducts.getResponseBodyAsStream(), JsonNode.class);
        return CollectionUtils.map(response.path("items").elements(), new Mapper<JsonNode, Quote>() {
            @Override
            public Quote map(final JsonNode element) {
                final JsonNode priceNode = element.path("product").path("inventories").path(INVENTORY_INDEX).path("price");
                final BigDecimal price = new BigDecimal(priceNode.asText());
                return Quote.create(price);
            }
        });
    }
}
