package com.gabrielguimaraes.generativeaicase01.filter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public enum SortType {
  ASCEND,
  DESCEND;

  public <T, U extends Comparable<? super U>> Comparator<? super T> getComparator(
      Function<? super T, ? extends U> function) {
    return this == SortType.ASCEND
        ? Comparator.comparing(function)
        : Comparator.comparing(function).reversed();
  }

  public static SortType from(String sortName) {
    return Arrays.stream(values())
        .filter(value -> value.name().equalsIgnoreCase(sortName))
        .findFirst()
        .orElse(ASCEND);
  }
}
