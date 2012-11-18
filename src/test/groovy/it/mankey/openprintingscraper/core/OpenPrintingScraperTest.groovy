package it.mankey.openprintingscraper.core

import com.sun.net.httpserver.HttpServer
import it.mankey.openprintingscraper._testutils.OpenPrintingWebsiteMockHandler
import it.mankey.openprintingscraper.domain.Manufacturer
import spock.lang.Shared

import static it.mankey.openprintingscraper.TestConstants.*
import static it.mankey.openprintingscraper.domain.Fixtures.WELL_KNOWN_BRAND
import static it.mankey.openprintingscraper.domain.Fixtures.WELL_KNOWN_MANUFACTURERs

class OpenPrintingScraperTest extends spock.lang.Specification {

    static @Shared testHttpServer

    def setupSpec() {
        testHttpServer = HttpServer.create(new InetSocketAddress(TEST_HTTP_SERVER_PORT), 0)
        testHttpServer.createContext("/", new OpenPrintingWebsiteMockHandler())
        testHttpServer.start()
    }

    def cleanupSpec() {
        testHttpServer.stop(SERVER_SHUTDOWN_TIMELIMIT_IN_SEC)
    }

    def openPrintingScraper = OpenPrintingScraperImpl.create(OPEN_PRINTING_TEST_HOST)

    def "extract manifacturers"() {
        when:
        def manufacturers = openPrintingScraper.getManifacturers()

        then:
        !manufacturers.isEmpty()
        manufacturers.containsAll(WELL_KNOWN_MANUFACTURERs)
    }

    def "find perfectly supported printers for well known brand"() {
        when:
        def printers = openPrintingScraper.getPerfectlySupportedPrinters(Manufacturer.create(WELL_KNOWN_BRAND))

        then:
        !printers.isEmpty()
    }
}
