package com.gabrielguimaraes.generativeaicase01.country;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

  private RestClient countryRestClient;

  @Autowired
  public CountryController(RestClient countryRestClient) {
    this.countryRestClient = countryRestClient;
  }

  @GetMapping("/countries")
  public List<String> getCountries(
      @RequestParam(value = "name", defaultValue = "") String name,
      @RequestParam(value = "population", defaultValue = "10") Long population,
      @RequestParam(value = "sort", defaultValue = "") String sort,
      @RequestParam(value = "limit", defaultValue = "10") Integer limit) {

    List<Country> countries = countryRestClient.getCountries();
    return Collections.singletonList(
        String.format("HERE %s %s %s %s %s", name, population, sort, limit, countries));
  }
}
