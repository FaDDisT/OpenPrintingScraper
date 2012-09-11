package it.mankey.openprintingscraper.domain;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static it.mankey.openprintingscraper.domain.Fixtures.A_QUOTE_PRICE;

/**
 * User: xan
 * Date: 11/09/12 20:31
 */
public class QuoteTest {
    @Test
    public void testCreate() throws Exception {
        final Quote quote = Quote.create(A_QUOTE_PRICE);
        Assert.assertNotNull(quote);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreate_ThrowsExceptionIfPriceIsNull() throws Exception {
        Quote.create(null);
    }

    @Test
    public void testEquals() throws Exception {
        final Quote thisTwinQuote = Quote.create(A_QUOTE_PRICE);
        final Quote thatTwinQuote = Quote.create(A_QUOTE_PRICE);
        final Quote otherQuote = Quote.create(A_QUOTE_PRICE.add(BigDecimal.ONE));
        Assert.assertEquals(thisTwinQuote, thatTwinQuote);
        Assert.assertEquals(thisTwinQuote, thisTwinQuote);
        Assert.assertFalse(thisTwinQuote.equals(otherQuote));
        //noinspection ObjectEqualsNull
        Assert.assertFalse(thisTwinQuote.equals(null));
        //noinspection EqualsBetweenInconvertibleTypes
        Assert.assertFalse(thisTwinQuote.equals(A_QUOTE_PRICE)); // it should not equal another class type
    }

    @Test
    public void testHashCode() throws Exception {
        final Quote thisTwinQuote = Quote.create(A_QUOTE_PRICE);
        final Quote thatTwinQuote = Quote.create(A_QUOTE_PRICE);
        final Quote otherQuote = Quote.create(A_QUOTE_PRICE.add(BigDecimal.ONE));
        Assert.assertEquals(thisTwinQuote.hashCode(), thatTwinQuote.hashCode());
        Assert.assertEquals(thisTwinQuote.hashCode(), thisTwinQuote.hashCode());
        Assert.assertFalse(thisTwinQuote.hashCode() == otherQuote.hashCode()); // technically these could be the same
        // my purpose with the above test is verify that hashCode is not ALWAYS the same
        Assert.assertFalse(thisTwinQuote.hashCode() == 0);
    }

    @Test
    public void testGetPrice() throws Exception {
        final Quote quote = Quote.create(A_QUOTE_PRICE);
        Assert.assertNotNull(quote.getPrice());
        Assert.assertEquals(A_QUOTE_PRICE, quote.getPrice());
    }

    @Test
    public void testToString() throws Exception {
        final String quoteToString = Quote.create(A_QUOTE_PRICE).toString();
        Assert.assertFalse(StringUtils.isBlank(quoteToString));
        TestUtils.isValidJson(quoteToString);
    }
}
