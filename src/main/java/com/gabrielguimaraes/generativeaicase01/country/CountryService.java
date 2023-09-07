package com.gabrielguimaraes.generativeaicase01.country;

import java.util.List;

public interface CountryService {
  List<Country> filterCountriesByName(String name, List<Country> sourceCountries);

  List<Country> filterCountriesByPopulation(long population, List<Country> sourceCountries);
}
