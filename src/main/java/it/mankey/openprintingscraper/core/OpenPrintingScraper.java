package it.mankey.openprintingscraper.core;

import it.mankey.openprintingscraper.domain.Manufacturer;
import it.mankey.openprintingscraper.domain.Printer;

import java.io.IOException;
import java.util.List;

/**
 * User: xan
 * Date: 20/10/12 00:40
 */
public interface OpenPrintingScraper {
    /**
     * @return All the manufacturers listed on the OpenPrinting website index page
     * @throws IOException
     */
    List<Manufacturer> getManifacturers() throws IOException;

    /**
     * @param manufacturer One of the manufacturer listed on OpenPrinting
     * @return List of printers that are perfectly supported
     * @throws IOException
     */
    List<Printer> getPerfectlySupportedPrinters(Manufacturer manufacturer) throws IOException;
}
