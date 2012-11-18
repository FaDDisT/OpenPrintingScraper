package it.mankey.openprintingscraper.web;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import it.mankey.openprintingscraper.core.OpenPrintingScraper;
import it.mankey.openprintingscraper.core.OpenPrintingScraperImpl;
import it.mankey.openprintingscraper.domain.Manufacturer;
import org.apache.commons.httpclient.HttpHost;
import org.apache.commons.httpclient.HttpStatus;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import spark.Request;
import spark.Response;
import spark.Route;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static it.mankey.openprintingscraper.web.ResourceHelper.getPackageAsPath;
import static spark.Spark.get;

/**
 * User: xan
 * Date: 12/11/12 21:35
 */
public class WebApp {

    private final TemplateEngine templateEngine;
    private final OpenPrintingScraper openPrintingScraper;

    private WebApp() {
        templateEngine = new TemplateEngine();
        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix(buildTemplatePrefixPath());
        templateEngine.setTemplateResolver(templateResolver);

        openPrintingScraper = new OpenPrintingScraperImpl(new HttpHost("www.openprinting.org"));
    }

    private void setupRoutes() {
        get(new Route("/manufacturers") {
            @Override
            public Object handle(final Request request, final Response response) {
                try {
                    final List<Manufacturer> manufacturers = openPrintingScraper.getManifacturers();
                    final Map<String, Object> viewModelsMap = Maps.newHashMap();
                    viewModelsMap.put("manufacturers", manufacturers);
                    return templateEngine.process("manufacturers.xhtml", new Context(Locale.ENGLISH, viewModelsMap));
                }
                catch (IOException e) {
                    response.status(HttpStatus.SC_INTERNAL_SERVER_ERROR);
                    return e;
                }
            }
        });
    }

    public static void main(final String[] args) {
        final WebApp app = new WebApp();
        app.setupRoutes();
    }

    private String buildTemplatePrefixPath() {
        return Joiner.on("/").join(getPackageAsPath(WebApp.class), "html/");
    }
}
