package it.mankey.openprintingscraper.domain;

import it.mankey.openprintingscraper.util.JacksonObjectMapper;

import java.io.IOException;

/**
 * Implements a generic toString method.
 */
public abstract class AbstractDomainClass {

    /**
     * @return JSON representation of the current instance
     */
    @Override
    public String toString() {
        try {
            return JacksonObjectMapper.getInstance().writeValueAsString(this);
        }
        catch (IOException e) {
            return e.toString();
        }
    }
}