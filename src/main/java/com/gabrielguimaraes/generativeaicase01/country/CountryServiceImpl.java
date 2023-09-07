package com.gabrielguimaraes.generativeaicase01.country;

import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
  @Override
  public List<Country> filterCountriesByName(String name, List<Country> sourceCountries) {
    if (Strings.isBlank(name)) {
      return sourceCountries;
    }

    return sourceCountries.stream()
        .filter(country -> getCountryCommonNameLowerCase(country).contains(name.toLowerCase()))
        .toList();
  }

  private static String getCountryCommonNameLowerCase(Country country) {
    return Optional.ofNullable(country)
        .map(Country::name)
        .map(CountryName::common)
        .map(String::toLowerCase)
        .orElse("");
  }
}