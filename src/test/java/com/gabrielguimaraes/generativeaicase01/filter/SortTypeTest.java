package com.gabrielguimaraes.generativeaicase01.filter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SortTypeTest {

  public static Stream<Arguments> sortNamesData() {
    return Stream.of(
        Arguments.of("ascend", SortType.ASCEND),
        Arguments.of("descend", SortType.DESCEND),
        Arguments.of("AScend", SortType.ASCEND),
        Arguments.of("DEScend", SortType.DESCEND),
        Arguments.of("asc", SortType.ASCEND),
        Arguments.of("desc", SortType.ASCEND));
  }

  @ParameterizedTest
  @MethodSource("sortNamesData")
  void givenSortName_whenFromMethodCalled_thenGetCorrectSortType(
      String sortName, SortType expectedSortType) {
    // given & when
    SortType actualSortType = SortType.from(sortName);

    // then
    assertThat(actualSortType).isEqualTo(expectedSortType);
  }
}
