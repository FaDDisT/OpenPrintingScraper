package it.mankey.openprintingscraper.web;

public class ResourceHelper {
    public static String getPackageAsPath(final Class clazz) {
        return clazz.getPackage().getName().replaceAll("\\.", "/");
    }
}