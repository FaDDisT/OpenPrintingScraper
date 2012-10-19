package it.mankey.openprintingscraper.domain;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * User: xan
 * Date: 10/09/12 23:11
 */
public class ManufacturerTest {
    @Test
    public void testCreate() throws Exception {
        // should create an object with given name
        final Manufacturer manufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME);
        Assert.assertEquals(Fixtures.MANIFACTURER_NAME, manufacturer.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_with_blank_name_throws_exception() throws Exception {
        Manufacturer.create("   \n");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_with_null_name_throws_exception() throws Exception {
        Manufacturer.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_with_empty_name_throws_exception() throws Exception {
        Manufacturer.create("");
    }

    @Test
    public void testCanCreateShouldAcceptOnlyNonBlankStrings() throws Exception {
        Assert.assertFalse(Manufacturer.canCreate(""));
        Assert.assertFalse(Manufacturer.canCreate("  \n"));
        Assert.assertFalse(Manufacturer.canCreate(null));
        Assert.assertTrue(Manufacturer.canCreate(Fixtures.MANIFACTURER_NAME));
    }

    @Test
    public void testEquals() throws Exception {
        final Manufacturer thisTwinManufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME);
        final Manufacturer thatTwinManufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME);
        final Manufacturer otherManufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME + " DIFFERENCE");
        Assert.assertEquals(thisTwinManufacturer, thatTwinManufacturer);
        Assert.assertEquals(thisTwinManufacturer, thisTwinManufacturer);
        Assert.assertFalse(thisTwinManufacturer.equals(otherManufacturer));
        //noinspection ObjectEqualsNull
        Assert.assertFalse(thisTwinManufacturer.equals(null));
        //noinspection EqualsBetweenInconvertibleTypes
        Assert.assertFalse(thisTwinManufacturer.equals(Fixtures.MANIFACTURER_NAME)); // it should not equal another class type
    }

    @Test
    public void testHashCode() throws Exception {
        final Manufacturer thisManufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME);
        final Manufacturer thatManufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME);
        Assert.assertEquals(thisManufacturer.hashCode(), thatManufacturer.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        final Manufacturer thisManufacturer = Manufacturer.create(Fixtures.MANIFACTURER_NAME);
        final String manifacturer = thisManufacturer.toString();
        Assert.assertFalse(StringUtils.isBlank(manifacturer));
        TestUtils.isValidJson(manifacturer);
    }
}
