package it.mankey.openprintingscraper.web.controller;

import it.mankey.openprintingscraper.core.OpenPrintingScraper;
import it.mankey.openprintingscraper.domain.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

/**
 * User: xan
 * Date: 21/10/12 00:04
 */
@Controller
public class OpenPrintingScraperController {

    @Autowired
    OpenPrintingScraper openPrintingScraper;

    @RequestMapping("/manufacturers")
    public ModelAndView manufacturers() throws IOException {
        final List<Manufacturer> manufacturers = openPrintingScraper.getManifacturers();
        return new ModelAndView("manufacturers", "manufacturers", manufacturers);
    }
}
