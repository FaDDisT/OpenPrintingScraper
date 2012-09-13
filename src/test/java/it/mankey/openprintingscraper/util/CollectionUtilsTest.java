package it.mankey.openprintingscraper.util;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * User: xan
 * Date: 13/09/12 22:41
 */
public class CollectionUtilsTest {

    final Mapper<Integer, Integer> duplicate = new Mapper<Integer, Integer>() {
        @Override
        public Integer map(final Integer element) {
            return element * 2;
        }
    };

    @Test
    public void testMapList() throws Exception {
        final List<Integer> originalList = Arrays.asList(1, 2, 3);
        final List<Integer> expectedList = Arrays.asList(2, 4, 6);
        Assert.assertEquals(duplicate.map(originalList.get(0)), expectedList.get(0));
        final List<Integer> resultingList = CollectionUtils.map(originalList, duplicate);
        Assert.assertEquals(expectedList, resultingList);
        final List<Integer> resultingListFromIterator = CollectionUtils.map(originalList.iterator(), duplicate);
        Assert.assertEquals(expectedList, resultingListFromIterator);
    }

    @Test
    public void testArray() throws Exception {
        final String[] expectedArray = {"1", "2", "3"};
        final String[] actualList = CollectionUtils.array("1", "2", "3");
        Assert.assertTrue(actualList.length == expectedArray.length);
        Assert.assertTrue(Arrays.equals(expectedArray, actualList));
    }
}
