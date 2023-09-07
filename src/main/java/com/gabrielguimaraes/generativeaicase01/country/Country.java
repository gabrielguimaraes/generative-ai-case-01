package com.gabrielguimaraes.generativeaicase01.country;

import java.util.List;

public record Country(
    CountryName name, List<String> capital, String region, long area, long population) {}
