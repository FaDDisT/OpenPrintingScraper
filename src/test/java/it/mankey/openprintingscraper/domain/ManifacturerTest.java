package it.mankey.openprintingscraper.domain;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * User: xan
 * Date: 10/09/12 23:11
 */
public class ManifacturerTest {
    @Test
    public void testCreate() throws Exception {
        // should create an object with given name
        final Manifacturer manifacturer = Manifacturer.create(Fixtures.MANIFACTURER_NAME);
        Assert.assertEquals(Fixtures.MANIFACTURER_NAME, manifacturer.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_with_blank_name_throws_exception() throws Exception {
        Manifacturer.create("   \n");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_with_null_name_throws_exception() throws Exception {
        Manifacturer.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_with_empty_name_throws_exception() throws Exception {
        Manifacturer.create("");
    }

    @Test
    public void testCanCreateShouldAcceptOnlyNonBlankStrings() throws Exception {
        Assert.assertFalse(Manifacturer.canCreate(""));
        Assert.assertFalse(Manifacturer.canCreate("  \n"));
        Assert.assertFalse(Manifacturer.canCreate(null));
        Assert.assertTrue(Manifacturer.canCreate(Fixtures.MANIFACTURER_NAME));
    }

    @Test
    public void testEquals() throws Exception {
        final Manifacturer thisTwinManifacturer = Manifacturer.create(Fixtures.MANIFACTURER_NAME);
        final Manifacturer thatTwinManifacturer = Manifacturer.create(Fixtures.MANIFACTURER_NAME);
        final Manifacturer otherManifacturer = Manifacturer.create(Fixtures.MANIFACTURER_NAME + " DIFFERENCE");
        Assert.assertEquals(thisTwinManifacturer, thatTwinManifacturer);
        Assert.assertEquals(thisTwinManifacturer, thisTwinManifacturer);
        Assert.assertFalse(thisTwinManifacturer.equals(otherManifacturer));
        //noinspection ObjectEqualsNull
        Assert.assertFalse(thisTwinManifacturer.equals(null));
        //noinspection EqualsBetweenInconvertibleTypes
        Assert.assertFalse(thisTwinManifacturer.equals(Fixtures.MANIFACTURER_NAME)); // it should not equal another class type
    }

    @Test
    public void testHashCode() throws Exception {
        final Manifacturer thisManifacturer = Manifacturer.create(Fixtures.MANIFACTURER_NAME);
        final Manifacturer thatManifacturer = Manifacturer.create(Fixtures.MANIFACTURER_NAME);
        Assert.assertEquals(thisManifacturer.hashCode(), thatManifacturer.hashCode());
    }

    @Test
    public void testToString() throws Exception {
        final Manifacturer thisManifacturer = Manifacturer.create(Fixtures.MANIFACTURER_NAME);
        final String manifacturer = thisManifacturer.toString();
        Assert.assertFalse(StringUtils.isBlank(manifacturer));
        TestUtils.isValidJson(manifacturer);
    }
}
