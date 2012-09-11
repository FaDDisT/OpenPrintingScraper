package it.mankey.openprintingscraper.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * User: xan
 * Date: 11/09/12 00:04
 */
public class PrinterTest {
    @Test
    public void testCreate() throws Exception {

    }

    @Test
    public void testEquals() throws Exception {
        final Printer thisTwinPrinter = Printer.create(Manifacturer.create(Fixtures.MANIFACTURER_NAME), Fixtures.PRINTER_MODEL);
        final Printer thatTwinPrinter = Printer.create(Manifacturer.create(Fixtures.MANIFACTURER_NAME), Fixtures.PRINTER_MODEL);
        final Printer printerWithDifferentModel = Printer.create(Manifacturer.create(Fixtures.MANIFACTURER_NAME), Fixtures.PRINTER_MODEL + " DIFFERENCE");
        final Printer printerWithDifferentManifacturer = Printer.create(Manifacturer.create(Fixtures.MANIFACTURER_NAME + " DIFFERENCE"), Fixtures.PRINTER_MODEL);
        Assert.assertEquals(thisTwinPrinter, thatTwinPrinter);
        Assert.assertFalse(thisTwinPrinter.equals(printerWithDifferentModel));
        Assert.assertFalse(thisTwinPrinter.equals(printerWithDifferentManifacturer));
    }

    @Test
    public void testHashCode() throws Exception {

    }

    @Test
    public void testGetModel() throws Exception {

    }

    @Test
    public void testGetManifacturer() throws Exception {

    }
}
