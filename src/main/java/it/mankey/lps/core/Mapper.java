package it.mankey.lps.core;

/**
 * @param <E> Collection element class
 * @param <T> Return type class
 * @since 07-09-2012 00:31
 */
public interface Mapper<E, T> {
    public T map(E object);
}