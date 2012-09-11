package it.mankey.openprintingscraper.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @since 07-09-2012 00:31
 */
public final class CollectionUtils {

    private CollectionUtils() {
    }

    public static <E, T> List<T> map(final List<E> list, final Mapper<E, T> mapper) {
        final List<T> result = new ArrayList<T>(list.size());
        for (final E element : list) {
            result.add(mapper.map(element));
        }
        return result;
    }

    public static <E, T> List<T> map(final Iterator<E> list, final Mapper<E, T> mapper) {
        final List<T> result = new ArrayList<T>();
        while (list.hasNext()) {
            result.add(mapper.map(list.next()));
        }
        return result;
    }

    public static <T> T[] array(final T... ts) {
        return ts;
    }
}
