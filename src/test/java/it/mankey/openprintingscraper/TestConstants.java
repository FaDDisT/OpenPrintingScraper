package it.mankey.openprintingscraper;

import org.apache.http.HttpHost;

public class TestConstants {
    public static final int TEST_HTTP_SERVER_PORT = 9888;
    public static final int SERVER_SHUTDOWN_TIMELIMIT_IN_SEC = 30;
    public static final HttpHost OPEN_PRINTING_TEST_HOST = new HttpHost("localhost", TEST_HTTP_SERVER_PORT);
}