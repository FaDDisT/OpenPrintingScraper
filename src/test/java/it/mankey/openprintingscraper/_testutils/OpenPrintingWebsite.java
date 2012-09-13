package it.mankey.openprintingscraper._testutils;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

public class OpenPrintingWebsite implements HttpHandler {
    @Override
    public void handle(final HttpExchange exchange) throws IOException {
        final String resourcePath = exchange.getRequestURI().getPath() + ".html";
        final InputStream stream = this.getClass().getResourceAsStream("/" + this.getClass().getSimpleName().toLowerCase() + resourcePath);
        final Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.set("Content-Type", "text/html; charset=utf-8");
        exchange.sendResponseHeaders(200, 0);
        IOUtils.copy(stream, exchange.getResponseBody());
        exchange.getResponseBody().close();
    }
}