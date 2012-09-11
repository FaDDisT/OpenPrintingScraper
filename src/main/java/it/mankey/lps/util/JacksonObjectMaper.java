package it.mankey.lps.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * User: xan
 * Date: 11/09/12 00:57
 */
public final class JacksonObjectMaper {

    public static final ObjectMapper instance;

    static {
        instance = new ObjectMapper();
    }

    private JacksonObjectMaper() {
    }
}
