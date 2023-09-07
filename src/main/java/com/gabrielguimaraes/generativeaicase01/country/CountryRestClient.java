package com.gabrielguimaraes.generativeaicase01.country;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CountryRestClient implements RestClient {

  private static final String URL = "https://restcountries.com/v3.1";
  private static final String ALL = "/all";
  private final RestTemplate restTemplate;

  @Autowired
  public CountryRestClient(RestTemplateBuilder restTemplateBuilder) {
    this.restTemplate = restTemplateBuilder.rootUri(URL).build();
  }

  @Override
  public List<Country> getCountries() {
    final Country[] countriesArray = restTemplate.getForEntity(ALL, Country[].class).getBody();
    return Optional.ofNullable(countriesArray).map(List::of).orElse(Collections.emptyList());
  }
}
