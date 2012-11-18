package it.mankey.openprintingscraper.core

import static it.mankey.openprintingscraper.domain.Country.Alpha2.GB
import static it.mankey.openprintingscraper.domain.Fixtures.WELL_KNOWN_PRINTER_INSTANCE

class PriceScannerTest extends spock.lang.Specification {

    def apiToken = "AIzaSyA-HWMPuwbZ4aSpDfw2xjOMn4L_eObiMLM"
    def apiUrl = new URL("https://www.googleapis.com")
    def priceScanner = new PriceScanner(apiUrl, apiToken)

    def "retrieve quotations for a well known printer"() {
        given:
        def printerName = WELL_KNOWN_PRINTER_INSTANCE
        def countryCode = GB
        def quotations

        when:
        quotations = priceScanner.getQuotes(printerName, countryCode);

        then:
        quotations != null
        !quotations.isEmpty()
    }
}
