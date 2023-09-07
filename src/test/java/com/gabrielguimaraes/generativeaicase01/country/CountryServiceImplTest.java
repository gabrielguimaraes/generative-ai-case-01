package com.gabrielguimaraes.generativeaicase01.country;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CountryServiceImplTest {

  private static final Country BRAZIL =
      new Country(
          new CountryName("Brazil", "Federative Republic of Brazil"),
          List.of("Brasília"),
          "Americas",
          8_515_767,
          212_559_409);
  private static final Country SPAIN =
      new Country(
          new CountryName("Spain", "Kingdom of Spain"),
          List.of("Madrid"),
          "Europe",
          505_992,
          47_351_567);
  private static final Country ESTONIA =
      new Country(
          new CountryName("Estonia", "Republic of Estonia"),
          List.of("Tallinn"),
          "Europe",
          45_227,
          1_331_057);

  private static final List<Country> COUNTRIES = List.of(BRAZIL, SPAIN, ESTONIA);
  private final CountryService countryServiceImpl = new CountryServiceImpl();

  public static Stream<Arguments> filterCountryByNameData() {
    return Stream.of(
        Arguments.of("st", List.of(ESTONIA)),
        Arguments.of("Sp", List.of(SPAIN)),
        Arguments.of("sT", List.of(ESTONIA)),
        Arguments.of("", COUNTRIES),
        Arguments.of("   ", COUNTRIES),
        Arguments.of("x", Collections.emptyList()));
  }

  public static Stream<Arguments> filterCountryByPopulationData() {
    return Stream.of(
        Arguments.of(10, List.of(ESTONIA)),
        Arguments.of(100, List.of(SPAIN, ESTONIA)),
        Arguments.of(0, Collections.emptyList()),
        Arguments.of(300, COUNTRIES));
  }

  @ParameterizedTest
  @MethodSource("filterCountryByNameData")
  void givenCountryName_whenFilterCountriesByName_thenReturnExpectedCountries(
      String name, List<Country> expectedCountries) {
    // given & when
    List<Country> actualCountries = countryServiceImpl.filterCountriesByName(name, COUNTRIES);

    // then
    assertThat(actualCountries).hasSize(expectedCountries.size());
    assertThat(actualCountries).containsExactlyInAnyOrderElementsOf(expectedCountries);
  }

  @ParameterizedTest
  @MethodSource("filterCountryByPopulationData")
  void givenCountryPopulationInMillions_whenFilterCountriesByPopulation_thenReturnExpectedCountries(
      long populationInMillions, List<Country> expectedCountries) {
    // given & when
    List<Country> actualCountries =
        countryServiceImpl.filterCountriesByPopulation(populationInMillions, COUNTRIES);

    // then
    assertThat(actualCountries).hasSize(expectedCountries.size());
    assertThat(actualCountries).containsExactlyInAnyOrderElementsOf(expectedCountries);
  }
}
