package it.mankey.openprintingscraper.domain;

import org.junit.Assert;

public final class TestUtils {
    private TestUtils() {
    }

    static void isValidJson(final String quoteToString) {
        // Very simple check, for the moment
        Assert.assertTrue(quoteToString.charAt(0) == '{');
    }
}