package com.gabrielguimaraes.generativeaicase01.system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

  @GetMapping("/")
  public String root() {
    return "SERVICE IS UP";
  }
}
