package it.mankey.openprintingscraper.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * User: xan
 * Date: 11/09/12 00:57
 */
public final class JacksonObjectMapper {

    private static final ObjectMapper INSTANCE;

    static {
        INSTANCE = new ObjectMapper();
    }

    private JacksonObjectMapper() {
    }

    public static ObjectMapper getInstance() {
        return INSTANCE;
    }
}
