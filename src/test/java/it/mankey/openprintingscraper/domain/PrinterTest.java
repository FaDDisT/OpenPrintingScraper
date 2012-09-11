package it.mankey.openprintingscraper.domain;

import org.junit.Assert;
import org.junit.Test;

import static it.mankey.openprintingscraper.domain.Fixtures.*;

/**
 * User: xan
 * Date: 11/09/12 00:04
 */
public class PrinterTest {
    @Test
    public void testCreate() throws Exception {
        final Printer printer = Printer.create(WELL_KNOWN_MANIFACTURER_B, PRINTER_MODEL);
        Assert.assertNotNull(printer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_ShouldThrowExceptionWithNullManifacturer() throws Exception {
        Printer.create(null, PRINTER_MODEL);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_ShouldThrowExceptionWithBlankPrinterModel() throws Exception {
        Printer.create(WELL_KNOWN_MANIFACTURER_B, " ");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_ShouldThrowExceptionWithEmptyPrinterModel() throws Exception {
        Printer.create(WELL_KNOWN_MANIFACTURER_B, "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_ShouldThrowExceptionWithNullPrinterModel() throws Exception {
        Printer.create(WELL_KNOWN_MANIFACTURER_B, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_ShouldThrowExceptionWithNullParameters() throws Exception {
        Printer.create(null, null);
    }

    @SuppressWarnings({"EqualsBetweenInconvertibleTypes", "ObjectEqualsNull"})
    @Test
    public void testEquals() throws Exception {
        final Printer thisTwinPrinter = Printer.create(Manifacturer.create(MANIFACTURER_NAME), PRINTER_MODEL);
        final Printer thatTwinPrinter = Printer.create(Manifacturer.create(MANIFACTURER_NAME), PRINTER_MODEL);
        final Printer printerWithDifferentModel = Printer.create(Manifacturer.create(MANIFACTURER_NAME), PRINTER_MODEL + " DIFFERENCE");
        final Printer printerWithDifferentManifacturer = Printer.create(Manifacturer.create(MANIFACTURER_NAME + " DIFFERENCE"), PRINTER_MODEL);
        Assert.assertEquals(thisTwinPrinter, thatTwinPrinter);
        Assert.assertEquals(thisTwinPrinter, thisTwinPrinter);
        Assert.assertFalse(thisTwinPrinter.equals(printerWithDifferentModel));
        Assert.assertFalse(thisTwinPrinter.equals(printerWithDifferentManifacturer));
        Assert.assertFalse(thisTwinPrinter.equals(null));
        Assert.assertFalse(thisTwinPrinter.equals(PRINTER_MODEL));
    }

    @Test
    public void testHashCode() throws Exception {
        final Printer thisTwinPrinter = Printer.create(WELL_KNOWN_MANIFACTURER_A, PRINTER_MODEL);
        final Printer thatTwinPrinter = Printer.create(WELL_KNOWN_MANIFACTURER_A, PRINTER_MODEL);
        final Printer otherModelPrinter = Printer.create(WELL_KNOWN_MANIFACTURER_A, PRINTER_MODEL + " DIFFERENCE");
        final Printer otherManifacturerPrinter = Printer.create(WELL_KNOWN_MANIFACTURER_B, PRINTER_MODEL + " DIFFERENCE");
        Assert.assertEquals(thisTwinPrinter.hashCode(), thatTwinPrinter.hashCode());
        Assert.assertEquals(thisTwinPrinter.hashCode(), thisTwinPrinter.hashCode());
        Assert.assertFalse(thisTwinPrinter.hashCode() == otherModelPrinter.hashCode()); // technically these could be the same
        Assert.assertFalse(thisTwinPrinter.hashCode() == otherManifacturerPrinter.hashCode()); // technically these could be the same
        // my purpose with the above test is verify that hashCode is not ALWAYS the same
        Assert.assertFalse(thisTwinPrinter.hashCode() == 0);
    }

    @Test
    public void testGetModel() throws Exception {
        final Printer printer = Printer.create(WELL_KNOWN_MANIFACTURER_A, PRINTER_MODEL);
        Assert.assertNotNull(printer.getModel());
        Assert.assertEquals(PRINTER_MODEL, printer.getModel());
    }

    @Test
    public void testGetManifacturer() throws Exception {
        final Printer printer = Printer.create(WELL_KNOWN_MANIFACTURER_A, PRINTER_MODEL);
        Assert.assertNotNull(printer.getManifacturer());
        Assert.assertEquals(WELL_KNOWN_MANIFACTURER_A, printer.getManifacturer());
    }
}
