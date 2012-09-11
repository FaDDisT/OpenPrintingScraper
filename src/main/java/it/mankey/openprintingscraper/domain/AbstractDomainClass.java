package it.mankey.openprintingscraper.domain;

import it.mankey.openprintingscraper.util.JacksonObjectMapper;

import java.io.IOException;

public abstract class AbstractDomainClass {

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