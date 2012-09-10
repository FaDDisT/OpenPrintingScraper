package it.mankey.lps.domain;

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
        Manifacturer.create("");
    }

    @Test
    public void testEquals() throws Exception {
        final Manifacturer thisManifacturer = Manifacturer.create(Fixtures.MANIFACTURER_NAME);
        final Manifacturer thatManifacturer = Manifacturer.create(Fixtures.MANIFACTURER_NAME);
        Assert.assertEquals(thisManifacturer, thatManifacturer);
    }

    @Test
    public void testHashCode() throws Exception {
        final Manifacturer thisManifacturer = Manifacturer.create(Fixtures.MANIFACTURER_NAME);
        final Manifacturer thatManifacturer = Manifacturer.create(Fixtures.MANIFACTURER_NAME);
        Assert.assertEquals(thisManifacturer.hashCode(), thatManifacturer.hashCode());
    }
}
