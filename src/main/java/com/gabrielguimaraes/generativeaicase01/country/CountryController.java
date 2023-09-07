package com.gabrielguimaraes.generativeaicase01.country;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

  private final RestClient countryRestClient;
  private final CountryService countryService;

  @Autowired
  public CountryController(RestClient countryRestClient, CountryService countryService) {
    this.countryRestClient = countryRestClient;
    this.countryService = countryService;
  }

  @GetMapping("/countries")
  public List<Country> getCountries(
      @RequestParam(value = "name", defaultValue = "") String name,
      @RequestParam(value = "population", defaultValue = "-1") Long population,
      @RequestParam(value = "sort", defaultValue = "") String sort,
      @RequestParam(value = "limit", defaultValue = "-1") Integer limit) {

    List<Country> countries = countryRestClient.getCountries();

    List<Country> sortedCountries = countryService.sortCountriesByName(sort, countries);
    List<Country> filteredCountriesByName =
        countryService.filterCountriesByName(name, sortedCountries);
    List<Country> filteredCountriesByPopulation =
        countryService.filterCountriesByPopulation(population, filteredCountriesByName);
    return countryService.limitCountries(limit, filteredCountriesByPopulation);
  }
}
